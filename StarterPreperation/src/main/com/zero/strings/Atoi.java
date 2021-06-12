package com.zero.strings;

import java.util.Scanner;

public class Atoi {

	private static int num(String s) {
		int v = 1;
		int cnt = 0;
		if (s.startsWith("-")) {
			v = -1;
			s = s.substring(1, s.length());
		}
		for (int i = 0; i < s.length(); i++) {
			try {
				cnt = (cnt * 10) + Integer.parseInt(s.substring(i, i + 1));
			} catch (Exception e) {
				return -1;
			}
		}
		return cnt * v;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(num(s));
		sc.close();
	}
}
