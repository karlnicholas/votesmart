package org.votesmart.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.votesmart.data.ErrorBase;

/**
 * VoteSmart API. This is a fully static class so that
 * it gets initialized once and then any API class 
 * will not have to initialize it again.
 *
 */
public class VoteSmart implements VoteSmartAPI {
	private static final Logger logger = Logger.getLogger(VoteSmart.class.getName());
	private String apiKey = null;
	private String apiServer = "api.votesmart.org";
	private String cache;
    private Unmarshaller unmarshaller;
    private char[] buffer;
    private static boolean checkCache;

    /**
     * Initialize the API. Called instead of a constructor.
     * 
     * @param bundle
     */
	public VoteSmart(ResourceBundle bundle) {
		if ( bundle.containsKey("loglevel") ) {
			String loglevel = bundle.getString("loglevel");
			Level level = Level.INFO;
			if ( loglevel.equals(Level.OFF)) level = Level.OFF;
			else if ( loglevel.equals(Level.SEVERE.toString())) level = Level.SEVERE;
			else if ( loglevel.equals(Level.WARNING.toString())) level = Level.WARNING;
			else if ( loglevel.equals(Level.INFO.toString())) level = Level.INFO;
			else if ( loglevel.equals(Level.CONFIG.toString())) level = Level.CONFIG;
			else if ( loglevel.equals(Level.FINE.toString())) level = Level.FINE;
			else if ( loglevel.equals(Level.FINER.toString())) level = Level.FINER;
			else if ( loglevel.equals(Level.FINEST.toString())) level = Level.FINEST;
			else if ( loglevel.equals(Level.ALL.toString())) level = Level.ALL;

			logger.config("Setting global logging level to :" + level.toString() );
		    //get the top Logger:
		    Logger topLogger = java.util.logging.Logger.getLogger("");
		    topLogger.setLevel(level);

		    for(Handler h : topLogger.getHandlers()){
	            h.setLevel(level);
		    } 
		}
		// API not needed for testing
		apiKey = bundle.getString("apikey");
		cache = bundle.getString("cache");
		if ( cache.lastIndexOf('/') != (cache.length()-1)) cache = cache+"/";
		File cacheFile = new File(cache);
		if ( !cacheFile.exists() ) {
			logger.config("Creating directories for cache:" + cacheFile.toString());
			cacheFile.mkdirs();
		}
		checkCache = true;
		try {
			unmarshaller = JAXBContext.newInstance( "org.votesmart.data" ).createUnmarshaller();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
		// arbitrary large size (2^20)
		buffer = new char[262144];
	}
	
	/**
	 * Modify whether or not the cache is first checked for files.
	 * Note that any XML read will always be written to the
	 * cache.
	 */
	public static void checkCacheFirst(boolean checkCache) {
		if ( VoteSmart.checkCache != checkCache ) logger.fine("Changing checkCache setting to:" + checkCache );
		VoteSmart.checkCache = checkCache;
	}
	
	/**
	 * Queries the API server for the information requested
	 * 
	 * @param method
	 * @param argMap
	 * @param responseType
	 * 
	 */
	public <T> T query(String method, ArgMap argMap, Class<T> responseType) throws VoteSmartException, VoteSmartErrorException {
		try {
//			System.out.println(uri.toString());
			Reader reader;
			StringBuilder filename = new StringBuilder(cache + method );
			StringBuilder XMLBuilder = new StringBuilder();
			String XMLStr = null;
		    HttpURLConnection con = null;
			BufferedReader breader;
			if ( argMap!= null ) {
				for (String key: argMap.keySet() )
				{
					String value = argMap.get(key);
					filename.append('.');
					filename.append( key );
					filename.append('.');
					filename.append( value );
				}
			}
			// save this for later
			//filename.append(".xml" );

			File file = new File(filename.toString() + ".xml");

			long fileLength = file.length(); 
			logger.fine("Length of File in cache:" + fileLength + ": " + filename.toString());
			if ( fileLength == 0L || VoteSmart.checkCache == false ) {
				StringBuilder terms = new StringBuilder();
				// Iterate through the keys and their values, both are important
				if ( argMap != null ) {
					for (String key: argMap.keySet() )
					{
						String value = argMap.get(key);
						terms.append( '&' );
						terms.append( key );
						terms.append('=' );
						terms.append( URLEncoder.encode(value, "UTF-8" ) );
					}
				}
				
				// construct the url ..
				URI uri = new URI(
					"http", 
					null,
					apiServer, 
					-1,
					"/" + method, 
					"key=" + apiKey + "&output=XML" + terms.toString(), 
					null
				);
				logger.fine(uri.toString());
				
				URLConnection urlCon = uri.toURL().openConnection();
			    con = (HttpURLConnection)urlCon;
			    con.addRequestProperty("Accept", "text/xml, application/xml");
			    con.connect();
				breader = new BufferedReader(new InputStreamReader( con.getInputStream(), Charset.forName("UTF-8") ) );
			} else {
				breader = new BufferedReader(new InputStreamReader( new FileInputStream(file), Charset.forName("UTF-8") ) );
			}
			
			int read;
			while ( (read = breader.read(buffer)) != -1 ) {
				XMLBuilder.append(buffer, 0, read);
			}
			breader.close();
			XMLStr = XMLBuilder.toString();
			reader = new StringReader(XMLStr);
			
        	if ( fileLength == 0 ) {
        		con.disconnect();
				BufferedWriter bwriter = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(file), Charset.forName("UTF-8")) );
				bwriter.write(XMLStr);
				bwriter.close();
        	}

	        JAXBElement<T> e = unmarshaller.unmarshal( new StreamSource( reader ), responseType );
	        if ( e.getName().getLocalPart().equals("error") ) {
		        ErrorBase error = unmarshaller.unmarshal( new StreamSource( reader = new StringReader(XMLStr) ), ErrorBase.class ).getValue();  
				throw new VoteSmartErrorException(error, method, argMap);
	        } else {
	        	return e.getValue();
	        }
		} catch (URISyntaxException e) {
			throw new VoteSmartException(e);
		} catch (UnsupportedEncodingException e) {
			throw new VoteSmartException(e);
		} catch (MalformedURLException e) {
			throw new VoteSmartException(e);
		} catch (IOException e) {
			throw new VoteSmartException(e);
		} catch (JAXBException e) {
			throw new VoteSmartException(e);
		}
	}
}
