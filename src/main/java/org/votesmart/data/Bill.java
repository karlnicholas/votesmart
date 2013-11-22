package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * bill.billNumber,
 * bill.parentBill,
 * bill.title,
 * bill.officialTitle,
 * bill.dateIntroduced,
 * bill.type, 
 * bill.categories.category*.categoryId, 
 * bill.categories.category*.name, 
 * bill.billtextLink, 
 * bill.sponsors.sponsor*.candidateId, 
 * bill.sponsors.sponsor*.name, 
 * bill.sponsors.sponsor*.type, 
 * bill.committeeSponsors.committeeSponsor*.committeeId, 
 * bill.committeeSponsors.committeeSponsor*.name, 
 * bill.actions.action*.actionId,
 * bill.actions.action*.level, 
 * bill.actions.action*.stage, 
 * bill.actions.action*.outcome, 
 * bill.actions.action*.statusDate, 
 * bill.actions.action*.rollNumber, 
 * bill.actions.action*.yea, 
 * bill.actions.action*.nay, 
 * bill.actions.action*.voiceVote, 
 * bill.amendments.amendment*.billNumber, 
 * bill.amendments.amendment*.actionId, 
 * bill.amendments.amendment*.title, 
 * bill.amendments.amendment*.statusDate.
 * </pre>
 *
 */
@XmlRootElement(name="bill")
public class Bill extends GeneralInfoBase {
	
	public String billNumber;
	public String parentBill;
	public String title;
	public String officialTitle;
	public String dateIntroduced;
	public String type;
	public VotesCategories categories;
	public String billtextLink;
	public Sponsors sponsors;
	public CommitteeSponsors committeeSponsors;
	public Actions actions;
	public Amendments amendments;
	
	public static class Sponsors {
		public ArrayList<Sponsor> sponsor;
		@XmlType(name="sponsor", namespace="bill")
		public static class Sponsor {
			public String candidateId;
			public String name;
			public String type;
		}
	}
	
	@XmlType(name="committeeSponsors", namespace="bill")
	public static class CommitteeSponsors {
		public ArrayList<CommitteeSponsor> committeesponsor;

		@XmlType(name="committeeSponsor", namespace="bill.committeeSponsors")
		public static class CommitteeSponsor {
			public String committeeId;
			public String name;
		}
	}
	
	@XmlType(name="actions", namespace="bill")
	public static class Actions {
		public ArrayList<Action> action;
		
		@XmlType(name="action", namespace="bill.actions")
		public static class Action {
			public String actionId;
			public String level;
			public String stage;
			public String outcome;
			public String statusDate;
			public String rollNumber;
			public String yea;
			public String nay;
			public String voiceVote;
		}
	}
	
	@XmlType(name="amendments", namespace="bill")	
	public static class Amendments {
		public ArrayList<Amendment> amendment;

		@XmlType(name="amendment", namespace="bill.amendments")	
		public static class Amendment {
			public String billNumber;
			public String actionId;
			public String title;
			public String statusDate;
		}
	}

}
