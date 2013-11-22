package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output:
 * elections.election*.electionId, 
 * elections.election*.name, 
 * elections.election*.stateId, 
 * elections.election*.officeTypeId, 
 * elections.election*.special, 
 * elections.election*.electionYear, 
 * elections.election*.stage*.stageId, 
 * elections.election*.stage*.name, 
 * elections.election*.stage*.stateId, 
 * elections.election*.stage*.electionDate, 
 * elections.election*.stage*.filingDeadline, 
 * elections.election*.stage*.npatMailed.
 * </pre>
 */
@XmlRootElement(name="elections")
public class Elections extends GeneralInfoBase {
	
	public ArrayList<ElectionStage> election;
	
	@XmlType(name="election", namespace="elections")
	public static class ElectionStage extends Election {
		public ArrayList<Stage> stage;

		@XmlType(name="stage", namespace="elections.election")
		public static class Stage {
			public String stageId;
			public String name;
			public String stateId;
			public String electionDate;
			public String filingDeadline;
			public String npatMailed;
		}
	}
}
