package org.votesmart.data;

import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output:
 * type, 
 * typeId, 
 * street, 
 * city, 
 * state, 
 * zip.
 * </pre>
 *
 */
@XmlType(name="address")
public class Address {
	public String type;
	public String typeId;
	public String street;
	public String city;
	public String state;
	public String zip;
}
