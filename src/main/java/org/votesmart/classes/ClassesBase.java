package org.votesmart.classes;

import java.util.ResourceBundle;

import org.votesmart.api.VoteSmart;
import org.votesmart.api.VoteSmartAPI;
import org.votesmart.api.VoteSmartException;

/**
 * <pre>
 * Base class for all other classes. 
 * The user has no reason to use this class.
 * </pre>
 */
public class ClassesBase {
	
	protected static VoteSmartAPI api = null;
	
	/**
	 * This class is supports the other interface classes. 
	 * Default constructor
	 */
	public ClassesBase() throws VoteSmartException {
		if ( ClassesBase.api == null ) ClassesBase.api = new VoteSmart(ResourceBundle.getBundle("votesmart"));
	}
	
	/**
	 * Constructor for testing purposes
	 * 
	 * @param testApi
	 */
	public ClassesBase(VoteSmartAPI testApi) {
		if ( ClassesBase.api == null ) ClassesBase.api = testApi;
	}
}
