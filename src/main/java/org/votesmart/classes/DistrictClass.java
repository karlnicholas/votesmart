package org.votesmart.classes;

import org.votesmart.api.*;
import org.votesmart.data.DistrictList;

/**
 * <pre>
 * District Class
 * 
 * District.getByOfficeState()
 * This method grabs district IDs according to the office and state.
 * Input: officeId*, stateId*, districtName(Default: Null)
 * Output: {@link DistrictList}
 * 
 * District.getByZip()
 * This method grabs district IDs according to the zip code.
 * Input: zip5*, zip4 (Default: Null)
 * Output: {@link DistrictList}
 * 
 * ============= EXAMPLE USAGE ===================
 * 
 * DistrictClass districtClass = new DistrictClass();
 * 
 * DistrictList districtList = districtClass.getByOfficeState(office.officeId, state.stateId);
 * DistrictList.District district = districtList.district.get(0);
 * 
 * </pre>
 *
 */
public class DistrictClass extends ClassesBase {

	/**
	 * Constructor for testing purposes.
	 * 
	 * @param api
	 */
	public DistrictClass(VoteSmartAPI api) {
		super(api);
	}
	
	/**
	 * Default Constructor
	 */
	public DistrictClass() {
		super();
	}

	/**
	 * This method grabs district IDs according to the office and state.
	 * 
	 * @param officeId
	 * @param stateId
	 * @return {@link DistrictList}: 
	 */
	public DistrictList getByOfficeState( String officeId, String stateId) throws VoteSmartException, VoteSmartErrorException {
		return api.query("District.getByOfficeState", new ArgMap("officeId", officeId, "stateId", stateId), DistrictList.class );
	}
	
	/**
	 * This method grabs district IDs according to the office and state.
	 * 
	 * @param officeId
	 * @param stateId
	 * @param districtName
	 * @return {@link DistrictList}: 
	 */
	public DistrictList getByOfficeState( String officeId, String stateId, String districtName) throws VoteSmartException, VoteSmartErrorException {
		return api.query("District.getByOfficeState", new ArgMap("officeId", officeId, "stateId", stateId, "districtName", districtName), DistrictList.class );
	}
	
	/**
	 * This method grabs district IDs according to the zip code.
	 * 
	 * @param zip5
	 * @return {@link DistrictList}: 
	 */
	public DistrictList getByZip( String zip5) throws VoteSmartException, VoteSmartErrorException {
		return api.query("District.getByZip", new ArgMap("zip5", zip5), DistrictList.class );
	}

	/**
	 * This method grabs district IDs according to the zip code.
	 * 
	 * @param zip5
	 * @param zip4
	 * @return {@link DistrictList}: 
	 */
	public DistrictList getByZip( String zip5, String zip4) throws VoteSmartException, VoteSmartErrorException {
		return api.query("District.getByZip", new ArgMap("zip5", zip5, "zip4", zip4), DistrictList.class );
	}
	
}
