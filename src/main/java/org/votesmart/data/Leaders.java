package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output
 * leaders.leader*.candidateId, 
 * leaders.leader*.firstName, 
 * leaders.leader*.middleName, 
 * leaders.leader*.lastName, 
 * leaders.leader*.suffix, 
 * leaders.leader*.position, 
 * leaders.leader*.officeId, 
 * leaders.leader*.title.
 * </pre>
 */
@XmlRootElement(name="leaders")
public class Leaders extends GeneralInfoBase {
	
	public ArrayList<Leader> leader;
	
	@XmlType(name="leader", namespace="leaders")
	public static class Leader {
		public String candidateId;
		public String firstName;
		public String middleName;
		public String lastName;
		public String suffix;
		public String position;
		public String officeId;
		public String title;
	}
}
