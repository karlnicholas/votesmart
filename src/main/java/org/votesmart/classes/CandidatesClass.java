package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.CandidateList;

/**
 * <pre>
 * Candidates Class
 * 
 * * - Required
 * * - Multiple rows
 * 
 * Candidates.getByOfficeState()
 * This method grabs a list of candidates according to office and state representation.
 * Input: officeId*, stateId(default: 'NA'), electionYear(default: >= current year), stageId
 * Output: {@link CandidateList}
 * 
 * Candidates.getByOfficeTypeState()
 * This method grabs a list of candidates according to office type and state representation.
 * Input: officeTypeId*, stateId(default: 'NA'), electionYear(default: >= current year), stageId
 * Output: {@link CandidateList}
 * 
 * Candidates.getByLastname()
 * This method grabs a list of candidates according to a lastname match.
 * Input: lastName*, electionYear(default: >= current year), stageId
 * Output: {@link CandidateList}
 * 
 * Candidates.getByLevenshtein()
 * This method grabs a list of candidates according to a fuzzy lastname match.
 * Input: lastName*, electionYear(default: >= current year), stageId
 * Output: {@link CandidateList}
 * 
 * Candidates.getByElection()
 * This method grabs a list of candidates according to the election they are running in.
 * Input: electionId*, stageId
 * Output: {@link CandidateList}
 * 
 * Candidates.getByDistrict()
 * This method grabs a list of candidates according to the district they represent.
 * Input: districtId*, electionYear(default: >= current year), stageId
 * Output: {@link CandidateList}
 * 
 * Candidates.getByZip()
 * This method grabs a list of candidates according to the zip code they represent.
 * Input: zip5*, electionYear(default: >= current year), zip4(default: NULL), stageId
 * Output: {@link CandidateList}
 * 
 * ========= EXAMPLE USAGE =============
 * 
 * CandidatesClass candidatesClass = new CandidatesClass();
 * 
 * // Candidates for last office, for state
 * CandidateList candidates = candidatesClass.getByOfficeState(office.officeId, state.stateId);
 * 
 * // Candidates for last office, for state
 * candidates = candidatesClass.getByOfficeTypeState(officeType.officeTypeId, state.stateId);
 *</pre>
 */
