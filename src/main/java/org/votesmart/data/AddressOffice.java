package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Output:
 * {@link CandidateMed}, 
 * {@link OfficeAddress}*.
 * </pre>
 *
 */
@XmlRootElement(name="address")
public class AddressOffice extends GeneralInfoBase {
	
	public CandidateMed candidate;
	public ArrayList<OfficeAddress> office;

}
