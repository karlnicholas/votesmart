package examples;

import org.votesmart.api.VoteSmartErrorException;
import org.votesmart.classes.*;
import org.votesmart.data.*;

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
 * cache     (Mandatory) such as c:/tmp/VoteSmartCache
 * 
 * The basic goal here are to make (most) every possible call 
 * and use ID's from earlier calls to pass to later calls.
 * 
 * The queries will be cached and all subsequent calls will return 
 * the same information. If you want to disable the cache checking, 
 * then call VoteSmart.checkCache(false); or VoteSmart.checkCache(true);
 * to turn it back on.
 * 
 * Secondarily, the goal is to list make all the calls that can be 
 * made for a state.
 * </pre>
 *
 */
public class PoliticalExperience {

	public static void handleError(VoteSmartErrorException e) {
		System.out.println("Error: " + e.errorBase.errorMessage);
		System.out.println("	Details: " + e.method + " " + e.argMap + "\n");
	}

	public static void main(String... args) throws Exception {
		
		// Candidate biographical 
		CandidatesClass candidatesClass = new CandidatesClass();
		
		CandidateList candidateList = candidatesClass.getByLastname("Chesbro", "2010");
		CandidateList.Candidate candidate = candidateList.candidate.get(0);
		System.out.println(candidate.officeDistrictName);

		// Candidate biographical 
		CandidateBioClass candidateBioClass = new CandidateBioClass();
/*		
		// Bio of Official
		BioOld bio = candidateBioClass.getBio(candidate.candidateId);
		System.out.println( "Bio for " + bio.candidate.firstName + " " + bio.candidate.lastName + " includes:");
		System.out.println( "	Birthdate: \t" + bio.candidate.birthDate );
		System.out.println( "	Birthplace: \t" + bio.candidate.birthPlace );
		System.out.println( "	Gender: \t" + bio.candidate.gender );
//		System.out.println( "	Education: \t" + bio.candidate.education );
//		System.out.println( "	Profession: \t" + bio.candidate.profession );
		System.out.println( "	Religion: \t" + bio.candidate.religion );
*/
		// Bio of Official
		Bio bio = candidateBioClass.getBio(candidate.candidateId);
		System.out.println( "Bio for " + bio.candidate.firstName + " " + bio.candidate.lastName + " includes:");
		System.out.println( "	Birthdate: \t" + bio.candidate.birthDate );
		System.out.println( "	Birthplace: \t" + bio.candidate.birthPlace );
		System.out.println( "	Gender: \t" + bio.candidate.gender );
//		System.out.println( "	Education: \t" + bio.candidate.education );
//		System.out.println( "	Profession: \t" + bio.candidate.profession );
		System.out.println( "	Religion: \t" + bio.candidate.religion );
		for( Bio.Institution institution: bio.candidate.education.institution ) {
			System.out.println( "	Education: \t" + institution.degree + " from " + institution.school );
		}
		for( Bio.Experience experience: bio.candidate.profession.experience ) {
			System.out.println( "	Profession: \t" + experience.title + " at " + experience.organization );
		}
		for( Bio.Experience experience: bio.candidate.political.experience ) {
			System.out.println( "	Political: \t" + experience.title + " at " + experience.organization );
		}
		for( Bio.Experience experience: bio.candidate.congMembership.experience ) {
			System.out.println( "	CongMembership: \t" + experience.title + " at " + experience.organization );
		}
		for( Bio.Experience experience: bio.candidate.orgMembership.experience ) {
			System.out.println( "	OrgMembership: \t" + experience.title + " at " + experience.organization );
		}

	}
}
