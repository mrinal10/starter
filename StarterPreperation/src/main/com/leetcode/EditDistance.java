package com.leetcode;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			String s = "ros";// sc.next();
			String t = "horse";// sc.next();
			System.out.println(minDistance(s, t));
			System.out.println("timeout");
		}
		sc.close();
	}

	static int[][] dp;
	static String wrd1;
	static String wrd2;

	public static int minDistance(String word1, String word2) {
		dp = new int[word1.length() + 1][word2.length() + 1];
		wrd1 = word1;
		wrd2 = word2;
		return minDistanceUtil(word1.length(), word2.length());
	}

	public static int minDistanceUtil(int len1, int len2) {
		System.out.println(len1 + " ::: " + len2);
		if (dp[len1][len2] != 0) {
			return dp[len1][len2];
		}
		if (len1 == 0) {
			dp[len1][len2] = len2;
			return len2;
		}
		if (len2 == 0) {
			dp[len1][len2] = len1;
			return len1;
		}
		if (wrd1.charAt(len1 - 1) == wrd2.charAt(len2 - 1)) {
			minDistanceUtil(len1 - 1, len2 - 1);
			return dp[len1 - 1][len2 - 1];
		}
		return dp[len1][len2] = 1 + Math.min(Math.min(minDistanceUtil(len1 - 1, len2), minDistanceUtil(len1, len2 - 1)),
				minDistanceUtil(len1 - 1, len2 - 1));
	}
}
