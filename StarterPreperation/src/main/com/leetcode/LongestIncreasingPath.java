package com.leetcode;

public class LongestIncreasingPath {

	public static void main(String[] args) {
		int[][] nums = {{9,9,4},{6,6,8},{2,1,1}};
		System.out.println(longestIncreasingPath(nums));
	}

	static int[][] dp;
	static int[][] mtrx;
	public static int longestIncreasingPath(int[][] matrix) {
		if(matrix.length==0){
            return 0;
        }
		mtrx = matrix;
		int maxV = Integer.MIN_VALUE;
		dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int value = longestIncreasingPathUtil(i,j,Integer.MIN_VALUE);
				if (maxV<value) {
					maxV = value;
				}
			}
		}
		return maxV;
	}
	
	public static int longestIncreasingPathUtil(int rw, int clmn, int lastValue) {
		if (rw>=mtrx.length || rw<0) {
			return 0;
		}
		if (clmn>=mtrx[0].length || clmn<0) {
			return 0;
		}
		
		
		if (lastValue<mtrx[rw][clmn]) {
			if (dp[rw][clmn]!=0) {
				return dp[rw][clmn];
			}
			return dp[rw][clmn] = 1+Math.max(Math.max(longestIncreasingPathUtil(rw+1, clmn, mtrx[rw][clmn]), longestIncreasingPathUtil(rw, clmn+1, mtrx[rw][clmn])),
			Math.max(longestIncreasingPathUtil(rw-1, clmn, mtrx[rw][clmn]), longestIncreasingPathUtil(rw, clmn-1, mtrx[rw][clmn])));
		}
		return 0;
	}

}
