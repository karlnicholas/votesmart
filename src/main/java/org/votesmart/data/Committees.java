package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * committees.committee*.committeeId, 
 * committees.committee*.parentId, 
 * committees.committee*.stateId, 
 * committees.committee*.committeeTypeId, 
 * committees.committee*.name.
 * </pre>
 */
@XmlRootElement(name="committees")
public class Committees extends GeneralInfoBase {
	public ArrayList<Committee> committee;
	
	@XmlType(name="committee", namespace="committees")
	public static class Committee {
		public String committeeId;
		public String parentId;
		public String stateId;
		public String committeeTypeId;
		public String name;
	}
}
