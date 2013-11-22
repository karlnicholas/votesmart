package org.votesmart.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Output:
 * action.billId, 
 * action.billNumber, 
 * action.actionId, 
 * action.category, 
 * action.categoryId, 
 * action.type, 
 * action.stateId, 
 * action.level, 
 * action.stage, 
 * action.outcome, 
 * action.rollNumber, 
 * action.yea, 
 * action.nay, 
 * action.voiceVote, 
 * action.title, 
 * action.officialTitle, 
 * action.highlight, 
 * action.synopsis, 
 * action.officialSynopsis, 
 * action.note.
 * </pre>
 *
 */
@XmlRootElement(name="action")
public class BillAction extends GeneralInfoBase {
	public String billId;
	public String billNumber;
	public String actionId;
	public String category;
	public String categoryId;
	public String type;
	public String stateId;
	public String level;
	public String stage;
	public String outcome;
	public String rollNumber;
	public String yea;
	public String nay;
	public String voiceVote;
	public String title;
	public String officialTitle;
	public String highlight;
	public String synopsis;
	public String officialSynopsis;
	public String note;
}

