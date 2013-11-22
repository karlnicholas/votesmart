package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * candidatelist.candidate*.candidateId, 
 * candidatelist.candidate*.firstName, 
 * candidatelist.candidate*.nickName, 
 * candidatelist.candidate*.middleName, 
 * candidatelist.candidate*.lastName, 
 * candidatelist.candidate*.suffix, 
 * candidatelist.candidate*.title, 
 * candidatelist.candidate*.electionParties, 
 * candidatelist.candidate*.electionDistrictId, 
 * candidatelist.candidate*.electionStateId, 
 * candidatelist.candidate*.officeParties, 
 * candidatelist.candidate*.officeDistrictId, 
 * candidatelist.candidate*.officeDistrictName, 
 * candidatelist.candidate*.officeStateId, 
 * candidatelist.candidate*.officeId, 
 * candidatelist.candidate*.officeName, 
 * candidatelist.candidate*.officeTypeId.
 * </pre>
 */
@XmlRootElement(name="candidatelist")
public class LocalCandidateList extends GeneralInfoBase {
	public ArrayList<Candidate> candidate;
	
	@XmlType(name="candidate", namespace="candidatelist")
	public static class Candidate {
		public String candidateId;
		public String firstName;
		public String nickName;
		public String middleName;
		public String lastName;
		public String suffix;
		public String title;
		public String electionParties;
		public String electionDistrictId;
		public String electionStateId;
		public String officeParties;
		public String officeDistrictId;
		public String officeDistrictName;
		public String officeStateId;
		public String officeId;
		public String officeName;
		public String officeTypeId;
	}
}
