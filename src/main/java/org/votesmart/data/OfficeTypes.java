package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * officeTypes.type*.officeTypeId, 
 * officeTypes.type*.officeLevelId, 
 * officeTypes.type*.officeBranchId, 
 * officeTypes.type*.name.
 * </pre>
 */
@XmlRootElement(name="officeTypes")
public class OfficeTypes extends GeneralInfoBase {
	public ArrayList<Type> type;
	
	@XmlType(name="type", namespace="office")
	public static class Type {
		public String officeTypeId;
		public String officeLevelId;
		public String officeBranchId;
		public String name;
	}
}

