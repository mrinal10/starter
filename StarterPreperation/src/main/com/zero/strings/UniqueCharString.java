package com.zero.strings;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class UniqueCharString {
	static String uniqueCharString(String s) {
		String ans = "";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}else{
				map.put(s.charAt(i), 1);
			}
		}
		for(Entry<Character, Integer> entry:map.entrySet()){
			if(entry.getValue() == 1){
				ans = ans+entry.getKey();
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(uniqueCharString("abrakadabra"));
	}

}
