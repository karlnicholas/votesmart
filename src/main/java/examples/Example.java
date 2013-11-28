package examples;

import org.votesmart.classes.OfficialsClass;
import org.votesmart.data.CandidateList;

/**
 * <pre>
 * This program is a very simple demonstration of this RESTful Client API.
 * It requires a ResourceBundle named VoteSmart. This means a file
 * named VoteSmart.properties must be found in your class path, such
 * as your resources directory. This VoteSmart client reads three 
 * keys from the resource bundle, two of which are mandatory.
 * These are in the form of key=value, one on each line.
 * The three keys are:
 * 
 * apikey    (Mandatory) get from VoteSmart.org
 * cache     (Optional) such as c:/tmp/VoteSmartCache
 * 
 * The queries will be cached and all subsequent calls will return 
 * the same information. If you want to disable the cache checking, 
 * then call VoteSmart.checkCache(false); or VoteSmart.checkCache(true);
 * to turn it back on.
 * 
 * The example code is self explanatory.
 * </pre>
 */
public class Example {

	public static void main(String[] args) throws Exception {
		
		// Create a votesmart.properties file and put it in your class path, 
		// such as your resource directory.
		// It must contain two entries.
		// put your VoteSmart API key in it and set a caching directory, 
		// then rename it to (votesmart.properties).
		
		
		// Query the API server 
		// This query will be cached and all subsequent calls will return 
		// the same information. If you want to disable the cache checking, 
		// then call VoteSmart.checkCache(false); or VoteSmart.checkCache(true);
		// to turn it back on.
		CandidateList candidates = new OfficialsClass().getByOfficeState("6", "MT");
		
		// And print out the candidates
		for ( CandidateList.Candidate candidate: candidates.candidate ) {
			System.out.println(
				candidate.candidateId 
				+ " = " 
				+ candidate.title
				+ " "
				+ candidate.firstName
				+ " "
				+ candidate.lastName 
			);
		}
	}

}
