package com.practice.dp;

public class PrintingLCS {
	private static void getLCS(String str, String matcher) {
		int lenS = str.length();
		int lenMatcher = matcher.length();

		int[][] ar = new int[lenS + 1][lenMatcher + 1];
		for (int i = 0; i < lenS + 1; i++) {
			for (int j = 0; j < lenMatcher + 1; j++) {
				if (i == 0 || j == 0) {
					ar[i][j] = 0;
				} else if (str.charAt(i - 1) == matcher.charAt(j - 1)) {
					ar[i][j] = 1 + ar[i - 1][j - 1];
				} else {
					ar[i][j] = Math.max(ar[i - 1][j], ar[i][j - 1]);
				}
			}
		}
		int temp = ar[lenS][lenMatcher];
		int index = temp;
		char[] c = new char[temp];
		int i = lenS, j = lenMatcher;
		while (i > 0 && j > 0) {
			if (str.charAt(i - 1) == matcher.charAt(j - 1)) {
				c[temp - 1] = str.charAt(i - 1);
				i--;
				j--;
				index--;
			}
			else if (ar[i - 1][j] > ar[i][j - 1])
				i--;
			else
				j--;
		}
		for (int j2 = 0; j2 < c.length; j2++) {
			System.out.println(c[i]);
		}
	}

	public static void main(String[] args) {
		String X = "AGGiTAB";
		String Y = "GXiTXAYB";
		getLCS(X, Y);
	}
}
