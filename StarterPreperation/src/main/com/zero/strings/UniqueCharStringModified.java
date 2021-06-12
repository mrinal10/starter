package com.zero.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class UniqueCharStringModified {
	static String uniqueCharString(String s) {
		if(s.contains(" ")){
		     s=s.replace(" ", "");
		   }
		String ans = "";
		HashMap<Character, Integer> map = new HashMap<>();
		char[] arr = new char[s.length()];
		int[] arrS = new int[s.length()];
		int indx = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==' '){
				continue;
			}
			if (map.containsKey(s.charAt(i))) {
				arrS[map.get(s.charAt(i))]+=1;
			}else{
				map.put(s.charAt(i), indx);
				arr[indx] = s.charAt(i);
				arrS[indx] = 1;
			}
			indx++;
		}
		for(int i=0; i<indx; i++){
			if(arrS[i] == 1){
				ans = ans+arr[i];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(uniqueCharString("abrakadabra"));
	}

}
