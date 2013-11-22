package org.votesmart.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Output: 
 * sig.sigId,
 * sig.parentId,
 * sig.stateId,
 * sig.name,
 * sig.description,
 * sig.address,
 * sig.city,
 * sig.state,
 * sig.zip,
 * sig.phone1,
 * sig.phone2,
 * sig.fax,
 * sig.email,
 * sig.url,
 * sig.contactName.
 * </pre>
 *
 */
@XmlRootElement(name="sig")
public class Sig  extends GeneralInfoBase {
	public String sigId;
	public String parentId;
	public String stateId;
	public String name;
	public String description;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phone1;
	public String phone2;
	public String fax;
	public String email;
	public String url;
	public String contactName;
}

