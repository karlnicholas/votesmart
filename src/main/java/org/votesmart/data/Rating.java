package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * candidateRating*.candidateId, 
 * candidateRating*.rating.
 * </pre>
 */
@XmlRootElement(name="rating")
public class Rating extends GeneralInfoBase {

	public ArrayList<CandidateRating> candidateRating;
	
	@XmlType(name="candidateRating", namespace="rating")
	public static class CandidateRating {
		public String candidateId;
		public String rating;
	}
}

