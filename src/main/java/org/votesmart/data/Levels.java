package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * levels.level*.officeLevelId, 
 * levels.level*.name.
 * </pre>
 */
@XmlRootElement(name="levels")
public class Levels extends GeneralInfoBase {

	public ArrayList<Level> level;
	
	@XmlType(name="level", namespace="levels")
	public static class Level {
		public String officeLevelId;
		public String name;
	}

}

