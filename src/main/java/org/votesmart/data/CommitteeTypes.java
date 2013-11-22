package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * committeeTypes.type*.committeeTypeId, 
 * committeeTypes.type*.name.
 * </pre>
 */
@XmlRootElement(name="committeeTypes")
public class CommitteeTypes extends GeneralInfoBase {
	public ArrayList<Type> type;
	
	@XmlType(name="type", namespace="committeeTypes")
	public static class Type {
		public String committeeTypeId;
		public String name;
	}
}

