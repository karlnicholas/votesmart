package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output:
 * branches.branch*.officeBranchId, 
 * branches.branch*.name.
 * </pre>
 *
 */
@XmlRootElement(name="branches")
public class Branches extends GeneralInfoBase {
	
	public ArrayList<Branch> branch;
	
	@XmlType(name="branch", namespace="branches")
	public static class Branch {
		public String officeBranchId;
		public String name;
	}

}
