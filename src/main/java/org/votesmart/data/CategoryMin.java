package org.votesmart.data;

import javax.xml.bind.annotation.XmlType;

/**
 * <pre>
 * Output:
 * categoryId, 
 * name.
 * </pre>
 *
 */
@XmlType(name="category")
public class CategoryMin {
	public String categoryId;
	public String name;
}
