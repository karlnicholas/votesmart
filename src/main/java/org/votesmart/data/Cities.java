package org.votesmart.data;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * cities.city*.localId, 
 * cities.city*.name, 
 * cities.city*.url.
 * </pre>
 *
 */
@XmlRootElement(name="cities")
public class Cities extends GeneralInfoBase {
	
	public ArrayList<City> city;
	
	@XmlType(name="city", namespace="cities")
	public static class City {
		public String localId;
		public String name;
		public URL url;
	}
}

