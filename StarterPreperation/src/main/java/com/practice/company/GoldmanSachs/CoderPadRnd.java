package com.practice.company.GoldmanSachs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * 
 * Given a dictionary of the words(strings) which contains different words & you are given an input string 
 * e.g. “abd”. You need to find the largest word available in the supplied dictionary which can be made using 
 * the letters of input string. The returned word can contain only the same no of occurrences of the letters as 
 * given in the input string i.e. if a letter is given once then in the output it should be existed only once. Examples:
 * 
 * test case 1) Dictionary {“to”, “banana”, “toe”, “dogs”, “ababcd”, “elephant”} and input string is “eot”. Output should be “toe”
 *
 * test case 2) Dictionary is same as specified in example a but the input string is “ogtdes” and the output is “dogs” and “toes”
 * 
 * */

public class CoderPadRnd {
	public static void main(String[] args) {
		String[] dictionary = {"to", "banana", "toes", "dogs", "ababcd", "elephant"};
		String string = "ogtdes";//"eot"; 
		int maxLen = 0;
		Set<String> setOfString = new HashSet<String>();
		
		Map<Character, Integer> mapp = getMap(string);
		for(int i=0; i<dictionary.length; i++) {
			Map<Character, Integer> map = getMap(dictionary[i]);
			if(isMatch(map, mapp)) {
				if(maxLen<dictionary[i].length()) {
					maxLen = dictionary[i].length();
				}
				setOfString.add(dictionary[i]);
			}
		}
		
		for(String s : setOfString) {
			if(s.length() == maxLen) {
				System.out.println(s);
			}
		}
	}
	
	private static boolean isMatch(Map<Character, Integer> actualMap,
							Map<Character, Integer> refMap) {
		for(Entry<Character, Integer> entry:actualMap.entrySet()) {
			char c = entry.getKey();
			int v = entry.getValue();
			
			if(!refMap.containsKey(c) || refMap.get(c)!=v) {
				return false;
			}
		}
		return true;
	}
	
	private static Map<Character, Integer> getMap(String string) {
		Map<Character, Integer> dictionaryMap = new HashMap<>();
		for(int i=0; i<string.length(); i++) {
			char c = string.charAt(i);
			int t = 0;
			if(dictionaryMap.containsKey(c)) {
				t = dictionaryMap.get(c);
			}
			
			t += 1;
			dictionaryMap.put(c, t);
		}
		return dictionaryMap;
	}
}
