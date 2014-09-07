package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * bio.candidate.crpId (OpenSecrets ID), 
 *  bio.candidate.firstName, 
 *  bio.candidate.nickName, 
 *  bio.candidate.middleName, 
 *  bio.candidate.lastName, 
 *  bio.candidate.suffix, 
 *  bio.candidate.birthDate, 
 *  bio.candidate.birthPlace, 
 *  bio.candidate.pronunciation, 
 *  bio.candidate.gender, 
 *  bio.candidate.family, 
 *  bio.candidate.photo, 
 *  bio.candidate.homeCity, 
 *  bio.candidate.homeState, 
 *  bio.candidate.education, 
 *  bio.candidate.profession, 
 *  bio.candidate.political, 
 *  bio.candidate.religion, 
 *  bio.candidate.congMembership, 
 *  bio.candidate.orgMembership, 
 *  bio.candidate.specialMsg, 
 *  bio.office.parties, 
 *  bio.office.title, 
 *  bio.office.shortTitle, 
 *  bio.office.name, 
 *  bio.office.type, 
 *  bio.office.status, 
 *  bio.office.firstElect, 
 *  bio.office.lastElect, 
 *  bio.office.nextElect, 
 *  bio.office.termStart, 
 *  bio.office.termEnd, 
 *  bio.office.district, 
 *  bio.office.districtId, 
 *  bio.office.stateId, 
 *  bio.office.committee*.committeeId, 
 *  bio.office.committee*.committeeName, 
 *  bio.election*.office, 
 *  bio.election*.officeId, 
 *  bio.election*.officeType, 
 *  bio.election*.parties, 
 *  bio.election*.district, 
 *  bio.election*.districtId, 
 *  bio.election*.status, 
 *  bio.election*.ballotName.
 *  </pre>
 *
 */
@XmlRootElement(name="bioold")
public class BioOld extends GeneralInfoBase {
	public Candidate candidate;
	public Office office;
	public ArrayList<Election> election;
	
	@XmlType(name="candidate", namespace="bioold")
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
 		 public String education;
 		 public String profession;
 		 public String political;
 		 public String religion;
 		 public String congMembership;
 		 public String orgMembership;
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
 	
	@XmlType(name="election", namespace="bio")
 	public static class Election {
 		 public String office;
 		 public String officeId;
 		 public String officeType;
 		 public String parties;
 		 public String district;
 		 public String districtId;
 		 public String status;
 		 public String ballotName;
 	}

}

