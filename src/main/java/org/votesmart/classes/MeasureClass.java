package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.Measure;
import org.votesmart.data.Measures;

/**
 * <pre>
 * Ballot Measure Class
 * * - Required
 * * - Multiple rows
 * 
 * Measure.getMeasuresByYearState
 * This method returns a list of state ballot measures in a given year.
 * Input: year*, stateId*
 * Output: {@link Measures}
 * 
 * This method returns a single Ballot Measure detail.
 * Input: measureId*
 * Output: {@link Measure}
 * 
 * =========== EXAMPLE USAGE =================
 * 
 * // Ballot Measures
 * MeasureClass measureClass = new MeasureClass();
 * 
 * // Get measures in 2012 state election
 * Measures measures = measureClass.getMeasuresByYearState("2012", state.stateId);
 * 
 * Measure measure = measureClass.getMeasure(measures.measure.get(0).measureId);
 * </pre>
 *
 */
public class MeasureClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public MeasureClass(VoteSmartAPI api) {
		super(api);
	}

	/**
	 * Default Constructor
	 */
	public MeasureClass() throws VoteSmartException {
		super();
	}
	
	/**
	 * This method returns a list of state ballot measures in a given year.
	 * 
	 * @param year
	 * @param stateId
	 * @return {@link Measures}: List of minimal measure information.
	 */
	public Measures getMeasuresByYearState(String year, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Measure.getMeasuresByYearState", new ArgMap("year", year, "stateId", stateId), Measures.class );
	}

	/**
	 * This method returns a single Ballot Measure detail.
	 * 
	 * @param measureId
	 * @return {@link Measure}: detail on single measure
	 */
	public Measure getMeasure(String measureId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Measure.getMeasure", new ArgMap("measureId", measureId), Measure.class );
	}
	
}
