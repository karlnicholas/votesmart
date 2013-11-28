package org.votesmart.api;

/**
 * Catch-all exception that wraps all VoteSmart exceptions
 * and is thrown so that specific votesmart errors can be 
 * trapped. 
 *
 */
public class VoteSmartException extends Exception {
	private static final long serialVersionUID = 6179623710020364382L;

	public VoteSmartException (Exception e ) {
		super(e);
	}
	
	public VoteSmartException (String msg) {
		super(msg);
	}
	
	public VoteSmartException(String msg, Exception e ) {
		super(msg, e);
	}
}
