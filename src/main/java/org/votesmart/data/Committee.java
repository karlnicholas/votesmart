package org.votesmart.data;

import java.net.URL;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output: 
 * committee.committeeId,
 * committee.parentId,
 * committee.stateId, 
 * committee.committeeTypeId, 
 * committee.name, 
 * committee.jurisdiction, 
 * committee.contact.address1, 
 * committee.contact.address2, 
 * committee.contact.city, 
 * committee.contact.state, 
 * committee.contact.zip, 
 * committee.contact.phone, 
 * committee.contact.fax, 
 * committee.contact.email, 
 * committee.contact.url, 
 * committee.contact.staffContact.
 * </pre>
 *
 */
@XmlRootElement(name="committee")
public class Committee extends GeneralInfoBase {
	public String committeeId;
	public String parentId;
	public String stateId;
	public String committeeTypeId;
	public String name;
	public String jurisdiction;
	public Contact contact;
	 
	@XmlType(name="contact", namespace="committee")
	public static class Contact {
		public String address1;
		public String address2;
		public String city;
		public String state;
		public String zip;
		public String phone;
		public String fax;
		public String email;
		public URL url;
		public String staffContact;
	}

}

