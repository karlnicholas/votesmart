package org.votesmart.data;

import java.net.URL;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * state.details.stateId,
 * state.details.stateType,
 * state.details.name,
 * state.details.nickName,
 * state.details.capital,
 * state.details.area
 * state.details.population,
 * state.details.statehood,
 * state.details.motto,
 * state.details.flower,
 * state.details.tree,
 * state.details.bird,
 * state.details.highPoint,
 * state.details.lowPoint,
 * state.details.bicameral,
 * state.details.upperLegis,
 * state.details.lowerLegis,
 * state.details.ltGov,
 * state.details.senators,
 * state.details.reps,
 * state.details.termLimit,
 * state.details.termLength,
 * state.details.billUrl,
 * state.details.voteUrl,
 * state.details.voterReg,
 * state.details.primaryDate,
 * state.details.generalDate,
 * state.details.absenteeWho,
 * state.details.absenteeHow,
 * state.details.absenteeWhen,
 * state.details.largestCity,
 * state.details.rollUpper,
 * state.details.rollLower,
 * state.details.usCircuit.
 * </pre>
 */
@XmlRootElement(name="state")
public class State extends GeneralInfoBase {
	
	public Details details;

	@XmlType(name="details", namespace="state")
	public static class Details {
		public String stateId;
		public String stateType;
		public String name;
		public String nickName;
		public String capital;
		public String area;
		public String population;
		public String statehood;
		public String motto;
		public String flower;
		public String tree;
		public String bird;
		public String highPoint;
		public String lowPoint;
		public String bicameral;
		public String upperLegis;
		public String lowerLegis;
		public String ltGov;
		public String senators;
		public String reps;
		public String termLimit;
		public String termLength;
		public URL billUrl;
		public URL voteUrl;
		public String voterReg;
		public String primaryDate;
		public String generalDate;
		public String absenteeWho;
		public String absenteeHow;
		public String absenteeWhen;
		public String largestCity;
		public String rollUpper;
		public String rollLower;
		public String usCircuit;
	}
}

