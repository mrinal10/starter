package com.zero.exam;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		String z = "ZERO";
		int cnt = 0;
		int l = s.length()/4;
		for (int i = 0; i < l; i++) {
			int startIndx = (i*4);
			String ss = s.substring(startIndx, startIndx+4);
			if (!ss.equals(z)) {
				for (int j = 0; j < 4; j++) {
					if (ss.charAt(j)!=z.charAt(j)) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
