package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.Committee;
import org.votesmart.data.CommitteeMembers;
import org.votesmart.data.CommitteeTypes;
import org.votesmart.data.Committees;

/**
 * <pre>
 * Committee Class
 * 
 * * - Required
 * * - Multiple rows
 * 
 * Committee.getTypes()
 * Returns the committee types(house, senate, joint, etc)
 * Input: none
 * Output: {@link CommitteeTypes}
 * 
 * Committee.getCommitteesByTypeState()
 * Returns the list of committees that fit the criteria
 * Input: typeId(Default: All), stateId (Default: NA(fed))
 * Output: {@link Committees}
 * 
 * Committee.getCommittee()
 * Returns detailed committee data.
 * Input: committeeId*
 * Output: {@link Committee}
 * 
 * Committee.getCommitteeMembers()
 * Returns members of the committee
 * Input: committeeId*
 * Output: {@link CommitteeMembers}
 * 
 * =========== EXAMPLE USAGE ========
 * 
 * CommitteeClass committeeClass = new CommitteeClass();
 * 
 * Committee committee = committeeClass.getCommittee(committeeByBio.committeeId);
 * 
 * CommitteeTypes committeeTypes = committeeClass.getTypes();
 * </pre>
 *
 */
public class CommitteeClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public CommitteeClass(VoteSmartAPI api) {
		super(api);
	}

	/**
	 * Default Constructor
	 */
	public CommitteeClass() {
		super();
	}

	/**
	 * Returns the committee types(house, senate, joint, etc)
	 * 
	 * @return {@link CommitteeTypes}: 
	 */
	public CommitteeTypes getTypes() throws VoteSmartException, VoteSmartErrorException {
		return api.query("Committee.getTypes", null, CommitteeTypes.class );
	}
	
	/**
	 * Returns the list of committees that fit the criteria.
	 * 
	 * @return {@link Committees}: 
	 */
	public Committees getCommitteesByTypeState() throws VoteSmartException, VoteSmartErrorException {
		return api.query("Committee.getCommitteesByTypeState", null, Committees.class );
	}

	/**
	 * Returns the list of committees that fit the criteria.
	 * 
	 * @param typeId
	 * @return {@link Committees}: 
	 */
	public Committees getCommitteesByTypeState(String typeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Committee.getCommitteesByTypeState", new ArgMap("typeId", typeId), Committees.class );
	}

	/**
	 * Returns the list of committees that fit the criteria.
	 * 
	 * @param typeId
	 * @param stateId
	 * @return {@link Committees}: 
	 */
	public Committees getCommitteesByTypeState(String typeId, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Committee.getCommitteesByTypeState", new ArgMap("typeId", typeId, "stateId", stateId), Committees.class );
	}
	
	/**
	 * Returns detailed committee data.
	 * 
	 * @param committeeId
	 * @return {@link Committee}: 
	 */
	public Committee getCommittee(String committeeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Committee.getCommittee", new ArgMap("committeeId", committeeId), Committee.class );
	}

	/**
	 * Returns members of the committee.
	 * 
	 * @param committeeId
	 * @return {@link CommitteeMembers}: 
	 */
	public CommitteeMembers getCommitteeMembers(String committeeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Committee.getCommitteeMembers", new ArgMap("committeeId", committeeId), CommitteeMembers.class );
	}
}
