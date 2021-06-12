package com.hackerearth.practice;

import java.util.*;

public class BobAnIdiot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = sc.next().charAt(0);
			char v = sc.next().charAt(0);
			
			if (map.containsKey(c)) {
				
			}
			map.put(c, v);
			map.put(v, c);
		}
		
		String s = sc.next();
		char[] cArr = s.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			char cur = cArr[i];
			if (map.containsKey(cur)) {
				System.out.print(map.get(cur));
			}else
				System.out.print(cur);
		}
		sc.close();
	}

}
