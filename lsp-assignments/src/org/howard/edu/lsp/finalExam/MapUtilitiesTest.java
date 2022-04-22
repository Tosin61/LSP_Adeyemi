package org.howard.edu.lsp.finalExam;

import static org.junit.Assert.*;
import java.util.HashMap;

import org.junit.Test;

public class MapUtilitiesTest {
	MapUtilities test = new MapUtilities();
	@Test
	public void empty() throws NullMapException { //Returns 0 if either map is empty or both
		HashMap<String, String> mapa = new HashMap<String,String>();
		HashMap<String, String> mapb = new HashMap<String,String>();
		int test1_output = test.commonKeyValuePairs(mapa, mapb);
		assertEquals(test1_output,0);
		
		mapb.put("Tom", "Jerry");
		int test2_output = test.commonKeyValuePairs(mapa, mapb);
		assertEquals(test2_output,0);
		
		mapb.clear();
		mapa.put("Jerry", "Tom");
		int test3_output = test.commonKeyValuePairs(mapa, mapb);
		assertEquals(test3_output,0);
	}
	
	
	@Test (expected = NullMapException.class) 
	public void nullTest() throws NullMapException{ //Returns error if one hashmap is null
		HashMap<String, String>mapa = null;
		HashMap<String, String> mapb = new HashMap<String,String>();	
		int test1_output = test.commonKeyValuePairs(mapa, mapb);
	}
	
	@Test (expected = NullMapException.class)
	public void nullTest2() throws NullMapException{ //Returns error if both are null
		HashMap<String, String>mapa = null;
		HashMap<String, String> mapb = null;	
		int test2_output = test.commonKeyValuePairs(mapa, mapb);
	}
	
	@Test
	public void tests() throws NullMapException { //Returns 0 if either map is empty or both
		HashMap<String, String> mapa = new HashMap<String,String>();
		HashMap<String, String> mapb = new HashMap<String,String>();
		mapa.put("Nacho", "Lebra");
		int test1_output = test.commonKeyValuePairs(mapa, mapb);
		assertEquals(test1_output,0);
		
		mapb.put("Tom", "Jerry");
		mapa.put("Tom", "Jerry");
		int test2_output = test.commonKeyValuePairs(mapa, mapb);
		assertEquals(test2_output,1);
		
		mapb.clear();
		int test3_output = test.commonKeyValuePairs(mapa, mapb);
		assertEquals(test3_output,0);
		
		mapa.clear();
		mapa.put("Alice", "Healthy");
		mapa.put("Mary", "Ecastic");
		mapa.put("Bob", "Happy");
		mapa.put("Chuck", "Fine");
		mapa.put("Felix", "Sick");
		
		mapb.put("Mary", "Ecastic");
		mapb.put("Felix", "Healthy");
		mapb.put("Ricardo", "Superb");
		mapb.put("Tam", "Fine");
		mapb.put("Bob", "Happy");
		int test4_output = test.commonKeyValuePairs(mapa, mapb);
		assertEquals(test4_output,2);
		mapa.put("Superb", "Ricardo");
		mapb.put("Last", "Test");
		int test5_output = test.commonKeyValuePairs(mapa, mapb);
		assertEquals(test5_output,2);
	}
	
}
