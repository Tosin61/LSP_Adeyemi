package org.howard.edu.lsp.assignment6.juinit;
import org.howard.edu.lsp.assignment6.integerset.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IntegerSetTest {

	@Test
	public void testEquals() {
		
		IntegerSet list1 = new IntegerSet();
		IntegerSet list2 = new IntegerSet();
		list1.add(5);
		list1.add(2);
		list1.add(1);
		list2.add(1);
		list2.add(5);
		list2.add(2);
		boolean test1_output = list1.equals(list2);
		assertEquals(true, test1_output); //Still equal regardless of order
		
		list2.add(4);
		
		boolean test2_output = list1.equals(list2);
		assertEquals(false, test2_output); //No longer equal after adding unique number to one list
		
		IntegerSet list3 = new IntegerSet();
		IntegerSet list4 = new IntegerSet();
		boolean test3_output = list3.equals(list4); 
		assertEquals(true, test3_output); //Empty list are equal
		
		list3.add(1);
		list3.add(1);
		list4.add(1);
		boolean test4_output = list3.equals(list4);
		assertEquals(true, test4_output); //Duplicates aren't added
	}
	
	@Test
	public void testAdd() {
		
		IntegerSet list1 = new IntegerSet();
		list1.add(3);
		
		boolean test1_output = list1.contains(3);
		assertEquals(true, test1_output); //contains number added
		boolean test2_output = list1.contains(4);
		assertEquals(false, test2_output); //doesn't contain a number not added
		
		list1.add(4);
		boolean test3_output = list1.contains(4);
		assertEquals(true, test3_output); //contains number added
		
		boolean test4_output = list1.contains(0);
		assertEquals(false, test4_output); //doesn't contain number not added
	}
	
	@Test
	public void testLst() {
		
		List <Integer> test_lst = new ArrayList<Integer>();
		test_lst.add(3);
		test_lst.add(2);
		test_lst.add(4);
		
		IntegerSet list1 = new IntegerSet();
		list1.add(3);
		list1.add(2);
		list1.add(4);
		
		List<Integer> test_lst2 = list1.lst();
		
		boolean test1_output = test_lst.equals(test_lst2);
		assertEquals(true, test1_output); //successful transformation to list and both are equal
		
		IntegerSet list2 = new IntegerSet();
		list2.add(3);
		List<Integer> test_lst3 = list2.lst();
		boolean test2_output = test_lst.equals(test_lst3);
		assertEquals(false, test2_output);//successful transformation to list and both are not equal
		
	}
	
	@Test
	public void testClear() {
		
		IntegerSet clear_list = new IntegerSet();
		IntegerSet list1 = new IntegerSet();
		list1.add(5);
		list1.add(6);
		boolean test1_output = list1.equals(clear_list);
		assertEquals(false,test1_output); //list is not clear
		
		list1.clear();
		boolean test2_output = list1.equals(clear_list);
		assertEquals(true,test2_output); //list is clear
	}
	
	@Test
	public void testLength() {
		IntegerSet list1 = new IntegerSet();
		int test1_output = list1.length();
		assertEquals(0,test1_output); //length of empty list should be 0
		
		list1.add(5);
		list1.add(6);
		list1.add(3);
		int test2_output = list1.length();
		assertEquals(3,test2_output); //added 3 new items, so new length should be 3
		
		list1.add(3);
		int test3_output = list1.length();
		assertEquals(3,test3_output); //length should remain the same because dupes aren't added	
		
		list1.clear();
		int test4_output = list1.length();
		assertEquals(0,test4_output); //after clearing length should return back to 0
	}
	
	@Test
	public void testContains() {
		IntegerSet list1 = new IntegerSet();
		list1.add(3);
		list1.add(2);
		list1.add(4);
		
		boolean test1_output = list1.contains(3);
		boolean test2_output = list1.contains(2);
		boolean test3_output = list1.contains(4);
		assertEquals(true,test1_output); 
		assertEquals(true,test2_output);
		assertEquals(true,test3_output); //all numbers added should be inside the list
		
		boolean test4_output = list1.contains(5);
		assertEquals(false,test4_output); //number never added t list should not contain number
		
		list1.clear();
		boolean test5_output = list1.contains(3);
		boolean test6_output = list1.contains(2);
		boolean test7_output = list1.contains(4);
		assertEquals(false,test5_output); 
		assertEquals(false,test6_output);
		assertEquals(false,test7_output); //no numbers inside list after being clear
	}
	
	@Test
	public void testIsEmpty() {
		IntegerSet list1 = new IntegerSet();
		boolean test1_output = list1.isEmpty();
		assertEquals(true,test1_output); //new list should be empty because nothing has been added to it
		
		list1.add(5);
		boolean test2_output = list1.isEmpty();
		assertEquals(false,test2_output); //is no longer empty after number being added to it
		
		list1.clear();
		boolean test3_output = list1.isEmpty();
		assertEquals(true,test3_output); //should be empty after list is clear
	}
	
	@Test
	public void testToString() {
		IntegerSet list1 = new IntegerSet();
		String test1_output = list1.toString();
		assertEquals("[]",test1_output); //new list should be empty or []
		
		list1.add(3);
		list1.add(2);
		list1.add(4);
		String test2_output = list1.toString();
		assertEquals("[3, 2, 4]",test2_output); //numbers inside list after being added
		
		list1.add(3);
		String test3_output = list1.toString();
		assertEquals("[3, 2, 4]",test3_output); //dupes are not added to the list. list remains the same
		
		list1.clear();
		String test4_output = list1.toString();
		assertEquals("[]",test4_output); //cleared list should be empty or []
		
	}
	
	@Test (expected = IntegerSetException.class)
	public void testLargestException() throws IntegerSetException {
		IntegerSet list1 = new IntegerSet();
		int test1_output = list1.largest(); //since list is empty it throws IntegerSet Exception
	}
	
	@Test
	public void testLargest() throws IntegerSetException {
		IntegerSet list1 = new IntegerSet();
		list1.add(20);
		list1.add(5);
		list1.add(33);
		int test1_output = list1.largest();
		assertEquals(33,test1_output); //largest number inside list is 33
		
		list1.add(100);
		int test2_output = list1.largest();
		assertEquals(100,test2_output); //new largest number inside list is 100
		
		list1.clear();
		list1.add(5);
		int test3_output = list1.largest();
		assertEquals(5,test3_output); //list with only one number inside should return that number
	}
	
	@Test (expected = IntegerSetException.class)
	public void testSmallestException() throws IntegerSetException {
		IntegerSet list1 = new IntegerSet();
		int test1_output = list1.smallest(); //since list is empty it throws IntegerSet Exception
	}
	
	@Test
	public void testSmallest() throws IntegerSetException {
		IntegerSet list1 = new IntegerSet();
		list1.add(20);
		list1.add(5);
		list1.add(33);
		int test1_output = list1.smallest();
		assertEquals(5,test1_output); //smallest number inside list is 5
		
		list1.add(1);
		int test2_output = list1.smallest();
		assertEquals(1,test2_output); //new largest number inside list is 1
		
		list1.clear();
		list1.add(5);
		int test3_output = list1.smallest();
		assertEquals(5,test3_output); //list with only one number inside should return that number
	}
	
	@Test (expected = IntegerSetException.class)
	public void testRemoveException() throws IntegerSetException {
		IntegerSet list1 = new IntegerSet();
		list1.remove(3); //since list is empty it throws IntegerSet Exception
	}
	
	@Test
	public void testRemove() throws IntegerSetException {
		IntegerSet list1 = new IntegerSet();
		list1.add(20);
		list1.add(5);
		list1.add(33);
		list1.remove(33);
		String test1_output = list1.toString();
		assertEquals("[20, 5]",test1_output); //list with 33 removed
		
		list1.remove(20);
		String test2_output = list1.toString();
		assertEquals("[5]",test2_output); //list with 33 and 20 removed
		
		list1.remove(5);
		String test3_output = list1.toString();
		assertEquals("[]",test3_output); //list empty after removing all numbers
	}
	
	@Test
	public void testUnion() {
		IntegerSet list1 = new IntegerSet();
		list1.add(20);
		list1.add(5);
		list1.add(33);
		
		IntegerSet list2 = new IntegerSet();
		list2.add(2);
		list2.add(5);
		list2.add(33);
		list1.union(list2);
		
		IntegerSet output1 = new IntegerSet(); //avoid order of list creating output list and comparing
		output1.add(20);
		output1.add(2);
		output1.add(33);
		output1.add(5);
		
		boolean equal_output1 = output1.equals(list1);
		
		assertEquals(true, equal_output1); //only add numbers that aren't in first list
		
		IntegerSet list3 = new IntegerSet();
		list3.add(20);
		list3.add(5);
		list3.add(33);
		list3.add(2);
		list1.union(list3);
		
		boolean equal_output2 = output1.equals(list1);
		
		assertEquals(true,equal_output2); //list remains the same because no new numbers		
	}
	
	@Test
	public void testIntersect() {
		IntegerSet list1 = new IntegerSet();
		list1.add(20);
		list1.add(5);
		list1.add(33);
		
		IntegerSet list2 = new IntegerSet();
		list2.add(5);
		list2.add(33);
		
		list1.intersect(list2);
		IntegerSet output1 = new IntegerSet();
		output1.add(33);
		output1.add(5);
		
		boolean equal_output1 = output1.equals(list1);
		assertEquals(true, equal_output1); //list 1 becomes 5 and 33
		
		IntegerSet list3 = new IntegerSet();
		list3.add(5);
		
		list1.intersect(list3);
		IntegerSet output2 = new IntegerSet();
		output2.add(5);
		
		boolean equal_output2 = output2.equals(list1);
		assertEquals(true, equal_output2); //5 is intersect between list 3 and list 1
		
	}
	
	@Test
	public void testDiff() {
		IntegerSet list1 = new IntegerSet();
		list1.add(20);
		list1.add(5);
		list1.add(33);
		
		IntegerSet list2 = new IntegerSet();
		list2.add(5);
		list2.add(33);
		
		list1.diff(list2);
		IntegerSet output1 = new IntegerSet();
		output1.add(20);
		
		boolean equal_output1 = output1.equals(list1);
		assertEquals(true, equal_output1); //list 1 becomes 20
		
		IntegerSet list3 = new IntegerSet();
		list3.add(20);
		
		list1.diff(list3);
		IntegerSet output2 = new IntegerSet();
		
		boolean equal_output2 = output2.equals(list1);
		assertEquals(true, equal_output2); //list1 becomes empty because list 1 and 3 difference is empty
	}
	
	
}
