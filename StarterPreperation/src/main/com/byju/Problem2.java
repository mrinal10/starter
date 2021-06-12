package com.byju;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-->0) {
			int len = sc.nextInt();
			
			String s = sc.next();
			char[] ch1 = new char[len];
			ch1 = s.toCharArray();
			
			String s1 = sc.next();
			char[] ch2 = new char[len];
			ch2 = s1.toCharArray();
			
			System.out.println(getCount(ch1, ch2));
		}
		sc.close();
	}
	
	private static int getCount(char[] ch1, char[] ch2) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<ch1.length; i++) {
			int v = 0;
			if (map.containsKey(ch1[i])) {
				v = map.get(ch1[i]);
			}
			v = v+1;
			map.put(ch1[i], v);
		}
		int cnt =  0;
		for(int i=0; i<ch2.length; i++) {
			int v = 0;
			if (map.containsKey(ch2[i])) {
				v = map.get(ch2[i]);
				if(v>0) {
					cnt++;
					v--;
				}
			}
			map.put(ch2[i], v);
		}
		return cnt;
	}
}
