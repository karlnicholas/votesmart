package org.votesmart.api;

public interface VoteSmartAPI {
	public <T> T query(String method, ArgMap argMap, Class<T> responseType) throws VoteSmartException, VoteSmartErrorException;
}
