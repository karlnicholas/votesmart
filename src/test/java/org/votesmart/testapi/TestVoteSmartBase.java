package org.votesmart.testapi;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.votesmart.api.ArgMap;
import org.votesmart.api.VoteSmartAPI;
import org.votesmart.api.VoteSmartErrorException;
import org.votesmart.api.VoteSmartException;
import org.votesmart.data.GeneralInfoBase;

/**
 * Base class for all Test classes.
 *
 */
public class TestVoteSmartBase implements VoteSmartAPI {
	protected static TestVoteSmart api;
	private static GeneralInfoBase generalInfoBase; 
	
	@BeforeClass
	public static void setup() {
		api = new TestVoteSmart(ResourceBundle.getBundle("votesmart"));
	}
	
	public <T> T query(String method, ArgMap argMap, Class<T> responseType) throws VoteSmartException, VoteSmartErrorException {
		T response = api.query(method, argMap, responseType); 
		generalInfoBase = (GeneralInfoBase)response;
		return response;
	}

	@AfterClass
	public static void testGeneralInfo() {
		assertTrue( generalInfoBase.generalInfo.title != null );
		assertTrue( generalInfoBase.generalInfo.linkBack != null );
		api.destroy();
	}
}
