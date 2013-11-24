package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.Branches;
import org.votesmart.data.Levels;
import org.votesmart.data.OfficeTypes;
import org.votesmart.data.Offices;

/**
 * <pre>
 * Office Class
 * 
 * Office.getTypes
 * This method dumps all office types we keep track of
 * Input: none
 * Output: {@link OfficeTypes} 
 * 
 * Office.getBranches
 * This method dumps the branches of government and their IDs
 * Input: none
 * Output: {@link Branches}
 * 
 * Office.getLevels
 * This method dumps the levels of government and their IDs
 * Input: none
 * Output: {@link Levels}
 * 
 * Office.getOfficesByType
 * This method dumps offices we keep track of according to type.
 * Input: officeTypeId*
 * Output: {@link Offices}
 * 
 * Office.getOfficesByLevel
 * This method dumps offices we keep track of according to level.
 * Input: levelId*
 * Output: {@link Offices}
 * 
 * Office.getOfficesByTypeLevel
 * This method dumps offices we keep track of according to type and level.
 * Input: officeTypeId*, levelId*
 * Output: {@link Offices}
 * 
 * Office.getOfficesByBranchLevel
 * This method dumps offices we keep track of according to branch and level.
 * Input: branchId*, levelId*
 * Output: {@link Offices}
 * 
 * ============== EXAMPLE USAGE ============
 * 
 * // Get general Information about offices
 * OfficeClass officeClass = new OfficeClass();
 * 
 * // get Office.getBranches
 * Branches branches = officeClass.getBranches();
 * Branches.Branch officeBranch = branches.branch.get(1);
 * 
 * // Office.getTypes
 * OfficeTypes officeTypes = officeClass.getTypes();
 * OfficeTypes.Type officeType  = officeTypes.type.get(5);
 * 
 * // Office.getLevels
 * Levels levels = officeClass.getLevels();
 * Levels.Level officeLevel = levels.level.get(1);
 * </pre>
 *  
 */
public class OfficeClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public OfficeClass(VoteSmartAPI api) {
		super(api);
	}
	
	/**
	 * Default Constructor
	 */
	public OfficeClass() {
		super();
	}
	
	/**
	 * This method dumps all office types we keep track of.
	 * 
	 * @return {@link OfficeTypes}: 
	 */
	public OfficeTypes getTypes() throws VoteSmartException, VoteSmartErrorException {
		return api.query("Office.getTypes", null, OfficeTypes.class );
	}

	/**
	 * This method dumps the branches of government and their IDs.
	 * 
	 * @return {@link Branches}: 
	 */
	public Branches getBranches() throws VoteSmartException, VoteSmartErrorException {
		return api.query("Office.getBranches", null, Branches.class );
	}
	
	/**
	 * This method dumps the levels of government and their IDs.
	 * 
	 * @return {@link Levels}: 
	 */
	public Levels getLevels() throws VoteSmartException, VoteSmartErrorException {
		return api.query("Office.getLevels", null, Levels.class );
	}

	/**
	 * This method dumps offices we keep track of according to type.
	 * 
	 * @param officeTypeId
	 * @return {@link Offices}: 
	 */
	public Offices getOfficesByType(String officeTypeId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Office.getOfficesByType", new ArgMap("officeTypeId", officeTypeId), Offices.class );
	}

	/**
	 * This method dumps offices we keep track of according to level.
	 * 
	 * @param levelId
	 * @return {@link Offices}: 
	 */
	public Offices getOfficesByLevel(String levelId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Office.getOfficesByLevel", new ArgMap("levelId", levelId), Offices.class );
	}
	
	/**
	 * This method dumps offices we keep track of according to type and level.
	 * 
	 * @param officeTypeId
	 * @param officeLevelId
	 * @return {@link Offices}: 
	 */
	public Offices getOfficesByTypeLevel(String officeTypeId, String officeLevelId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Office.getOfficesByTypeLevel", new ArgMap("officeTypeId", officeTypeId, "officeLevelId", officeLevelId), Offices.class );
	}

	/**
	 * This method dumps offices we keep track of according to branch and level.
	 * 
	 * @param branchId
	 * @param levelId
	 * @return {@link Offices}: 
	 */
	public Offices getOfficesByBranchLevel(String branchId, String levelId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("Office.getOfficesByBranchLevel", new ArgMap("branchId", branchId, "levelId", levelId), Offices.class );
	}

}
