package org.votesmart.data;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * Output: 
 * categories.category*.categoryId, 
 * categories.category*.name.
 * </pre>
 */
@XmlRootElement(name="categories")
public class VotesCategories extends GeneralInfoBase {
	public ArrayList<CategoryMin> category;
	
}

