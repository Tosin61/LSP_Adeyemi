package org.howard.edu.lsp.assignment5.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.List;

/**
 * Date: March 3-2022
 * This is simple application for basic set operations
 * @author oluwatosin
 * @version 1.0
 *
 */
public class IntegerSet  {
	/**
	 * Array list of values inside of our set
	 */
	private List<Integer> set = new ArrayList<Integer>();

	/**
	 * Default Constructor
	 */
	public IntegerSet() {
	}
	/**
	 * Adds an item to the set or does nothing it already there
	 * @param num item that is being added to the set if it isn't already there.
	 */
	public void add(int num) {
		if(!(set.contains(num))) {
		set.add(num);
		}
	}
	
	/**
	 * Array list of IntegerSet array
	 * @return ArrayList of the set
	 */
	public List<Integer> lst(){
		return set;
	}
	
	/**
	 * Clears the internal representation of the set
	 */
	public void clear() {
		set.clear(); 
	}

	/**
	 * Returns the length of the set
	 * @return int value for number of items in the set
	 */
	public int length() {
		return set.size();
	}
	

	/**
	 * Returns true if the 2 sets are equal, false otherwise;
     * Two sets are equal if they contain all of the same values in ANY order.
	 * @param b second IntegerSet being compared
	 * @return boolean value. True if sets are equal and False if they aren't
	 */
	public boolean equals(IntegerSet b) {
		List<Integer> setb = b.lst();
		int sizea = set.size();
		int sizeb = setb.size();
		if (sizea != sizeb) {
			return false;
		}
		List<Integer> sorta = new ArrayList<Integer>(set);
		List<Integer> sortb = new ArrayList<Integer>(setb);
		Collections.sort(sorta);
	    Collections.sort(sortb);
	    
	    return sorta.equals(sortb);	
	}
	/**
	 * Checks to see if number is inside the set
	 * @param value int value for number being checked
	 * @return boolean value. true if the set contains the value, otherwise false
	 */
	public boolean contains(int value) {
		if (set.contains(value)){
			return true;
		}
		return false;
	}
	/**
	 * Checks to see if set is empty
	 * @return boolean value. true if set has no items and false otherwise
	 */
	public boolean isEmpty() {
		int num = set.size();
		if (num == 0) {
			return true;
		}
		return false;
	}
	/**
	 *String representation of set
	 */
	public String toString() {
		return set.toString();
	} 
	/**
	 * Returns the largest item in the set; Throws a IntegerSetException if the set is empty
	 * @return int value of largest inside the set
	 * @throws IntegerSetException if the set is empty
	 */
	public int largest() throws IntegerSetException {
		int size = set.size();
		if (size > 0) {
		return Collections.max(set);
		}
		else {
			throw new IntegerSetException("Error: Set is empty");
		}
	}

	/**
	 * Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	 * @return int value of smallest inside the set
	 * @throws IntegerSetException if the set is empty
	 */
	public int smallest() throws IntegerSetException {
		int size = set.size();
		if (size > 0) {
		return Collections.min(set);
		}
		else {
			throw new IntegerSetException("Error: Set is empty");
		}
	}
	
	/**
	 * Removes an item from the set or does nothing if not there
	 * @param item int value of item to be removed from set
	 * @throws IntegerSetException if the set is empty
	 */
	public void remove(int item) throws IntegerSetException {
		int size = set.size();
		if (size > 0) {
		set.remove(new Integer(item));
		}
		else {
			throw new IntegerSetException("Error: Set is empty");
		}
	}

	/**
	 * Union of both sets is all the elements in both sets
	 * @param intSetb other set being compared
	 */
	public void union(IntegerSet intSetb) {
		IntegerSet c = new IntegerSet();
		List<Integer> listb = intSetb.lst();
		for (int i=0; i < set.size(); i++){
		  c.add(set.get(i));
		  }
		for (int i=0; i < listb.size(); i++){
		  c.add(listb.get(i));
		  }
		System.out.println(c.toString());
	};

	/**
	 * Intersection of Set1 and Set2 is the elements they both have.
	 * @param intSetb other set being compared
	 */
	public void intersect(IntegerSet intSetb) {
		List<Integer> listc = new ArrayList<Integer>(set);
		List<Integer> listb = intSetb.lst();
		List<Integer> listd = new ArrayList<Integer>(listb);
		listd.retainAll(listc);
		System.out.println(listd.toString());
	}; 
	/**
	 * Set1 - Set2 = Set1 minus the intersection of Set1 and Set2
	 * @param intSetb other set being compared
	 */
	public void diff(IntegerSet intSetb) {
		List<Integer> listb = intSetb.lst();
		listb.retainAll(set);
		List<Integer> listc = new ArrayList<Integer>(set);
		List<Integer> listd = new ArrayList<Integer>(listb);
		listc.removeAll(listd);
		System.out.println(listc.toString());
	}

	
}