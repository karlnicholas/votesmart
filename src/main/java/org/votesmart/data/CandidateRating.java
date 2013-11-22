package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * candidateRating.candidate.{@link CandidateTitle}, 
 * candidateRating.candidate.office, 
 * candidateRating.rating*.sigId, 
 * candidateRating.rating*.ratingId, 
 * candidateRating.rating*.categories.category*.categoryId, 
 * candidateRating.rating*.categories.category*.name, 
 * candidateRating.rating*.timeSpan, 
 * candidateRating.rating*.rating, 
 * candidateRating.rating*.ratingName, 
 * candidateRating.rating*.ratingText.
 * </pre>
 *
 */
@XmlRootElement(name="candidateRating")
public class CandidateRating extends GeneralInfoBase {
	public CandidateTitle candidate;
	public String office;
	public ArrayList<Rating> rating;
	
	@XmlType(name="rating", namespace="candidateRating")
	public static class Rating {
		public String sigId;
		public String ratingId;
		public ArrayList<Category> categories;
		public String timeSpan;
		public String rating;
		public String ratingName;
		public String ratingText;
		
		@XmlType(name="category", namespace="candidateRating.rating")
		public static class Category { 
			public String categoryId;
			public String name;
		}
	}
}

