package com.geekforgeeks;

import java.util.*;

public class AllSubstringOfString {
	
	private static List<String> allSubstringOfString(String s){
		List<String> allSubStrings = new ArrayList<String>();
		for(int i=0; i<s.length(); i++){
			for (int j = i+1; j <= s.length(); j++) {
				allSubStrings.add(s.substring(i,j));
			}
		}
		return allSubStrings;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-->0){
			String s = sc.next();
			List<String> allStrings = allSubstringOfString(s);
			for (int i = 0; i < allStrings.size(); i++) {
				System.out.println(allStrings.get(i));
			}
		}
		sc.close();
	}
}
