package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * committeeMembers.committee.committeeId, 
 * committeeMembers.committee.parentId, 
 * committeeMembers.committee.name, 
 * committeeMembers.member*.candidateId, 
 * committeeMembers.member*.title, 
 * committeeMembers.member*.firstName, 
 * committeeMembers.member*.middleName, 
 * committeeMembers.member*.lastName, 
 * committeeMembers.member*.suffix, 
 * committeeMembers.member*.party, 
 * committeeMembers.member*.position.
 * </pre>
 *
 */
@XmlRootElement(name="committeeMembers")
public class CommitteeMembers extends GeneralInfoBase {
	public Committee committee;
	public ArrayList<Member> member;

	@XmlType(name="commiittee", namespace="committeeMembers")
	public static class Committee {
		public String committeeId;
		public String parentId;
		public String name;
	}
	@XmlType(name="member", namespace="committeeMembers")
	public static class Member {
		public String candidateId;
		public String title;
		public String firstName;
		public String middleName;
		public String lastName;
		public String suffix;
		public String party;
		public String position;
	}

}
