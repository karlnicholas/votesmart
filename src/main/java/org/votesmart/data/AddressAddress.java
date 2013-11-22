package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Output:
 * {@link Office}
 * </pre>
 *
 */
@XmlRootElement(name="address")
public class AddressAddress extends GeneralInfoBase {
	
	public ArrayList<Office> office;

}

