package org.votesmart.data;

/**
 * <pre>
 * Output:
 * title, 
 * linkBack.
 * 
 * Every message from VoteSmart, except error messages, 
 * has a generalinfo tag. 
 * </pre>
 *
 */
public class GeneralInfoBase {
	
	public GeneralInfo generalInfo;
	
	public static class GeneralInfo {
		public String title;
		public String linkBack;
	}


}
