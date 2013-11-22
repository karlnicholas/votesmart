package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * sigs.sig*.sigId,
 * sigs.sig*.parentId,
 * sigs.sig*.name.
 * </pre>
 */
@XmlRootElement(name="sigs")
public class Sigs extends GeneralInfoBase {
	public ArrayList<Sig> sig;
	@XmlType(name="sig", namespace="sigs")
	public static class Sig {
		public String sigId;
		public String parentId;
		public String name;
	}
}

