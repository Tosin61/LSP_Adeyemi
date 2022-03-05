package org.howard.edu.lsp.assignment5.test;
import org.howard.edu.lsp.assignment5.implementation.*;
/**
 * Date: March 3-2022
 * IntegerSet Implementation tests to make sure methods are working
 * @author oluwatosin
 * @version 1.0
 *
 */
public class Driver {
	public static void main(String[] args) throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.add(6);
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Smallest value in Set1 is: " + set1.smallest()); //smallest check
		System.out.println("Largest value in Set1 is: " + set1.largest()); //largest check

		IntegerSet set2 = new IntegerSet();
		set2.add(1);
		set2.add(2);
		set2.add(3);

		System.out.println("Union of Set1 and Set2");
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Value of Set2 is:" + set2.toString());
		System.out.println("Result of union of Set1 and Set2");
		set1.union(set2);	// result of union of set1 and set2
		
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Result of intersect of Set1 and Set2");
		set1.intersect(set2); //results of intersect of set1 and set2
		
		System.out.println("Value of Set1 is: " + set1.toString());
		System.out.println("Value of Set2 is: " + set2.toString());
		System.out.println("Result of difference of Set1 and Set2");
		set1.diff(set2); //results of difference of set1 and set2
		 
		System.out.println("Checking if Set1 and Set2 are equal:" + set1.equals(set2)); //Equals check 1
		
		System.out.println("Removing 4, 5, 6 from Set 1 "); 
		set1.remove(4);
		set1.remove(5);
		set1.remove(6);
		System.out.println("Value of Set1 is:" + set1.toString()); //Remove check
		
		System.out.println("Checking if Set1 and Set2 are equal:" + set1.equals(set2)); // Equals check 2
		
		System.out.println("Length of Set1:" + set1.length()); // Length check 
		
		System.out.println("Clearing Set1"); 
		set1.clear();
		System.out.println("Value of Set1 is: " + set1.toString()); // clear check
		
		System.out.println("Length of Set1:" + set1.length()); // Length check 
		
		System.out.println("Checking if Set1 is empty: " + set1.isEmpty()); // isEmpty check
		
		System.out.println("Adding 4, 5, 6 to Set 1 "); 
		set1.add(4);
		set1.add(5);
		set1.add(6);
		System.out.println("Value of Set1 is:" + set1.toString());
		
		System.out.println("Checking if Set1 is empty: " + set1.isEmpty()); // isEmpty check
		
		System.out.println("Checking if Set1 contains 4: " + set1.contains(4)); // contains check
		System.out.println("Checking if Set1 contains 10: " + set1.contains(10)); // contains check
	}
}
