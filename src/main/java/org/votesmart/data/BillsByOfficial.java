package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Output: 
 * bills.bill*.{@link BillMed}.
 * </pre>
 *
 */
@XmlRootElement(name="bills")
public class BillsByOfficial extends GeneralInfoBase {
	
	public ArrayList<BillMed> bill;
	
}
