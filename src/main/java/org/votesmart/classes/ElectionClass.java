package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.Elections;
import org.votesmart.data.ElectionByZip;
import org.votesmart.data.StageCandidates;

/**
 * <pre>
 * Election Class
 * 
 * * - Required
 * * - Multiple rows
 * 
 * Election.getElection
 * This method grabs district basic election data according to electionId
 * Input: electionId*
 * Output: {@link Elections}
 * 
 * Election.getElectionByYearState
 * This method grabs district basic election data according to year and stateid.
 * Input: year*, stateId(default: 'NA')
 * Output: {@link Elections}
 * 
 * Election.getElectionByZip
 * This method grabs district basic election data according to zip code.
 * Input: zip5*, zip4(default: NULL), year(default: &gr;=current year
 * Output: {@link ElectionByZip}
 * 
 * Election.getStageCandidates
 * This method grabs district basic election data according to electionId and stageId. Per state lists of a Presidential election are available by specifying the stateId.
 * Input: electionId*, stageId*, party (Default: ALL(NULL)), districtId (Default: All(NULL)), stateId (Default: election.stateId)
 * Output: {@link StageCandidates}
 * 
 * ============ EXAMPLE USAGE ==============
 * 
 * ElectionClass electionClass = new ElectionClass();
 * 
 * // look up 2012 elections
 * Elections elections = electionClass.getElectionByYearState("2012", state.stateId);
 * Elections.ElectionStage election = elections.election.get(0);
 * Elections.ElectionStage.Stage stage = elections.election.get(0).stage.get(0);
 * 
 * // a specific election 
 * elections = electionClass.getElection(election.electionId);
 * election = elections.election.get(0);
 * </pre>
 *
 */
public class ElectionClass extends ClassesBase {

	/**
	 * Constructor for testing purposes. 
	 * 
	 * @param api
	 */
	public ElectionClass(VoteSmartAPI api) {
		super(api);
	}
	
	/**
	 * Default Constructor
	 */
	public ElectionClass() {
		super();
	}

	/**
	 * This method grabs district IDs according to the office and state.
	 * 
	 * @param electionId
	 * @return {@link Elections}: 
	 */
	public Elections getElection(String electionId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Election.getElection", new ArgMap("electionId", electionId), Elections.class );
	}

	/**
	 * This method grabs district basic election data according to year and stateid.
	 * 
	 * @param year
	 * @return {@link Elections} 
	 */
	public Elections getElectionByYearState(String year) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Election.getElectionByYearState", new ArgMap("year", year), Elections.class );
	}
	
	/**
	 * This method grabs district basic election data according to year and stateid.
	 * 
	 * @param year
	 * @param stateId
	 * @return {@link Elections}: 
	 */
	public Elections getElectionByYearState(String year, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Election.getElectionByYearState", new ArgMap("year", year, "stateId", stateId), Elections.class );
	}
	
	/**
	 * This method grabs district basic election data according to zip code.
	 * 
	 * @param zip5
	 * @return {@link ElectionByZip}: 
	 */
	public ElectionByZip getElectionByZip(String zip5) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Election.getElectionByZip", new ArgMap("zip5", zip5), ElectionByZip.class );
	}
	
	/**
	 * This method grabs district basic election data according to zip code.
	 * 
	 * @param zip5
	 * @param zip4
	 * @return {@link ElectionByZip}: 
	 */
	public ElectionByZip getElectionByZip(String zip5, String zip4) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Election.getElectionByZip", new ArgMap("zip5", zip5, "zip4", zip4), ElectionByZip.class );
	}
	
	/**
	 * This method grabs district basic election data according to zip code.
	 * 
	 * @param zip5
	 * @param zip4
	 * @param year
	 * @return {@link ElectionByZip}: 
	 */
	public ElectionByZip getElectionByZip(String zip5, String zip4, String year) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Election.getElectionByZip", new ArgMap("zip5", zip5, "zip4", zip4, "year", year), ElectionByZip.class );
	}

	/**
	 * This method grabs district basic election data according to electionId and stageId.
	 * Per state lists of a Presidential election are available by specifying the stateId.
	 * 
	 * @param electionId
	 * @param stageId
	 * @return {@link StageCandidates}: 
	 */
	public StageCandidates getStageCandidates(String electionId, String stageId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Election.getStageCandidates", new ArgMap("electionId", electionId, "stageId", stageId), StageCandidates .class );
	}

	/**
	 * This method grabs district basic election data according to electionId and stageId.
	 * Per state lists of a Presidential election are available by specifying the stateId.
	 * 
	 * @param electionId
	 * @param stageId
	 * @param party
	 * @return {@link StageCandidates}: 
	 */
	public StageCandidates getStageCandidates(String electionId, String stageId, String party) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Election.getStageCandidates", new ArgMap("electionId", electionId, "stageId", stageId, "party", party), StageCandidates .class );
	}

	/**
	 * This method grabs district basic election data according to electionId and stageId.
	 * Per state lists of a Presidential election are available by specifying the stateId.
	 * 
	 * @param electionId
	 * @param stageId
	 * @param party
	 * @param districtId
	 * @return {@link StageCandidates}: 
	 */
	public StageCandidates getStageCandidates(String electionId, String stageId, String party, String districtId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Election.getStageCandidates", new ArgMap("electionId", electionId, "stageId", stageId, "party", party, "districtId", districtId), StageCandidates .class );
	}

	/**
	 * This method grabs district basic election data according to electionId and stageId.
	 * Per state lists of a Presidential election are available by specifying the stateId.
	 * 
	 * @param electionId
	 * @param stageId
	 * @param party
	 * @param districtId
	 * @param stateId
	 * @return {@link StageCandidates}: 
	 */
	public StageCandidates getStageCandidates(String electionId, String stageId, String party, String districtId, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Election.getStageCandidates", new ArgMap("electionId", electionId, "stageId", stageId, "party", party, "districtId", districtId, "stateId", stateId), StageCandidates .class );
	}
}
