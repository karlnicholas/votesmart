package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * stagecandidates.election*.electionId, 
 * stagecandidates.election*.name, 
 * stagecandidates.election*.stage,
 * stagecandidates.election*.stateId, 
 * stagecandidates.candidate*.candidateId, 
 * stagecandidates.candidate*.officeId, 
 * stagecandidates.candidate*.district, 
 * stagecandidates.candidate*.firstName, 
 * stagecandidates.candidate*.middleName, 
 * stagecandidates.candidate*.lastName, 
 * stagecandidates.candidate*.suffix, 
 * stagecandidates.candidate*.party, 
 * stagecandidates.candidate*.status, 
 * stagecandidates.candidate*.voteCount,
 * stagecandidates.candidate*.votePercent.
 * </pre>
 */
@XmlRootElement(name="stagecandidates")
public class StageCandidates extends GeneralInfoBase {

	public ArrayList<Election> election;	
	public ArrayList<Candidate> candidate;
	
	@XmlType(name="election", namespace="stagecandidates")
	public static class Election {
		public String electionId;
		public String name;
		public String stage;
		public String stateId;
	}
	
	@XmlType(name="candidate", namespace="stagecandidates")
	public static class Candidate {
		public String candidateId;
		public String officeId;
		public String district;
		public String firstName;
		public String middleName;
		public String lastName;
		public String suffix;
		public String party;
		public String status;
		public String voteCount;
		public String votePercent;
	}
}
