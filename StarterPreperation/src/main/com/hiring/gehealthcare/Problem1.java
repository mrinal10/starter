package com.hiring.gehealthcare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Problem1 {
	private static Map<Character, List<Integer>> cMap;
	static String s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-->0) {
			s = sc.next();
			cMap = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				List<Integer> list = new ArrayList<>();
				if (cMap.containsKey(c)) {
					list = cMap.get(c);
				}
				list.add(i);
				cMap.put(c, list);
			}
			
			for (int i = 1; i < s.length(); i++) {
				if (isPalinDromePossible(0, i) && isPalinDromePossible(i+1, s.length()-1)) {
					System.out.println("Yes");
					return;
				}
			}
			System.out.println("No");
		}
		sc.close();
	}
	
	
	public static boolean isPalinDromePossible(int sIndx, int eIndx) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = sIndx; i <= eIndx; i++) {
			char c = s.charAt(i);
			int freq = 0;
			if (map.containsKey(c)) {
				freq = map.get(c);
			}
			freq++;
			map.put(c, freq);
		}
		boolean isOddFound = false;
		for(Entry<Character, Integer> entry : map.entrySet()){
			int value = entry.getValue();
			if ((value&1)!=0) {
				if (isOddFound) 
					return false;
				else
					isOddFound = true;
			}
		}
		return true;
	}
}
