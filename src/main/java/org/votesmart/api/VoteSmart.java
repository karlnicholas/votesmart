package org.votesmart.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ResourceBundle;
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
 * 
 *
 */
public class VoteSmart implements VoteSmartAPI {
	private static final Logger logger = Logger.getLogger(VoteSmart.class.getName());
	public static final String apikeyKey = "apikey";
	public static final String cacheKey = "cache";
	private static String apiKey = null;
	private static String apiServer = "api.votesmart.org";
	private static String cache;
    private static Unmarshaller unmarshaller;
    private static boolean checkCache;
    private static boolean suspendCache;

    /**
     * Initialize the API. Called instead of a constructor.
     * 
     * @param bundle
     */
	public VoteSmart(ResourceBundle bundle) throws VoteSmartException {
		// API not needed for testing
		if ( !bundle.containsKey(apikeyKey)) throw new VoteSmartException("No apikey found in openstates.properties");
		apiKey = bundle.getString(apikeyKey);
		if ( apiKey == null ) throw new VoteSmartException("apikey not set in openstates.properties");
		if ( bundle.containsKey(cacheKey)) {
			cache = bundle.getString(cacheKey);
			if ( cache.lastIndexOf('/') != (cache.length()-1)) cache = cache+"/";
			File cacheFile = new File(cache);
			logger.config("cache directory:" + cacheFile.toString());
			if ( !cacheFile.exists() ) {
				logger.config("Creating directories for cache:" + cacheFile.toString());
				cacheFile.mkdirs();
			}
		}
		checkCache = true;
		suspendCache = false;
		try {
			unmarshaller = JAXBContext.newInstance( "org.votesmart.data" ).createUnmarshaller();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Modify whether or not the cache is first checked for files.
	 * Note that any JSON read will always be written to the
	 * cache.
	 *
	 * @param checkCache the check cache
	 */
	public static void setCache(boolean checkCache) {
		if ( VoteSmart.checkCache != checkCache ) logger.fine("Setting checkCache to " + checkCache );
		VoteSmart.checkCache = checkCache;
	}

	/**
	 * Get the current state of the caching flag
	 * 
	 * @return the current state of the caching flag
	 */
	public static boolean getCache() {
		return VoteSmart.checkCache;
	}
	
	/**
	 * Disable caching for one call, and one call only.
	 * 
	 * This call disables caching for the next call 
	 * regardless of the current state of caching. It 
	 * does not disable the current state of caching.  
	 * 
	 */
	public static void suspendCache() {
		VoteSmart.suspendCache = true;
	}
	
	/**
	 * Queries the API server for the information requested
	 * 
	 * @param method
	 * @param argMap
	 * @param responseType
	 * @throws VoteSmartErrorException 
	 * 
	 */
	public <T> T query(String method, ArgMap argMap, Class<T> responseType) throws VoteSmartException, VoteSmartErrorException {
		BufferedReader reader = null;
		HttpURLConnection conn = null;
		String charSet = "utf-8";
		try {
			if ( isCaching(method, argMap) ) {
				File file = getCacheFile(method, argMap);
	
				long fileLength = file.length(); 
				logger.fine("Length of File in cache:" + fileLength + ": " + file.getName());
				if ( fileLength == 0L ) {
					VoteSmart.cacheFileFromAPI(method, argMap, file);
				}
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charSet));
			} else {
				conn = VoteSmart.getConnectionFromAPI(method, argMap);
				charSet = getCharset(conn);
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), charSet));
			}

	        JAXBElement<T> e = unmarshaller.unmarshal( new StreamSource( reader ), responseType );
	        if ( e.getName().getLocalPart().equals("error") ) {
//		        ErrorBase error = unmarshaller.unmarshal( new StreamSource( reader = new StringReader(XMLStr) ), ErrorBase.class ).getValue();
	        	throw new VoteSmartErrorException( ((ErrorBase)e.getValue()), method, argMap );
	        } else {
	        	return e.getValue();
	        }
