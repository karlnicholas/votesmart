package examples;

import org.votesmart.api.VoteSmartErrorException;
import org.votesmart.classes.CandidatesClass;

/**
 * <pre>
 * Shows what happens when votemart.org generates an error, 
 * and how to handle it if you want to. 
 * </pre>
 *
 */
public class ExampleError {
	
	public static void main(String... args) throws Exception {
		CandidatesClass candidatesClass = new CandidatesClass();
		try {
			candidatesClass.getByDistrict("BAD ID");
		} catch ( VoteSmartErrorException e) {
			System.out.println("Error: " + e.errorBase.errorMessage);
			System.out.println("	Details: " + e.method + " " + e.argMap + "\n");
		}
	}

}
