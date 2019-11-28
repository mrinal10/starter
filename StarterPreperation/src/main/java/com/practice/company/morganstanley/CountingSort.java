package com.practice.company.morganstanley;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountingSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			Map<Character, Integer> map = new TreeMap<Character, Integer>();
			for(int i=0; i<n; i++) {
				char c = s.charAt(i);
				
				int freq = 0;
				if(map.containsKey(c)) {
					freq += map.get(c);
				}
				freq++;
				map.put(c, freq);
			}
			s = "";
			for(Map.Entry<Character, Integer> entry : map.entrySet()) {
				int cnt = entry.getValue();
				char cc = entry.getKey();
				for(int k =0; k<cnt; k++) {
					s = s+ cc;
				}
				
				
			}
		}
		sc.close();
	}
}
