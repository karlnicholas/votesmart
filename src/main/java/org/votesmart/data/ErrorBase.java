package org.votesmart.data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Output:
 * errorMessage.
 * </pre>
 *
 */
@XmlRootElement(name="error")
public class ErrorBase {
	
	public String errorMessage;
}
