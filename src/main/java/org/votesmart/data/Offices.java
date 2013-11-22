package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * offices.office*.officeId, 
 * offices.office*.officeTypeId, 
 * offices.office*.officeLevelId, 
 * offices.office*.officeBranchId, 
 * offices.office*.name, 
 * offices.office*.title, 
 * offices.office*.shortTitle.
 * </pre>
 */
@XmlRootElement(name="offices")
public class Offices extends GeneralInfoBase {
	public ArrayList<Office> office;
	
	@XmlType(name="office", namespace="offices")
	public static class Office {
		public String officeId;
		public String officeTypeId;
		public String officeLevelId;
		public String officeBranchId;
		public String name;
		public String title;
		public String shortTitle;		
	}

}

