package org.howard.edu.lsp.finalExam;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class MapUtilities {
    public static int commonKeyValuePairs(
        HashMap<String, String> map1,
        HashMap<String, String> map2)throws NullMapException {
    	if(map1 == null || map2 == null) {
    		throw new NullMapException("One or both maps are null!");
    	}
    	if(map1.isEmpty()|| map2.isEmpty()) {
    		return 0;
    	}
    	int count = 0;
    	for (Map.Entry<String, String> set: map1.entrySet()) {
    		if (map2.containsKey(set.getKey())) {
    			if(map2.get(set.getKey()) == set.getValue()) {
    				count = count +1;
    			}
    		}
    	}
    	return count;
    }
    
 
}
