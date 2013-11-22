package org.votesmart.api;

import java.util.TreeMap;

/**
 * You can either add arguments in pairs in the constructor or you
 * can add them manually after you construct an empty map.
 * 
 * @author karl
 *
 */
public class ArgMap extends TreeMap<String, String> {
	private static final long serialVersionUID = -2664255408377082118L;
	
	public ArgMap(String... args ) {
		for ( int i=0; i<args.length; i+=2) {
			this.put(args[i], args[i+1]);
		}
	}
}
