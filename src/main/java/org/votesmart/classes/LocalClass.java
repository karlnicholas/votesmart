package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.Cities;
import org.votesmart.data.Counties;
import org.votesmart.data.LocalCandidateList;

/**
 * <pre>
 *  Local Class
 *  
 *  Local.getCounties()
 *  Fetches counties in a state
 *  Input: stateId*
 *  Output: {@link Counties}
 *  
 *  Local.getCities()
 *  Fetches cities in a state
 *  Input: stateId*
 *  Output: {@link Cities}
 *  
 *  Local.getOfficials()
 *  Fetches officials for a locality
 *  Input: localId*
 *  Output: {@link LocalCandidateList}
 *  
 *  ============= EXAMPLE USAGE =============
 *  
 *  LocalClass localClass = new LocalClass();
 *  
 *  // get counties
 *  Counties counties = localClass.getCounties(state.stateId);
 *  Counties.County county = counties.county.get(0);
 *  
 *  // get cities
 *  Cities cities = localClass.getCities(state.stateId);
 *  Cities.City city = cities.city.get(0);
 *  
 *  // county official
 *  LocalCandidateList localCandidates = localClass.getOfficials(county.localId);
 *  LocalCandidateList.Candidate localCandidate = localCandidates.candidate.get(0);
 *  </pre>
 */
public class LocalClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public LocalClass(VoteSmartAPI api) {
		super(api);
	}
	
	/**
	 * Default Constructor
	 */
	public LocalClass() {
		super();
	}
	
	/**
	 * Fetches counties in a state.
	 * 
	 * @param stateId
	 * @return {@link Counties}: 
	 */
	public Counties getCounties(String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Local.getCounties", new ArgMap("stateId", stateId), Counties.class );
	}

	/**
	 * Fetches cities in a state.
	 * 
	 * @param stateId
	 * @return {@link Cities}: 
	 */
	public Cities getCities(String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Local.getCities", new ArgMap("stateId", stateId), Cities.class );
	}

	/**
	 * Fetches officials for a locality.
	 * 
	 * @param localId
	 * @return {@link LocalCandidateList}: 
	 */
	public LocalCandidateList getOfficials(String localId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Local.getOfficials", new ArgMap("localId", localId), LocalCandidateList.class );
	}
}
