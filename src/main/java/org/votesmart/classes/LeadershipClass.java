package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.Leaders;
import org.votesmart.data.Leadership;

/**
 * <pre>
 * Leadership Class
 * 
 * * - Required
 * * - Multiple rows
 * 
 * Leadership.getPositions()
 * Gets leadership positions by state and office
 * Input: stateId(default: 'NA'), officeId(default: All)
 * Output: {@link Leadership}
 * 
 * Leadership.getOfficials()
 * Gets officials that hold the leadership role in certain states.
 * Input: leadershipId*, stateId(default: 'NA')
 * Output: {@link Leaders}
 * 
 * ============== EXAMPLE USAGE =============
 * 
 * // Leadership class
 * LeadershipClass leadershipClass = new LeadershipClass();
 * 
 * Leadership leadership = leadershipClass.getPositions();
 * 
 * // all positions
 * leadership = leadershipClass.getPositions(state.stateId);
 * 
 * // all positions for office in state
 * leadership = leadershipClass.getPositions(state.stateId, office.officeId);
 * Leadership.Position position = leadership.position.get(0);
 * </pre>
 *
 */
public class LeadershipClass extends ClassesBase {
	
	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public LeadershipClass(VoteSmartAPI api) {
		super(api);
	}
	
	/**
	 * Default Constructor
	 */
	public LeadershipClass() {
		super();
	}

	/**
	 * Gets leadership positions by state and office.
	 * 
	 * @return {@link Leadership}: 
	 */
	public Leadership getPositions() throws VoteSmartException, VoteSmartErrorException {
		return api.query("Leadership.getPositions", new ArgMap(), Leadership.class );
	}

	/**
	 * Gets leadership positions by state and office.
	 * 
	 * @param stateId
	 * @return {@link Leadership}: 
	 */
	public Leadership getPositions(String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Leadership.getPositions", new ArgMap("stateId", stateId), Leadership.class );
	}

	/**
	 * Gets leadership positions by state and office.
	 * 
	 * @param stateId
	 * @param officeId
	 * @return {@link Leadership}: 
	 */
	public Leadership getPositions(String stateId, String officeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Leadership.getPositions", new ArgMap("stateId", stateId, "officeId", officeId), Leadership.class );
	}

	/**
	 * Gets officials that hold the leadership role in certain states.
	 * 
	 * @param leadershipId
	 * @return {@link Leaders}: 
	 */
	public Leaders getOfficials(String leadershipId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Leadership.getOfficials", new ArgMap("leadershipId", leadershipId), Leaders.class );
	}

	/**
	 * Gets officials that hold the leadership role in certain states.
	 * 
	 * @param leadershipId
	 * @param stateId
	 * @return {@link Leaders}: 
	 */
	public Leaders getOfficials(String leadershipId, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Leadership.getOfficials", new ArgMap("leadershipId", leadershipId, "stateId", stateId), Leaders.class );
	}
}
