package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * leadership.position*.leadershipId, 
 * leadership.position*.name, 
 * leadership.position*.officeId, 
 * leadership.position*.officeName.
 * </pre>
 */
@XmlRootElement(name="leadership")
public class Leadership extends GeneralInfoBase {
	
	public ArrayList<Position> position;
	
	@XmlType(name="position", namespace="leadership")
	public static class Position {
		public String leadershipId;
		public String name;
		public String officeId;
		public String officeName;
	}
}

