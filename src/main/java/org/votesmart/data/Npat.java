package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * npat.candidateId, 
 * npat.candidate, 
 * npat.passed, 
 * npat.npatName, 
 * npat.electionName, 
 * npat.electionYear, 
 * npat.electionDate, 
 * npat.electionStage, 
 * npat.surveyMessage, 
 * npat.section*.name, 
 * npat.section*.row*.path, 
 * npat.section*.row*.rowText, 
 * npat.section*.row*.rowType, 
 * npat.section*.row*.open, 
 * npat.section*.row*.optionText, 
 * npat.section*.row*.answerText, 
 * npat.section*.row*.row**
 * </pre>
 */
@XmlRootElement(name="npat")
public class Npat extends GeneralInfoBase {
	public String candidateId;
	public String candidate;
	public String passed;
	public String npatName;
	public String electionName;
	public String electionYear;
	public String electionDate;
	public String electionStage;
	public String surveyMessage;
	public ArrayList<Section> section;
	
	@XmlType(name="section", namespace="npat")
	public static class Section {
		public String name;
		public ArrayList<Row> row;
		
		@XmlType(name="row", namespace="npat.section")
		public static class Row {
			public String path;
			public String rowText;
			public String rowType;
			public String open;
			public String optionText;
			public String answerText;
			public ArrayList<Row> row;
		}
	}

}

