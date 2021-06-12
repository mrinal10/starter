package com.zero;

import java.util.HashSet;
import java.util.Set;

public class repetativeChar {

	public static void main(String[] args) {
		String s = "abcdea";
		System.out.println(isRepeated(s));

	}
	
	private static boolean isRepeated(String string){
		boolean flag = false;
		char[] ar = string.toCharArray();
		Set<Character> set= new HashSet<>();
		for (int i = 0; i < ar.length; i++) {
			char c = ar[i];
			if (!set.contains(c)) {
				set.add(c);
			}else{
				return true;
			}
		}
		return flag;
	}

}
