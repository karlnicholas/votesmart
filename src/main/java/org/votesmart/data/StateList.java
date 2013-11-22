package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * statelist.list.state*.stateId,
 * statelist.list.state*.name.
 * </pre>
 */
@XmlRootElement(name="stateList")
public class StateList extends GeneralInfoBase {
	public List list;
	
	@XmlType(name="list", namespace="stateList")
	public static class List {
		public ArrayList<State> state;
		
		@XmlType(name="state", namespace="stateList")
		public static class State {
			public String stateId;
			public String name;
		}
	}
}

