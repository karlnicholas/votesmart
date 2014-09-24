package org.votesmart.data;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output:
 * candidateList.zipMessage
 * candidateList.candidate*.candidateId
 * candidateList.candidate*.firstName
 * candidateList.candidate*.nickName
 * candidateList.candidate*.middleName
 * candidateList.candidate*.preferredName
 * candidateList.candidate*.lastName
 * candidateList.candidate*.suffix
 * candidateList.candidate*.title
 * candidateList.candidate*.officeParties
 * candidateList.candidate*.officeStatus
 * candidateList.candidate*.officeDistrictId
 * candidateList.candidate*.officeDistrictName
 * candidateList.candidate*.officeTypeId
 * candidateList.candidate*.officeI
 * candidateList.candidate*.officeName
 * candidateList.candidate*.officeStateId
 * </pre>
 */
@XmlRootElement(name="candidateList")
public class CandidateList extends GeneralInfoBase {
    public String zipMessage;
    public List<Candidate> candidate;
    
	@XmlType(name="candidate", namespace="candidateList")
    public static class Candidate extends CandidateMed {
        public String candidateId;
        public String prefferedName;
        public String officeParties;
        public String officeStatus;
        public String officeDistrictId;
        public String officeDistrictName;
        public String officeTypeId;
        public String officeId;
        public String officeName;
        public String officeStateId;
    }
    
}
