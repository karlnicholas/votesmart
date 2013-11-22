package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * addlBio.{@link CandidateMed},  
 * addlBio.additional.item*.name, 
 * addlBio.additional.item*.data.
 * </pre>
 *
 */
@XmlRootElement(name="addlBio")
public class AddlBio extends GeneralInfoBase {
	public CandidateMed candidate;
	public Additional additional;
	
	public static class Additional {
		public ArrayList<Item> item;
		
		@XmlType(name="item", namespace="addlBio")
		public static class Item {
			public String name;
			public String data;
		}
	}
}
