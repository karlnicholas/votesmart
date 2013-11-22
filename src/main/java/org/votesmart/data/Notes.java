package org.votesmart.data;

import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output:
 * contactName, 
 * contactTitle, 
 * note. 
 * </pre>
 */
@XmlType(name="notes")
public class Notes {
	public String contactName;
	public String contactTitle;
	public String note;
}
