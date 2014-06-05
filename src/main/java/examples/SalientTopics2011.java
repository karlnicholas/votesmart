package examples;

import org.votesmart.api.VoteSmart;
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
public class SalientTopics2011 {

	public static void handleError(VoteSmartErrorException e) {
		System.out.println("Error: " + e.errorBase.errorMessage);
		System.out.println("	Details: " + e.method + " " + e.argMap + "\n");
	}

	public static void main(String... args) throws Exception {
		
		String state = "CA";
		// Votes class
		VotesClass votesClass = new VotesClass();
		
		// for CA
		VotesCategories votesCategories = votesClass.getCategories("2011", state);
//		System.out.println("2011 Categories");
		for (CategoryMin votesCategory: votesCategories.category ) {
//			System.out.println("CATEGORY\t" + votesCategory.name );
			Bills bills = votesClass.getBillsByCategoryYearState(votesCategory.categoryId, "2011", state);
			for ( BillMin bill: bills.bill ) {
//				System.out.println("BILL\t" + bill.type + " " + bill.billNumber + "\t" + bill.title );
				System.out.println(bill.billNumber );
			}
		}
		votesCategories = votesClass.getCategories("2012", state);
//		System.out.println("2012 Categories");
		for (CategoryMin votesCategory: votesCategories.category ) {
//			System.out.println("CATEGORY\t" + votesCategory.name );
			Bills bills = votesClass.getBillsByCategoryYearState(votesCategory.categoryId, "2012", state);
			for ( BillMin bill: bills.bill ) {
//				System.out.println("BILL\t" + bill.type + " " + bill.billNumber + "\t" + bill.title );
				System.out.println(bill.billNumber);
			}
		}

	}
}
