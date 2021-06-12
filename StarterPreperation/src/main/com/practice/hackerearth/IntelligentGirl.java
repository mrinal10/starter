package com.practice.hackerearth;

import java.util.HashMap;
import java.util.Scanner;

public class IntelligentGirl {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 1; i <= s.length(); i++) {
			int indx = Integer.parseInt(String.valueOf(s.charAt(i-1)));
			int cnt = 0;
			if (map.get(indx)==null) {
				cnt = 0;
				for (int j = i; j <= s.length(); j++) {
					int indxValu = Integer.parseInt(String.valueOf(s.charAt(j)));
					if (indxValu%2==0) {
						cnt++;
					}
				}
				map.put(indx, cnt);
			}else{
				cnt = map.get(indx);
			}
			System.out.println(cnt);
		}
		sc.close();
	}

}
