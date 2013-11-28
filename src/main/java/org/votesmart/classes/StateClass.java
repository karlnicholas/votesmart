package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.State;
import org.votesmart.data.StateList;

/**
 * <pre>
 * State Class
 * 
 * State.getStateIDs()
 * This method grabs a simple state ID and name list for mapping ID to state names.
 * Input: none
 * Output: {@link StateList}
 * 
 * State.getState()
 * This method grabs a various data we keep on a state
 * Input: stateId*
 * Output: {@link State}
 * 
 * ============== EXAMPLE USAGE =============
 * 
 * StateClass stateClass = new StateClass();
 * 
 * StateList allStates = stateClass.getStateIDs();
 * StateList.List.State state = null;
 * for( StateList.List.State aState: allStates.list.state ) {
 * 		if (aState.name.equals("California")) {
 * 			state = aState;
 * 			break;
 * 		}
 * }
 * // Get State Details
 * State stateDetail = stateClass.getState(state.stateId);
 * </pre>
 *
 */
public class StateClass extends ClassesBase {

	/**
	 * Constructor for testing purposes
	 * 
	 * @param api
	 */
	public StateClass(VoteSmartAPI api) {
		super(api);
	}

	/**
	 * Default Constructor
	 */
	public StateClass() throws VoteSmartException {
		super();
	}
	
	/**
	 * This method grabs a simple state ID and name list for mapping ID to state names.
	 * 
	 * @return {@link StateList}
	 */
	public StateList getStateIDs() throws VoteSmartException, VoteSmartErrorException {
		return api.query("State.getStateIDs", null, StateList.class );
	}

	/**
	 * This method grabs a various data we keep on a state.
	 * Input: stateId*
	 *  
	 * @param stateId
	 * @return {@link State}
	 */
	public State getState(String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("State.getState", new ArgMap("stateId", stateId), State.class );
	}
	
}
