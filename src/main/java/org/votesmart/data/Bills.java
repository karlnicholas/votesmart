package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Output: 
 * bills.bill*.{@link BillMin}.
 * </pre>
 *
 */
@XmlRootElement(name="bills")
public class Bills extends GeneralInfoBase {
	
	public ArrayList<BillMin> bill;

}
