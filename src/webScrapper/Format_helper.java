/**
 * 
 * @author Teja
 *
 */
package webScrapper;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Format_helper {
	
	static Map<String, Integer> hashmap = new HashMap<>();
    
	//for printing in colours on console
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RED = "\u001B[31m";

	
	/**
	 * This is a method to add words to the hashmap
	 * @param word
	 */

	public void addWord(String word){	
		String key = word;
		
		if (hashmap.containsKey(key)) {
		    hashmap.put(key, hashmap.get(key)+1);
		} else { 
		    hashmap.put(key,1);
		}	
	}
	
	

	
	/**
	 * This is a method to sort map in descending order based on values
	 * @param map
	 * @return entrylist
	 */
	
	private static List<Entry<String, Integer>> sort(Map<String,Integer> map) { 
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
        List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(entrySet);
        Collections.sort( entryList, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> temp1, Map.Entry<String, Integer> temp2 )
            {
                return (temp2.getValue()).compareTo( temp1.getValue() );
            }
        } );
        
 
		return entryList;

	  }

	
	
	/**
	 * This is a method to get list of top common topics 
	 * @param x - no:of Topics in the list
	 * @return list of topics
	 */
	
	public static List<String> getTopics(int x){
		
		List<Entry<String, Integer>> entryList = sort(hashmap);
		List<String> list = new ArrayList<>();
		int temp=0;
		
	       for(Map.Entry<String, Integer> entry:entryList){
	    	   
	    	   //remove single digit strings since they don't have much significance 
	    	   if(entry.getKey().length()!=1) {
	    	    	temp++;
	            System.out.println(entry.getKey()+"-"+entry.getValue());
	            //System.out.print(ANSI_RED + entry.getKey()+"("+ANSI_YELLOW+entry.getValue() +")"+ ANSI_RESET+"; ");

	            list.add(entry.getKey());
	    	    }	    	    
		    	
	    	   if(temp>x-1) {break;} //return once required no:of topics are extracted
	       
	       }	
	       		System.out.println();
				return list;
				
	}
	

}