/*
 	        Object o = unmarshaller.unmarshal( new StreamSource( reader ) );
	        if ( o instanceof ErrorBase ) {
	        	throw new VoteSmartErrorException((ErrorBase) o, method, argMap);
	        } else {
		        @SuppressWarnings("unchecked")
				T e = (T) o;
		        return e;
	        }
*/	        
		} catch ( JAXBException e ) {
			throw new VoteSmartException(e);
		} catch (URISyntaxException e) {
			throw new VoteSmartException(e);
		} catch (IOException e) {
			throw new VoteSmartException(e);
		} finally {
			suspendCache = false;
			if ( conn != null ) conn.disconnect();
			if ( reader != null ) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new VoteSmartException(e);
				}
			}
		}
	}

	private boolean isCaching(String method, ArgMap argMap) {
		if ( VoteSmart.cache == null ) return false;
		if ( VoteSmart.suspendCache == true ) return false;
		if ( VoteSmart.checkCache == false ) return false;
		return true;
	}
	
	private static File getCacheFile(String method, ArgMap argMap) {
		StringBuilder filename = new StringBuilder( VoteSmart.cache + method);
		// do args if any
		if ( argMap!= null ) {
			for (String key: argMap.keySet() )
			{
				String value = argMap.get(key);
				if ( value == null ) continue;
				filename.append('.');
				filename.append( key );
				filename.append('.');
				filename.append( value );
			}
		} 
		filename.append(".xml" );
	
		// return a file object
		return new File(filename.toString());
	}
	
	private static void cacheFileFromAPI(String method, ArgMap argMap, File file) throws URISyntaxException, IOException, VoteSmartException {
		BufferedReader breader = null;
		BufferedWriter bwriter = null;
		HttpURLConnection conn = null;
		try {
		    char[] buffer = new char[2^13];
			conn = getConnectionFromAPI(method, argMap);
			String charSet = getCharset(conn);
			breader = new BufferedReader(new InputStreamReader( conn.getInputStream(), charSet ) );
			bwriter = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(file), Charset.forName("utf-8")) );
			int read;
			while ( (read = breader.read(buffer)) != -1 ) {
				bwriter.write(buffer, 0, read);
			}
		} finally {
			if ( conn != null ) conn.disconnect();
			if ( bwriter != null ) bwriter.close();
			if ( breader != null ) breader.close();
		}
	}
	
	private static HttpURLConnection getConnectionFromAPI(String method, ArgMap argMap) throws URISyntaxException, IOException, VoteSmartException {
	    HttpURLConnection con = null;
			StringBuilder terms = new StringBuilder();
		// Iterate through the keys and their values, both are important
		if ( argMap != null ) {
			for (String key: argMap.keySet() )
			{
				String value = argMap.get(key);
				if ( value == null ) continue;
				terms.append( '&' )
				.append( key )
				.append('=' )
				.append( value );		// URL encoding is done by the URI constructor
			}
		}
			
		// construct the URI ..
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
		
		con = (HttpURLConnection) uri.toURL().openConnection();
	    con.setRequestMethod("GET");
	    con.setRequestProperty("Accept", "text/xml, application/xml");
	    con.connect();
	    return con;
	}
	
	private static String getCharset(HttpURLConnection con) throws VoteSmartException, IOException {
	    // better check it first
	    if (con.getResponseCode() / 100 != 2) {
	    	String msg = con.getResponseMessage();
	    	con.disconnect();
	    	throw new VoteSmartException(msg);
	    }
	    String contentType = con.getHeaderField("Content-Type");
	    String charset = null;
	    for (String param : contentType.replace(" ", "").split(";")) {
	        if (param.startsWith("charset=")) {
	            charset = param.split("=", 2)[1];
	            break;
	        }
	    }
	    if ( charset == null ) {
	    	logger.fine("Defaulting to utf-8 charset");
	    	charset = "utf-8";
	    }
	    return charset;
	}
}
