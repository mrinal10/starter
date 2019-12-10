package com.practice.dp;

public class LCS_DP {
	private static int getLCS(String str, String matcher) {
		int lenS = str.length();
		int lenMatcher = matcher.length();

		int[][] ar = new int[lenS + 1][lenMatcher + 1];
		for (int i = 0; i < lenS + 1; i++) {
			for (int j = 0; j < lenMatcher + 1; j++) {
				if (i == 0 || j == 0) {
					ar[i][j] = 0;
				} else if (str.charAt(i-1) == matcher.charAt(j-1)) {
					ar[i][j] = 1 + ar[i - 1][j - 1];
				} else {
					ar[i][j] = Math.max(ar[i - 1][j], ar[i][j - 1]);
				}
			}
		}
		return ar[lenS][lenMatcher];
	}

	public static void main(String[] args) {
		String X = "AGGiTAB";
		String Y = "GXiTXAYB";
		System.out.println(getLCS(X, Y));
	}
}
