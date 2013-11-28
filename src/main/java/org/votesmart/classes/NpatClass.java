package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.Npat;

/**
 * <pre>
 * NPAT/PCT Class
 * * - Required
 * * - Multiple rows
 * * - Possibly Recursive
 * 
 * Npat.getNpat()
 * This method returns the candidates most recently filled out NPAT/PCT. 
 * NOTE: This is the only class that responds with recursive data.
 * Input: candidateId*
 * Output: {@link Npat}
 * 
 * ========== EXAMPLE USAGE =============
 * 
 * // Npat class
 * NpatClass npatClass = new NpatClass();
 * 
 * // Npat if it exists
 * Npat npat = npatClass.getNpat(leader.candidateId);
 * </pre> 
 *
 */
public class NpatClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public NpatClass(VoteSmartAPI api) {
		super(api);
	}
	
	/**
	 * Default Constructor
	 */
	public NpatClass() throws VoteSmartException {
		super();
	}
	/**
	 * This method returns the candidates most recently filled out NPAT/PCT. 
	 * NOTE: This is the only class that responds with recursive data.
	 * 
	 * @param candidateId
	 * @return {@link Npat}: 
	 */
	public Npat getNpat(String candidateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Npat.getNpat", new ArgMap("candidateId", candidateId), Npat.class );
	}
	
}
