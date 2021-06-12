package com.zero;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
	static boolean areAnagrams(String first, String second) {
	    first = first.toLowerCase();
	    second = second.toLowerCase();
	    List<Character> list = new ArrayList();
	    List<Character> list2 = new ArrayList();
	    for(char c : first.toCharArray()) {
	        list.add(c);
	    }
	    for(char c : second.toCharArray()) {
	        list2.add(c);
	    }
	    
	    for (int i = 0; i < list.size(); i++) {
			if(!list2.isEmpty()){
				if(list2.contains(list.get(i)) ){
					list2.remove(list.get(i));
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
	    if(list2.isEmpty()){
	    	return true;
	    }
	    return false;
	}
	public static void main(String[] args) {
		System.out.println(areAnagrams("ISLdT", "List"));
	}
}
