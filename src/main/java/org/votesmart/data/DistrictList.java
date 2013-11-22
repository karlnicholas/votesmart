package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * districtList.district*.districtId,
 * districtList.district*.name, 
 * districtList.district*.officeId, 
 * districtList.district*.stateId.
 * </pre>
 */
@XmlRootElement(name="districtList")
public class DistrictList extends GeneralInfoBase {
	public String zipMessage;
	public ArrayList<District> district;
	public ArrayList<District> electionDistricts;

	@XmlType(name="district", namespace="districtList")
	public static class District {
		public String districtId;
		public String name;
		public String officeId;
		public String stateId;
	}
}
