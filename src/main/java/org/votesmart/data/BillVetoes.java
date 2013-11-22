package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output:
 * bills.bill*.vetoId, 
 * bills.bill*.statusDate, 
 * bills.bill*.{@link BillMin},
 * bills.bill*.vetoCode, 
 * bills.bill*.vetoType,
 * bills.bill*.billSummary, 
 * bills.bill*.billLink, 
 * bills.bill*.vetoLetterLink.
 * </pre>
 *
 */
@XmlRootElement(name="bills")
public class BillVetoes {
	public ArrayList<Bill> bill;
	
	@XmlType(name="bill", namespace="bills")
	public static class Bill extends BillMin {
		 public String vetoId;
		 public String statusDate;
		 public String vetoCode;
		 public String vetoType;
		 public String billSummary;
		 public String billLink;
		 public String vetoLetterLink;
	}
}
