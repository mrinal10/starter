package com.hackerearth.practice;

import java.util.*;

public class Test {

	String shortestSubstring(String A, String B) {
		// Your Logic Here
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int min = a.length - 1;
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (b[j] == a[i]) {
					if (i < min)
						min = i;
					if (i > max)
						max = i;
				}
			}
		}
		int len1 = max - min + 1;
		char[] c = new char[len1];
		for (int i = 0; i < len1; i++) {
			c[i] = A.charAt(i + min);
		}
		return new String(c);
	}

	static Scanner sc;

	public static void main(String[] args) {

		Test bz = new Test();
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		String A, B;
		while (t-- != 0) {
			// TODO: Read Strings A and B
			A = sc.nextLine();
			B = sc.nextLine();
			String ans = bz.shortestSubstring(A, B);
			System.out.println(ans);
		}
	}
}