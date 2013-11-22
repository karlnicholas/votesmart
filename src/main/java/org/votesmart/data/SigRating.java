package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * sig.sigId,
 * sig.name,
 * rating*.ratingId,
 * rating*.timespan,
 * rating*.ratingName,
 * rating*.ratingText.
 * </pre>
 */
@XmlRootElement(name="sigRating")
public class SigRating extends GeneralInfoBase {
	public Sig sig;
	public ArrayList<Rating> rating;

	@XmlType(name="sig", namespace="sigRating")
	public static class Sig {
		public String sigId;
		public String name;
	}
	@XmlType(name="rating", namespace="sigRating")
	public static class Rating {
		public String ratingId;
		public String timespan;
		public String ratingName;
		public String ratingText;
	}
}

