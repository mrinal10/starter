package com.problems.dp;

public class EditDistance {
	private int editDistanceDP(String a, String b) {
		int m = a.length();
		int n = b.length();
		if (m == 0) {
			return n;
		}
		if (n == 0)
			return m;

		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < n; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i < m; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
				}
			}
		}
		return dp[m][n];		
	}

	public static void main(String[] args) {
		String s1 = "horizon";
		String s2 = "horizontal";
		EditDistance ed = new EditDistance();
		System.out.println("Minimum Edit Distance -(DP): " + ed.editDistanceDP(s1, s2));
	}
}