public class CandidatesClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public CandidatesClass(VoteSmartAPI api) {
		super(api);
	}
	
	/**
	 * Default Constructor
	 */
	public CandidatesClass() throws VoteSmartException {
		super();
	}

	/**
	 * This method grabs a list of candidates according to office and state representation.
	 * 
	 * @param officeId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByOfficeState(String officeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByOfficeState", new ArgMap("officeId", officeId), CandidateList.class );
	}
	
	/**
	 * This method grabs a list of candidates according to office and state representation.
	 * 
	 * @param officeId
	 * @param stateId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByOfficeState(String officeId, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByOfficeState", new ArgMap("officeId", officeId, "stateId", stateId), CandidateList.class );
	}
	
	/**
	 * This method grabs a list of candidates according to office and state representation.
	 * 
	 * @param officeId
	 * @param stateId
	 * @param electionYear
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByOfficeState(String officeId, String stateId, String electionYear) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByOfficeState", new ArgMap("officeId", officeId, "stateId", stateId, "electionYear", electionYear), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to office and state representation.
	 * 
	 * @param officeId
	 * @param stateId
	 * @param electionYear
	 * @param stageId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByOfficeState(String officeId, String stateId, String electionYear, String stageId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByOfficeState", new ArgMap("officeId", officeId, "stateId", stateId, "electionYear", electionYear, "stageId", stageId), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to office type and state representation.
	 * 
	 * @param officeTypeId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByOfficeTypeState(String officeTypeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByOfficeTypeState", new ArgMap("officeTypeId", officeTypeId), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to office type and state representation.
	 * 
	 * @param officeTypeId
	 * @param stateId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByOfficeTypeState(String officeTypeId, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByOfficeTypeState", new ArgMap("officeTypeId", officeTypeId, "stateId", stateId), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to office type and state representation.
	 * 
	 * @param officeTypeId
	 * @param stateId
	 * @param electionYear
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByOfficeTypeState(String officeTypeId, String stateId, String electionYear) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByOfficeTypeState", new ArgMap("officeTypeId", officeTypeId, "stateId", stateId, "electionYear", electionYear), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to office type and state representation.
	 * 
	 * @param officeTypeId
	 * @param stateId
	 * @param electionYear
	 * @param stageId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByOfficeTypeState(String officeTypeId, String stateId, String electionYear, String stageId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByOfficeTypeState", new ArgMap("officeTypeId", officeTypeId, "stateId", stateId, "electionYear", electionYear, "stageId", stageId), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to a lastname match.
	 * 
	 * @param lastName
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByLastname(String lastName) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByLastname", new ArgMap("lastName", lastName), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to a lastname match.
	 * 
	 * @param lastName
	 * @param electionYear
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByLastname(String lastName, String electionYear) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByLastname", new ArgMap("lastName", lastName, "electionYear", electionYear), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to a lastname match.
	 * 
	 * @param lastName
	 * @param electionYear
	 * @param stageId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByLastname(String lastName, String electionYear, String stageId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByLastname", new ArgMap("lastName", lastName, "electionYear", electionYear, "stageId", stageId), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to a fuzzy lastname match.
	 * 
	 * @param lastName
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByLevenshtein(String lastName) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByLevenshtein", new ArgMap("lastName", lastName), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to a fuzzy lastname match.
	 * 
	 * @param lastName
	 * @param electionYear
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByLevenshtein(String lastName, String electionYear) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByLevenshtein", new ArgMap("lastName", lastName, "electionYear", electionYear), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to a fuzzy lastname match.
	 * 
	 * @param lastName
	 * @param electionYear
	 * @param stageId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByLevenshtein(String lastName, String electionYear, String stageId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByLevenshtein", new ArgMap("lastName", lastName, "electionYear", electionYear, "stageId", stageId), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to a fuzzy lastname match.
	 * 
	 * @param electionId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByElection(String electionId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByElection", new ArgMap("electionId", electionId), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to a fuzzy lastname match.
	 * 
	 * @param electionId
	 * @param stageId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByElection(String electionId, String stageId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByElection", new ArgMap("electionId", electionId, "stageId", stageId), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to the district they represent.
	 * 
	 * @param districtId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByDistrict(String districtId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByDistrict", new ArgMap("districtId", districtId), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to the district they represent.
	 * 
	 * @param districtId
	 * @param electionYear
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByDistrict(String districtId, String electionYear) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByDistrict", new ArgMap("districtId", districtId, "electionYear", electionYear), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to the district they represent.
	 * 
	 * @param districtId
	 * @param electionYear
	 * @param stageId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByDistrict(String districtId, String electionYear, String stageId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByDistrict", new ArgMap("districtId", districtId, "electionYear", electionYear, "stageId", stageId), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to the district they represent.
	 * 
	 * @param zip5
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByZip(String zip5) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByZip", new ArgMap("zip5", zip5), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to the district they represent.
	 * 
	 * @param zip5
	 * @param electionYear
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByZip(String zip5, String electionYear) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByZip", new ArgMap("zip5", zip5, "electionYear", electionYear), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to the district they represent.
	 * 
	 * @param zip5
	 * @param electionYear
	 * @param zip4
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByZip(String zip5, String electionYear, String zip4) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByZip", new ArgMap("zip5", zip5, "electionYear", electionYear, "zip4", zip4), CandidateList.class );
	}

	/**
	 * This method grabs a list of candidates according to the district they represent.
	 * 
	 * @param zip5
	 * @param electionYear
	 * @param zip4
	 * @param stageId
	 * @return {@link CandidateList}: list of detailed candidate information.
	 */
	public CandidateList getByZip(String zip5, String electionYear, String zip4, String stageId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Candidates.getByZip", new ArgMap("zip5", zip5, "electionYear", electionYear, "zip4", zip4, "stageId", stageId), CandidateList.class );
	}

	
}
