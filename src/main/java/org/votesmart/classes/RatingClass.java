package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.Rating;
import org.votesmart.data.Sig;
import org.votesmart.data.Sigs;
import org.votesmart.data.SigRating;
import org.votesmart.data.Categories;
import org.votesmart.data.CandidateRating;

/**
 * <pre>
 * Rating Class
 * 
 * * - Required
 * * - Multiple rows
 * 
 * Rating.getCategories
 * This method dumps categories that contain released ratingss according to state.
 * Input: stateId (default: 'NA')
 * Output: {@link Categories}
 * 
 * Rating.getSigList
 * This method dumps Special Interest Groups according to category and state.
 * Input: categoryId*, stateId (default: 'NA')
 * Output: {@link Sigs}
 * 
 * Rating.getSig
 * This method dumps detailed information an a Special Interest Group.
 * Input: sigId*
 * Output: {@link Sig}
 * 
 * Rating.getSigRatings
 * This method dumps all ratings(scorecards) by a Special Interest Group.
 * Input: sigId*
 * Output: {@link SigRating}
 * 
 * Rating.getCandidateRating
 * This method dumps a candidate's rating by an SIG.
 * Input: candidateId*, sigId
 * Output: {@link CandidateRating}
 * 
 * Rating.getRating
 * This method dumps all candidate ratings from a scorecard by an SIG.
 * Input: ratingId*
 * Output: {@link Rating}
 * 
 * =========== EXAMPLE USAGE ==================
 * 
 * RatingClass ratingClass = new RatingClass();
 * 
 * // all categories
 * Categories categories = ratingClass.getCategories();
 * 
 * // state categories
 * categories = ratingClass.getCategories(state.stateId);
 * CategoryMin category = categories.category.get(0)
 * 
 * // state sigs (Special Interest Groups)
 * Sigs sigs = ratingClass.getSigList(category.categoryId, state.stateId);
 * Sigs.Sig sigsSig = sigs.sig.get(0);
 * 
 * // Sig
 * Sig sig = ratingClass.getSig(sigs.sig.get(0).sigId);
 * </pre>
 *
 */
public class RatingClass extends ClassesBase {

	/**
	 * Constructor for testing purposes
	 * 
	 * @param api
	 */
	public RatingClass(VoteSmartAPI api) {
		super(api);
	}
	
	/**
	 * Default Constructor
	 */
	public RatingClass() throws VoteSmartException {
		super();
	}

	/**
	 * This method dumps categories that contain released ratings according to state.
	 * Input: stateId (default: 'NA')
	 * 
	 * @return {@link Categories}
	 */
	public Categories getCategories() throws VoteSmartException, VoteSmartErrorException {
		return api.query("Rating.getCategories", null, Categories.class );
	}
	
	/**
	 * This method dumps categories that contain released ratings according to state.
	 * Input: stateId (default: 'NA')
	 * 
	 * @param stateId
	 * @return {@link Categories}
	 */
	public Categories getCategories(String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Rating.getCategories", new ArgMap("stateId", stateId), Categories.class );
	}

	/**
	 * This method dumps Special Interest Groups according to category and state.
	 * Input: categoryId*, stateId (default: 'NA')
	 * 
	 * @param categoryId
	 * @return {@link Sigs}
	 */
	public Sigs getSigList(String categoryId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Rating.getSigList", new ArgMap("categoryId", categoryId), Sigs.class );
	}

	/**
	 * This method dumps Special Interest Groups according to category and state.
	 * Input: categoryId*, stateId (default: 'NA')
	 * 
	 * @param categoryId
	 * @param stateId
	 * @return {@link Sigs}
	 */
	public Sigs getSigList(String categoryId, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Rating.getSigList", new ArgMap("categoryId", categoryId, "stateId", stateId), Sigs.class );
	}
	
	/**
	 * This method dumps detailed information an a Special Interest Group.
	 * Input: sigId*
	 * 
	 * @param sigId
	 * @return {@link Sig}
	 */
	public Sig getSig(String sigId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Rating.getSig", new ArgMap("sigId", sigId), Sig.class );
	}

	/**
	 * This method dumps all ratings(scorecards) by a Special Interest Group.
	 * Input: sigId*
	 * 
	 * @param sigId
	 * @return {@link SigRating}
	 */
	public SigRating getSigRatings(String sigId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Rating.getSigRatings", new ArgMap("sigId", sigId), SigRating.class );
	}
	
	/**
	 * This method dumps a candidate's rating by an SIG.
	 * 
	 * @param candidateId
	 * @return {@link CandidateRating}
	 */
	public CandidateRating getCandidateRating(String candidateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Rating.getCandidateRating", new ArgMap("candidateId", candidateId), CandidateRating.class );
	}
	
	/**
	 * This method dumps a candidate's rating by an SIG.
	 * 
	 * @param candidateId
	 * @param sigId
	 * @return {@link CandidateRating}
	 */
	public CandidateRating getCandidateRating(String candidateId, String sigId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Rating.getCandidateRating", new ArgMap("candidateId", candidateId, "sigId", sigId), CandidateRating.class );
	}
	
	/**
	 * This method dumps all candidate ratings from a scorecard by an SIG.
	 * 
	 * @param ratingId
	 * @return {@link Rating}
	 * @throws VoteSmartException, VoteSmartErrorException
	 */
	public Rating getRating(String ratingId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Rating.getRating", new ArgMap("ratingId", ratingId), Rating.class );
	}

}
