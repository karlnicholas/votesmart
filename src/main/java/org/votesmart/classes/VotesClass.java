package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.Bill;
import org.votesmart.data.BillAction;
import org.votesmart.data.BillActionVotes;
import org.votesmart.data.BillVetoes;
import org.votesmart.data.Bills;
import org.votesmart.data.BillsByOfficial;
import org.votesmart.data.VotesCategories;

/**
 * <pre>
 * Votes Class
 * 
 * * - Required
 * * - Multiple rows
 * 
 * Votes.getCategories
 * This method dumps categories that contain released bills according to year and state.
 * Input: year*, stateId (default: 'NA')
 * Output: {@link VotesCategories}
 * 
 * Votes.getBill
 * This method dumps general information on a bill.
 * Input: billId*
 * Output: {@link Bill}
 * 
 * Votes.getBillAction
 * This gets detailed action information on a certain stage of the bill.
 * Input: actionId*
 * Output: {@link BillAction}
 * 
 * Votes.getBillActionVotes
 * Method provides votes listed by candidate on a certain bill action.
 * Input: actionId*
 * Output: {@link BillActionVotes}
 * 
 * Votes.getBillActionVoteByOfficial
 * Returns a single vote according to official and action.
 * Input: actionId*, candidateId*
 * Output: {@link BillActionVotes}
 * 
 * Votes.getByBillNumber
 * Returns a list of bills that are like the billNumber input.
 * Input: billNumber*
 * Output: {@link Bills}
 * 
 * Votes.getBillsByCategoryYearState
 * Returns a list of bills that fit the category, year, and state input.
 * Input: categoryId*, year*, stateId
 * Output: {@link Bills}
 * 
 * Votes.getBillsByYearState
 * Returns a list of bills that fit the year and state input.
 * Input: year*, stateId
 * Output: {@link Bills}
 * 
 * Votes.getBillsByOfficialYearOffice
 * Returns a list of bills that fit the candidate and year.
 * Input: candidateId*, year*, officeId (Default: NULL(all))
 * Output: {@link Bills}
 * 
 * Votes.getBillsByOfficialCategoryOffice
 * Returns a list of bills that fit the candidate and category.
 * Input: candidateId*, categoryId*, officeId (Default: NULL(all))
 * Output: {@link Bills}
 * 
 * Votes.getByOfficial
 * This method dumps all the bills an official has voted on based on the candidateId, officeId, categoryId, and year 
 * Input: candidateId*, officeId, categoryId, year 
 * Output: {@link BillsByOfficial}
 * 
 * Votes.getBillsBySponsorYear
 * Returns a list of bills that fit the sponsor's candidateId and year.
 * Input: candidateId*, year*
 * Output: {@link BillsByOfficial}
 * 
 * Votes.getBillsBySponsorCategory
 * Returns a list of bills that fit the sponsor's candidateId and category.
 * Input: candidateId*, categoryId*
 * Output: {@link BillsByOfficial}
 * 
 * Votes.getBillsByStateRecent
 * Returns a list of recent bills according to the state. Max returned is 100 or however much less you want.
 * Input: amount (default: 100, max: 100), state (default: 'NA')
 * Output: {@link Bills}
 * 
 * Votes.getVetoes
 * Returns a list of vetoes according to candidate.
 * Input: candidateId
 * Output: {@link BillVetoes}
 * 
 * ==============  EXAMPLE USAGE ===============
 * 
 * // Votes class
 * VotesClass votesClass = new VotesClass();
 * 
 * // total votesCategories
 * VotesCategories votesCategories = votesClass.getCategories("2013");
 * 
 * // for State
 * votesCategories = votesClass.getCategories("2013", state.stateId);
 * CategoryMin votesCategory = votesCategories.category.get(0); 
 * 
 * // for category, for 2013, for State
 * Bills bills = votesClass.getBillsByCategoryYearState(votesCategory.categoryId, "2013", state.stateId);
 * 
 * // by Official, Category, Office
 * bills = votesClass.getBillsByOfficialCategoryOffice(leader.candidateId, votesCategory.categoryId);
 * </pre>
 *
 */
public class VotesClass extends ClassesBase {

	/**
	 * Constructor for testing purposes
	 * 
	 * @param api
	 */
	public VotesClass(VoteSmartAPI api) {
		super(api);
	}
	
