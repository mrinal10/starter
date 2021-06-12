package com.spoj.dynamicproblems;

public class TWENDS_simplified {
	static int val[];
	static int dp[][];
	static int n, ans = 0;

	static int tends_dp(int start, int end) {
		if (start > end)
			return 0;
		if (dp[start][end] != -1)
			return dp[start][end];
		else {
			int tempValue = 0;
			int tempValue1 = 0;
			if(val[start + 1] >= val[end]){
				tempValue = tends_dp(start + 2, end) + val[start];
			}else{
				tempValue = tends_dp(start + 1, end - 1) + val[start];
			}
			
			if(val[start] >= val[end - 1]){
				tempValue1 = tends_dp(start + 1, end - 1) + val[end];
			}else{
				tempValue1 = tends_dp(start, end - 2) + val[end];
			}
			dp[start][end] = Math.max(tempValue, tempValue1);
			
			return dp[start][end];
		}
	}

	public static void main(String[] args) {
		val = new int[1000];
		dp = new int[1000][1000];
	    ans=tends_dp(0,n-1);

	}
}
