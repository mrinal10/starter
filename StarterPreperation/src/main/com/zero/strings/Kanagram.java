package com.zero.strings;

import java.util.HashMap;
import java.util.Map;

public class Kanagram {

	static boolean areKAnagrams(String first, String second, int k) {
		Map<Character, Integer>  map1 = new HashMap<>();
		for (int i = 0; i < first.length(); i++) {
			if(map1.containsKey(first.charAt(i))){
				int cnt = map1.get(first.charAt(i));
				cnt++;
				map1.put(first.charAt(i), cnt);
			}else{
				map1.put(first.charAt(i), 1);
			}
		}
		int count = 0;
		for (int i = 0; i < second.length(); i++) {
			if(map1.containsKey(second.charAt(i))){
				if(map1.get(second.charAt(i)) == 0){
					count++;
				}else{
				int cnt = map1.get(second.charAt(i));
				cnt--;
				map1.put(second.charAt(i), cnt);
			}
			}else{
				count++;
			}
		}
		
		if(count<=k)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		String s2 = "SOLVE";
		String s1 = "LEARN";
		System.out.println(areKAnagrams(s1,s2,2));
	}

}
