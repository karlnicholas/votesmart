package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * measures.measure*.measureId, 
 * measures.measure*.measureCode,
 * measures.measure*.titlemeasures.measure*.outcome.
 * </pre>
 */
@XmlRootElement(name="measures")
public class Measures extends GeneralInfoBase  {
	
	public ArrayList<Measure> measure;

	@XmlType(name="measure", namespace="measures")
	public static class Measure {
		public String measureId;
		public String measureCode;
		public String title;
		public String outcome;
	}

}