	/**
	 * Default Constructor
	 */
	public VotesClass() throws VoteSmartException {
		super();
	}

	/**
	 * This method dumps categories that contain released bills according to year and state.
	 * Input: year*, stateId (default: 'NA')
	 * 
	 * @param year
	 * @return {@link VotesCategories}
	 */
	public VotesCategories getCategories(String year) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getCategories", new ArgMap("year", year), VotesCategories.class );
	}

	/**
	 * This method dumps categories that contain released bills according to year and state.
	 * Input: year*, stateId (default: 'NA')
	 * 
	 * @param year
	 * @param stateId
	 * @return {@link VotesCategories}
	 */
	public VotesCategories getCategories(String year, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getCategories", new ArgMap("year", year, "stateId", stateId), VotesCategories.class );
	}

	/**
	 * This method dumps general information on a bill.
	 * Input: billId*
	 * 
	 * @param billId
	 * @return {@link Bill}
	 */
	public Bill getBill(String billId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBill", new ArgMap("billId", billId), Bill.class );
	}

	/**
	 * This gets detailed action information on a certain stage of the bill
	 * Input: actionId*
	 * 
	 * @param actionId
	 * @return {@link BillAction}
	 */
	public BillAction getBillAction(String actionId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillAction", new ArgMap("actionId", actionId), BillAction.class );
	}

	/**
	 * Method provides votes listed by candidate on a certain bill action.
	 * Input: actionId*
	 * 
	 * @param actionId
	 * @return {@link BillActionVotes}
	 */
	public BillActionVotes getBillActionVotes(String actionId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillActionVotes", new ArgMap("actionId", actionId), BillActionVotes.class );
	}

	/**
	 * Returns a single vote according to official and action.
	 * Input: actionId*, candidateId*
	 * 
	 * @param actionId
	 * @param candidateId
	 * @return {@link BillActionVotes}
	 */
	public BillActionVotes getBillActionVoteByOfficial(String actionId, String candidateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillActionVoteByOfficial", new ArgMap("actionId", actionId, "candidateId", candidateId), BillActionVotes.class );
	}
	
	/**
	 * Returns a list of bills that are like the billNumber input.
	 * Input: billNumber*
	 * 
	 * @param billNumber
	 * @return {@link Bills}
	 */
	public Bills getByBillNumber(String billNumber) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getByBillNumber", new ArgMap("billNumber", billNumber), Bills.class );
	}
	
	/**
	 * Returns a list of bills that fit the category, year, and state input.
	 * Input: categoryId*, year*, stateId
	 * 
	 * @param categoryId
	 * @param year
	 * @return {@link Bills}
	 */
	public Bills getBillsByCategoryYearState(String categoryId, String year) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillsByCategoryYearState", new ArgMap("categoryId", categoryId, "year", year), Bills.class );
	}
	
	/**
	 * Returns a list of bills that fit the category, year, and state input.
	 * Input: categoryId*, year*, stateId
	 * 
	 * @param categoryId
	 * @param year
	 * @param stateId
	 * @return {@link Bills}
	 */
	public Bills getBillsByCategoryYearState(String categoryId, String year, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillsByCategoryYearState", new ArgMap("categoryId", categoryId, "year", year, "stateId", stateId), Bills.class );
	}

	/**
	 * Returns a list of bills that fit the candidate and year.
	 * Input: candidateId*, year*, officeId (Default: NULL(all))
	 * 
	 * @param candidateId
	 * @param year
	 * @return {@link Bills}
	 */
	public Bills getBillsByOfficialYearOffice(String candidateId, String year) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillsByOfficialYearOffice", new ArgMap("candidateId", candidateId, "year", year), Bills.class );
	}

	/**
	 * Returns a list of bills that fit the candidate and year.
	 * Input: candidateId*, year*, officeId (Default: NULL(all))
	 * 
	 * @param candidateId
	 * @param year
	 * @param officeId
	 * @return {@link Bills}
	 */
	public Bills getBillsByOfficialYearOffice(String candidateId, String year, String officeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillsByOfficialYearOffice", new ArgMap("candidateId", candidateId, "year", year, "officeId", officeId), Bills.class );
	}

	/**
	 * Returns a list of bills that fit the candidate and category.
	 * Input: candidateId*, categoryId*, officeId (Default: NULL(all))
	 * 
	 * @param candidateId
	 * @param categoryId
	 * @return {@link Bills}
	 */
	public Bills getBillsByOfficialCategoryOffice(String candidateId, String categoryId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillsByOfficialCategoryOffice", new ArgMap("candidateId", candidateId, "categoryId", categoryId), Bills.class );
	}
	
	/**
	 * Returns a list of bills that fit the candidate and category.
	 * Input: candidateId*, categoryId*, officeId (Default: NULL(all))
	 * 
	 * @param candidateId
	 * @param categoryId
	 * @param officeId
	 * @return {@link Bills}
	 */
	public Bills getBillsByOfficialCategoryOffice(String candidateId, String categoryId, String officeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillsByOfficialCategoryOffice", new ArgMap("candidateId", candidateId, "categoryId", categoryId, "officeId", officeId), Bills.class );
	}

	/**
	 * This method dumps all the bills an official has voted on based on the candidateId, officeId, categoryId, and year
	 * Input: candidateId*, officeId, categoryId, year
	 * 
	 * @param candidateId
	 * @param officeId
	 * @return {@link BillsByOfficial}
	 */
	public BillsByOfficial getByOfficial(String candidateId, String officeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getByOfficial", new ArgMap("candidateId", candidateId, "officeId", officeId), BillsByOfficial.class );
	}

	/**
	 * This method dumps all the bills an official has voted on based on the candidateId, officeId, categoryId, and year
	 * Input: candidateId*, officeId, categoryId, year
	 * 
	 * @param candidateId
	 * @param officeId
	 * @param categoryId
	 * @return {@link BillsByOfficial}
	 */
	public BillsByOfficial getByOfficial(String candidateId, String officeId, String categoryId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getByOfficial", new ArgMap("candidateId", candidateId, "officeId", officeId, "categoryId", categoryId), BillsByOfficial.class );
	}

	/**
	 * This method dumps all the bills an official has voted on based on the candidateId, officeId, categoryId, and year
	 * Input: candidateId*, officeId, categoryId, year
	 * 
	 * @param candidateId
	 * @param officeId
	 * @param categoryId
	 * @param year
	 * @return {@link BillsByOfficial}
	 */
	public BillsByOfficial getByOfficial(String candidateId, String officeId, String categoryId, String year) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getByOfficial", new ArgMap("candidateId", candidateId, "officeId", officeId, "categoryId", categoryId, "year", year), BillsByOfficial.class );
	}

	/**
	 * Returns a list of bills that fit the sponsor's candidateId and year.
	 * Input: candidateId*, year*
	 * 
	 * @param candidateId
	 * @param year
	 * @return {@link Bills}
	 */
	public Bills getBillsBySponsorYear(String candidateId, String year) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillsBySponsorYear", new ArgMap("candidateId", candidateId, "year", year), Bills.class );
	}
	
	/**
	 * Returns a list of bills that fit the sponsor's candidateId and category.
	 * Input: candidateId*, categoryId*
	 * 
	 * @param candidateId
	 * @param categoryId
	 * @return {@link Bills}
	 */
	public Bills getBillsBySponsorCategory(String candidateId, String categoryId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillsBySponsorCategory", new ArgMap("candidateId", candidateId, "categoryId", categoryId), Bills.class );
	}
	
	/**
	 * Returns a list of recent bills according to the state. Max returned is 100 or however much less you want.
	 * Input: amount (default: 100, max: 100), state (default: 'NA')
	 * 
	 * Note: Currently, the caching will only the most recent call. It won't cache all calls. 
	 * 
	 * @param amount
	 * @param state
	 * @return {@link Bills}
	 */
	public Bills getBillsByStateRecent(String amount, String state) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getBillsByStateRecent", new ArgMap("amount", amount, "state", state), Bills.class );
	}

	/**
	 * Returns a list of vetoes according to candidate.
	 * Input: candidateId
	 * 
	 * @param candidateId
	 * @return {@link BillVetoes}
	 */
	public BillVetoes getVetoes(String candidateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Votes.getVetoes", new ArgMap("candidateId", candidateId), BillVetoes.class );
	}
	
}
