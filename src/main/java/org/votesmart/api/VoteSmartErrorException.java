package org.votesmart.api;

import org.votesmart.data.ErrorBase;

/**
 * <pre>
 * This exception will be thrown when VoteSmart.org returns an error message.
 * So, it does not indicate an error with the program, but rather
 * that one of the parameters passed to one of the method calls
 * is probably incorrect. See what the message says.
 * </pre> 
 *
 */
public class VoteSmartErrorException extends Exception {
	private static final long serialVersionUID = 2196788960724030978L;
	public ErrorBase errorBase;
	public String method;
	public ArgMap argMap;
	public VoteSmartErrorException(ErrorBase errorBase, String method, ArgMap argMap) {
		super(errorBase.errorMessage);
		this.errorBase = errorBase;
		this.method = method;
		this.argMap = argMap;
	}
}
