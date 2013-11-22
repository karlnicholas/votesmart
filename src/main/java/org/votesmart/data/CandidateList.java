package org.votesmart.data;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output:
 * candidateList.candidate*.candidateId, 
 * candidateList.candidate*.preferredName, 
 * candidateList.candidate*.{@link CandidateMed}, 
 * candidateList.candidate*.ballotName, 
 * candidateList.candidate*.electionParties, 
 * candidateList.candidate*.electionStatus, 
 * candidateList.candidate*.electionStage, 
 * candidateList.candidate*.electionDistrictId, 
 * candidateList.candidate*.electionDistrictName, 
 * candidateList.candidate*.electionOffice, 
 * candidateList.candidate*.electionOfficeId, 
 * candidateList.candidate*.electionStateId, 
 * candidateList.candidate*.electionOfficeTypeId, 
 * candidateList.candidate*.electionYear, 
 * candidateList.candidate*.electionSpecial, 
 * candidateList.candidate*.electionDate, 
 * candidateList.candidate*.officeParties, 
 * candidateList.candidate*.officeStatus, 
 * candidateList.candidate*.officeDistrictId, 
 * candidateList.candidate*.officeDistrictName, 
 * candidateList.candidate*.officeStateId, 
 * candidateList.candidate*.officeId, 
 * candidateList.candidate*.officeName, 
 * candidateList.candidate*.officeTypeId, 
 * candidateList.candidate*.runningMateId, 
 * candidateList.candidate*.runningMateName.
 * </pre>
 *
 */
@XmlRootElement(name="candidateList")
public class CandidateList extends GeneralInfoBase {
    public String zipMessage;
    public List<Candidate> candidate;
    
	@XmlType(name="candidate", namespace="candidateList")
    public static class Candidate extends CandidateMed {
        public String candidateId;
        public String preferredName;
        public String ballotName;
        public String electionParties;
        public String electionStatus;
        public String electionStage;
        public String electionDistrictId;
        public String electionDistrictName;
        public String electionOffice;
        public String electionOfficeId;
        public String electionStateId;
        public String electionOfficeTypeId;
        public String electionYear;
        public String electionSpecial;
        public String electionDate;
        public String officeParties;
        public String officeStatus;
        public String officeDistrictId;
        public String officeDistrictName;
        public String officeStateId;
        public String officeId;
        public String officeName;
        public String officeTypeId;
        public String runningMateId;
        public String runningMateName;        
    }
    
}
