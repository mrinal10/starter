package com.zero.strings;

import java.util.HashMap;

public class HasEqualHalves {

	static boolean hasEqualHalves(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length() / 2; i++) {
			if (map.containsKey(s.charAt(i))) {
				int cnt = map.get(s.charAt(i));
				cnt++;
				map.put(s.charAt(i), cnt);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		int startingIndx = s.length()/2;
		if((s.length() & 1) == 1){
			startingIndx = (s.length()+1)/2;
		}
		for (int i = startingIndx; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				int cnt = map.get(s.charAt(i));
				cnt--;
				if (cnt == 0) {
					map.remove(s.charAt(i));
				} else {
					map.put(s.charAt(i), cnt);
				}
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		if(map.isEmpty()){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(hasEqualHalves("madam"));
	}

}
