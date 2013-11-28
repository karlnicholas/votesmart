package org.votesmart.api;

/**
 * Interface that defines the query method. Used by testing.
 *
 */
public interface VoteSmartAPI {
	public <T> T query(String method, ArgMap argMap, Class<T> responseType) throws VoteSmartException, VoteSmartErrorException;
}
