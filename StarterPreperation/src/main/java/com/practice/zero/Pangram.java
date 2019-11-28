package com.practice.zero;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pangram {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int testCases = sc.nextInt();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		while(testCases-->0) {
			for(int i=0; i<26; i++) {
				int n = sc.nextInt();
				char c = (char) (97+i);
				map.put(c,n);
			}
			
			String s = sc.next();
			for(int i=0; i<s.length(); i++) {
				if(map.containsKey(s.charAt(i))) {
					map.remove(s.charAt(i));
				}
			}
			
			int sum = 0;
			for(Character c : map.keySet()) {
				sum += map.get(c);
			}
			System.out.println(sum);
			map.clear();
		}
		
	}
}