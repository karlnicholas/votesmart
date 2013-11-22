package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.CandidateList;

/**
 * <pre>
 * Officials Class
 * 
 * * - Required
 * * - Multiple rows
 * 
 * Officials.getStatewide()
 * This method grabs a list of officials according to state representation
 * Input: stateId(default: 'NA')
 * Output: {@link CandidateList}
 * 
 * Officials.getByOfficeState()
 * This method grabs a list of officials according to office and state representation.
 * Input: officeId*, stateId(default: 'NA')
 * Output: {@link CandidateList}
 * 
 * Officials.getByOfficeTypeState()
 * This method grabs a list of officials according to office type and state representation.
 * Input: officeTypeId*, stateId(default: 'NA')
 * Output: {@link CandidateList}
 * 
 * Officials.getByLastname()
 * This method grabs a list of officials according to a lastName match.
 * Input: lastName*
 * Output: {@link CandidateList}
 * 
 * Officials.getByLevenshtein()
 * This method grabs a list of officials according to a fuzzy lastName match.
 * Input: lastName*
 * Output: {@link CandidateList}
 * 
 * Officials.getByDistrict()
 * This method grabs a list of officials according to the district they are running for.
 * Input: districtId*
 * Output: {@link CandidateList}
 * 
 * Officials.getByZip()
 * This method grabs a list of officials according to the zip code they represent.
 * Input: zip5*, zip4(default: NULL)
 * Output: {@link CandidateList}
 * 
 * =============== EXAMPLE USAGE ====================
 * 
 * // Officials
 * OfficialsClass officialsClass = new OfficialsClass();
 * 
 * // Officials		
 * CandidateList candidates = officialsClass.getStatewide();
 * 
 * // Officials for State
 * candidates = officialsClass.getStatewide(state.stateId);
 * CandidateList.Candidate candidate = candidates.candidate.get(0);
 * 
 * // Officials for last officeType (Legislature), for state
 * candidates = officialsClass.getByOfficeTypeState(officeType.officeTypeId, state.stateId);
 * candidate = candidates.candidate.get(0);
 * </pre>
 * 
 */
public class OfficialsClass extends ClassesBase {

	/**
	 * Constructor for testing purposes
	 * 
	 * @param api
	 */
	public OfficialsClass(VoteSmartAPI api) {
		super(api);
	}

	/**
	 * Default constructor
	 */
	public OfficialsClass() {
		super();
	}

	/**
	 * This method grabs a list of officials according to state representation.
	 * 
	 * @return {@link CandidateList}
	 */
	public CandidateList getStatewide() throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getStatewide", null, CandidateList.class );
	}
	
	/**
	 * This method grabs a list of officials according to state representation.
	 * 
	 * @param stateId
	 * @return {@link CandidateList}
	 */
	public CandidateList getStatewide(String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getStatewide", new ArgMap("stateId", stateId), CandidateList.class );
	}

	/**
	 * This method grabs a list of officials according to office and state representation.
	 * 
	 * @param officeId
	 * @return {@link CandidateList}
	 */
	public CandidateList getByOfficeState(String officeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getByOfficeState", new ArgMap("officeId", officeId), CandidateList.class );
	}
	
	/**
	 * This method grabs a list of officials according to office and state representation.
	 * 
	 * @param officeId
	 * @param stateId
	 * @return {@link CandidateList}
	 */
	public CandidateList getByOfficeState(String officeId, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getByOfficeState", new ArgMap("officeId", officeId, "stateId", stateId), CandidateList.class );
	}

	/**
	 * This method grabs a list of officials according to office type and state representation.
	 * 
	 * @param officeTypeId
	 * @return {@link CandidateList}
	 */
	public CandidateList getByOfficeTypeState(String officeTypeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getByOfficeTypeState", new ArgMap("officeTypeId", officeTypeId), CandidateList.class );
	}
	
	/**
	 * This method grabs a list of officials according to office type and state representation.
	 * 
	 * @param officeTypeId
	 * @param stateId
	 * @return {@link CandidateList}
	 */
	public CandidateList getByOfficeTypeState(String officeTypeId, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getByOfficeTypeState", new ArgMap("officeTypeId", officeTypeId, "stateId", stateId), CandidateList.class );
	}
	
	/**
	 * This method grabs a list of officials according to a lastName match.
	 * 
	 * @param lastName
	 * @return {@link CandidateList}
	 */
	public CandidateList getByLastname(String lastName) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getByLastname", new ArgMap("lastName", lastName), CandidateList.class );
	}

	/**
	 * This method grabs a list of officials according to a fuzzy lastName match.
	 * 
	 * @param lastName
	 * @return {@link CandidateList}
	 */
	public CandidateList getByLevenshtein(String lastName) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getByLevenshtein", new ArgMap("lastName", lastName), CandidateList.class );
	}
	
	/**
	 * This method grabs a list of officials according to the district they are running for.
	 * 
	 * @param districtId
	 * @return {@link CandidateList}
	 */
	public CandidateList getByDistrict(String districtId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getByDistrict", new ArgMap("districtId", districtId), CandidateList.class );
	}
	
	/**
	 * This method grabs a list of officials according to the zip code they represent.
	 * 
	 * @param zip5
	 * @return {@link CandidateList}
	 */
	public CandidateList getByZip(String zip5) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getByZip", new ArgMap("zip5", zip5), CandidateList.class );
	}
	
	/**
	 * This method grabs a list of officials according to the zip code they represent.
	 * 
	 * @param zip5
	 * @param zip4
	 * @return {@link CandidateList}
	 */
	public CandidateList getByZip(String zip5, String zip4) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Officials.getByZip", new ArgMap("zip5", zip5, "zip4", zip4), CandidateList.class );
	}

}
