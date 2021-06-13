package com.problems.dp;

public class LCS {
	
	private static int LCSubStr(char[] a, char[] b, int m, int n) {
		int[][] dp = new int[m+1][n+1];
		
		for(int i=1; i<=a.length; i++) {
			for(int j=1; j<=b.length; j++) {
				if(a[i-1] == b[j-1]) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = 0;
				}
			}
		}
		
		int res = 0;
		
		for(int i=0; i<=a.length; i++) {
			for(int j=0; j<=b.length; j++) {
				if(res<dp[i][j]) {
					res = dp[i][j];
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String X = "OldSite:GeeksforGeeks.org";
		String Y = "NewSite:GeeksQuiz.com";

		int m = X.length();
		int n = Y.length();

		System.out.println(LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
	}
}
