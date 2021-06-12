package com.hackerearth.hourstorm;

import java.util.Scanner;

public class RotateXor {
	
	private static String rotate(int n, String s) {
		StringBuilder sB = new StringBuilder(s.substring(n, s.length()));
		for (int i = 0; i < n; i++) {
			sB.append(s.charAt(i));
		}
		return sB.toString();
	}
	
	public static void main(String[] args) {
		int B, N, Q;
		Scanner sc = new Scanner(System.in);
		B = sc.nextInt();
		N = sc.nextInt();
		Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			String s = sc.next();
			int n = sc.nextInt();
		}
		sc.close();
	}
}
