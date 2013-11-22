package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output:
 * votes.vote*.candidateId, 
 * votes.vote*.candidateName, 
 * votes.vote*.officeParties, 
 * votes.vote*.action.
 * </pre>
 *
 */
@XmlRootElement(name="votes")
public class BillActionVotes extends GeneralInfoBase {
	
	public ArrayList<Vote> vote;
	
	@XmlType(name="vote", namespace="votes")
	public static class Vote {
		public String candidateId;
		public String candidateName;
		public String officeParties;
		public String action;
	}
}


