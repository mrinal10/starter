package com.spoj.dynamicproblems;

import java.util.Scanner;

public class BVAAN {
	static String blessing1, blessing2;
	static int[][] dp;

	private static void getLCSLength(int lengtha, int lengthb) {
		for (int i = 0; i <= lengtha; i++) {
			for (int j = 0; j <= lengthb; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (blessing1.charAt(i - 1) == blessing2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
	}

	private static String lcsStringDPWay(int lcsLength) {
		char[] lcs = new char[lcsLength + 1];
		int temp = lcsLength;
		int i = blessing1.length();
		int j = blessing2.length();
		while (i > 0 && j > 0) {
			if (blessing1.charAt(i - 1) == blessing2.charAt(j - 1)) {
				lcs[temp] = blessing1.charAt(i - 1);
				i--;
				j--;
				temp--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		String s = "";
		for (int k = 0; k < lcs.length; k++) {
			s += lcs[k];
		}
		return s;
	}

	private static void printDP() {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int getOptimalValue(int length, int index, String s){
		if (length<=0 || index >= s.length()) {
			return 0;
		}
		return Math.max( ((int)s.charAt(index))+getOptimalValue(length-1, index+1, s), getOptimalValue(length, index+1, s));
	}
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			blessing1 = sc.next();
			blessing2 = sc.next();
			dp = new int[blessing1.length() + 1][blessing2.length() + 1];
			getLCSLength(blessing1.length(), blessing2.length());
			String deducedBlessing = lcsStringDPWay(dp[blessing1.length() - 1][blessing2.length() - 1]);
			int requiredDeducedBlessingLength = sc.nextInt();
			if (deducedBlessing.length() < requiredDeducedBlessingLength) {
				System.out.println(0);
			} else if (deducedBlessing.length() >= requiredDeducedBlessingLength) {
				System.out.println(getOptimalValue(requiredDeducedBlessingLength,0,deducedBlessing));
			}
		}
		sc.close();
	}
}
