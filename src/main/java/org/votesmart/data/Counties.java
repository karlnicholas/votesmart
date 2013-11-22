package org.votesmart.data;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * counties.county*.localId, 
 * counties.county*.name, 
 * counties.county*.url.
 * </pre>
 */
@XmlRootElement(name="counties")
public class Counties extends GeneralInfoBase {
	
	public ArrayList<County> county;

	@XmlType(name="county", namespace="counties")
	public static class County {
		public String localId;
		public String name;
		public URL url;	
	}	
}

