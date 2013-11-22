package org.votesmart.data;

import java.net.URL;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Output: 
 * measure.measureId, 
 * measure.measureCode, 
 * measure.title, 
 * measure.electionDate, 
 * measure.electionType, 
 * measure.source, 
 * measure.url, 
 * measure.summary, 
 * measure.summaryUrl, 
 * measure.measureText, 
 * measure.textUrl, 
 * measure.proUrl, 
 * measure.conUrl, 
 * measure.yes, 
 * measure.no, 
 * measure.outcome.
 * </pre>
 */
@XmlRootElement(name="measure")
public class Measure extends GeneralInfoBase {
	public String measureId;
	public String measureCode;
	public String title;
	public String outcome;
	public String electionDate;
	public String electionType;
	public String source;
	public URL url;
	public String summary;
	public URL summaryUrl;
	public String measureText;
	public URL textUrl;
	public URL proUrl;
	public URL conUrl;
	public String yes;
	public String no;
}	
