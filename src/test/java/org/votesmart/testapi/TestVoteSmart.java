package org.votesmart.testapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.votesmart.api.ArgMap;
import org.votesmart.api.VoteSmartErrorException;
import org.votesmart.api.VoteSmartException;
import org.votesmart.data.ErrorBase;

/**
 * TestVoteSmart. 
 * 
 * This class will load from a zip file in the (test) resources directory
 * and unmarshall the XML documents inside. It is used with 
 * {@link TestVoteSmartBase}
 *
 */
public class TestVoteSmart {
    private Unmarshaller unmarshaller;
    private char[] buffer;
    private TreeMap<String, ZipEntry> mapEntries;
    private ZipFile zipFile;

	public TestVoteSmart(ResourceBundle bundle) {
		mapEntries = new TreeMap<String, ZipEntry>();

		try {
			
			zipFile = new ZipFile( TestVoteSmart.class.getResource("/AllThingsCalifornia.zip").getFile() );

			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while ( entries.hasMoreElements() ) {
				ZipEntry entry = entries.nextElement();
				mapEntries.put(entry.getName(), entry);
			}
			
			unmarshaller = JAXBContext.newInstance( "org.votesmart.data" ).createUnmarshaller();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// arbitrary large value
		buffer = new char[ 262144 ];
	}

	/**
	 * Queries the API server for the information requested
	 * 
	 * @param method
	 *            The method to be called on the API Server
	 * @param args
	 *            An IdentityHashMap<String, String> of the arguments for the
	 *            method
	 * @return The XML document as a XOM Document.
	 * 
	 * @throws VoteSmartException 
	 * @throws VoteSmartErrorException 
	 */
	public <T> T query(String method, ArgMap argMap, Class<T> responseType) throws VoteSmartException, VoteSmartErrorException {
	
		try {
			StringBuilder filename = new StringBuilder( method );
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
			filename.append(".xml" );
	
			ZipEntry entry = mapEntries.get(filename.toString());
			
			BufferedReader breader = new BufferedReader(new InputStreamReader( zipFile.getInputStream(entry), Charset.forName("UTF-8") ) );
			StringBuilder XMLBuilder = new StringBuilder();
			
			int read;
			while ( (read = breader.read(buffer)) != -1 ) {
				XMLBuilder.append(buffer, 0, read);
			}
			breader.close();
			String XMLStr = XMLBuilder.toString();
			StringReader reader = new StringReader(XMLStr);
		
	        JAXBElement<T> e = unmarshaller.unmarshal(new StreamSource(reader), responseType);
	
	        if ( e.getName().getLocalPart().equals("error") ) {
		        ErrorBase error = unmarshaller.unmarshal( new StreamSource( reader = new StringReader(XMLStr) ), ErrorBase.class ).getValue();  
				throw new VoteSmartErrorException(error, method, argMap);
	        } else {
	        	return e.getValue();
	        }
		} catch (IOException e) {
			throw new VoteSmartException(e);
		} catch (JAXBException e) {
			throw new VoteSmartException(e);
		}
	}
	
	public void destroy() {
		try {
			zipFile.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
	}
}
