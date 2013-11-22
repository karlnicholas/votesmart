package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Output:
 * elections.election*.electionId, 
 * elections.election*.name, 
 * elections.election*.stateId, 
 * elections.election*.officeTypeId, 
 * elections.election*.special, 
 * elections.election*.electionYear.
 * </pre>
 */
@XmlRootElement(name="elections")
public class ElectionByZip {
	public ArrayList<Election> election;
}
