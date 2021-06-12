package com.spoj.dynamicproblems;

public class TWENDS {
	static int val[];
	static int dp[][];
	static int n, ans = 0;

	int tends_dp(int start, int end) {
		if (start > end)
			return 0;
		if (dp[start][end] != -1)
			return dp[start][end];
		else {
			/*
			 * Here we take care of the turns of player two, by ignoring the
			 * larger element of the two ends
			 */
			return dp[start][end] = Math.max(
					val[start + 1] >= val[end] ? tends_dp(start + 2, end) + val[start]
							: tends_dp(start + 1, end - 1) + val[start],
					val[start] >= val[end - 1] ? tends_dp(start + 1, end - 1) + val[end]
							: tends_dp(start, end - 2) + val[end]);
		}
	}

	public static void main(String[] args) {
		val = new int[1000];
		dp = new int[1000][1000];
	}
}
