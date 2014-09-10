package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * This method expands on getBio() by expanding the 
 * education, profession, political, orgMembership, 
 * and congMembership elements.
 * 
 * Output: 
 * Includes all elements for getBio(), and expands upon the following: 
 * 
 *  bio.candidate.education*.degree
 *  bio.candidate.education*.field
 *  bio.candidate.education*.school
 *  bio.candidate.education*.span
 *  bio.candidate.education*.gpa
 *  bio.candidate.profession*.title
 *  bio.candidate.profession*.organization
 *  bio.candidate.profession*.span
 *  bio.candidate.profession*.special
 *  bio.candidate.profession*.district
 *  bio.candidate.profession*.fullText
 *  bio.candidate.political*.title
 *  bio.candidate.political*.organization
 *  bio.candidate.political*.span
 *  bio.candidate.political*.special
 *  bio.candidate.political*.district
 *  bio.candidate.political*.fullText
 *  bio.candidate.congMembership*.title
 *  bio.candidate.congMembership*.organization
 *  bio.candidate.congMembership*.span
 *  bio.candidate.congMembership*.special
 *  bio.candidate.congMembership*.district
 *  bio.candidate.congMembership*.fullText
 *  bio.candidate.orgMembership*.title
 *  bio.candidate.orgMembership*.organization
 *  bio.candidate.orgMembership*.span
 *  bio.candidate.orgMembership*.special
 *  bio.candidate.orgMembership*.district
 *  bio.candidate.orgMembership*.fullText
 *  </pre>
 */
@XmlRootElement(name="bio")
public class Bio extends GeneralInfoBase {
	public Candidate candidate;
	public Office office;
	public ArrayList<Election> election;
	
	@XmlType(name="candidate", namespace="bio")
 	public static class Candidate {
 		 public String crpId;
 		 public String firstName;
 		 public String nickName;
 		 public String middleName;
 		 public String lastName;
 		 public String suffix;
 		 public String birthDate;
 		 public String birthPlace;
 		 public String pronunciation;
 		 public String gender;
 		 public String family;
 		 public String photo;
 		 public String homeCity;
 		 public String homeState;
 		 public Education education;
 		 public Profession profession;
 		 public Political political;
 		 public String religion;
 		 public CongMembership congMembership;
 		 public OrgMembership orgMembership;
 		 public String specialMsg;
 	}

	@XmlType(name="office", namespace="bio")
 	public static class Office {
 		 public String parties;
 		 public String title;
 		 public String shortTitle;
 		 public String name;
 		 public String type;
 		 public String status;
 		 public String firstElect;
 		 public String lastElect;
 		 public String nextElect;
 		 public String termStart;
 		 public String termEnd;
 		 public String district;
 		 public String districtId;
 		 public String stateId;
 		 public ArrayList<Committee> committee;

 		 @XmlType(name="committee", namespace="bio.office")
 		 public static class Committee {
 	 		 public String committeeId;
 	 		 public String committeeName;
 		 }
 	}
 	
	@XmlType(name="education", namespace="bio")
	public static class Education {
		public ArrayList<Institution> institution;
	}

	@XmlType(name="profession", namespace="bio")
	public static class Profession {
		public ArrayList<Experience> experience;
	}

	@XmlType(name="political", namespace="bio")
	public static class Political {
		public ArrayList<Experience> experience;
	}
	
	@XmlType(name="congMembership", namespace="bio")
	public static class CongMembership {
		public ArrayList<Experience> experience;
	}

	@XmlType(name="orgMembership", namespace="bio")
	public static class OrgMembership {
		public ArrayList<Experience> experience;
	}

	@XmlType(name="institution", namespace="bio")
	public static class Institution {
		 public String degree;
		 public String field;
		 public String school;
		 public String span;
		 public String gpa;
	}

	@XmlType(name="experience", namespace="bio")
	public static class Experience {
		 public String title;
		 public String organization;
		 public String span;
		 public String special;
		 public String district;
		 public String fullText;
	}
	
	@XmlType(name="election", namespace="bio")
	public static class Election {
		public String office;
		public String officeType;
		public String parties;
		public String district;
		public String districtId;
		public String stateId;
		public String status;
		public String ballotName;
	}

}
