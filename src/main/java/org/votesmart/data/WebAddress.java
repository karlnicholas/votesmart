package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output:
 * address.candidate.title, 
 * webaddress.candidate.firstName, 
 * webaddress.candidate.middleName, 
 * webaddress.candidate.nickName, 
 * webaddress.candidate.lastName, 
 * webaddress.candidate.suffix, 
 * webaddress.address*.webAddressTypeId, 
 * webaddress.address*.webAddressType, 
 * webaddress.address*.webAddress.
 * </pre>
 */
@XmlRootElement(name="webaddress")
public class WebAddress extends GeneralInfoBase {
	
	public CandidateMed candidate;
	public ArrayList<Address> address;
	
	@XmlType(name="address", namespace="webaddress")
	public static class Address {
		public String webAddressTypeId;
		public String webAddressType;
		public String webAddress;
	}

}
