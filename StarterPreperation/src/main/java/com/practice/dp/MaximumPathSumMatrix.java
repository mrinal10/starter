package com.practice.dp;

public class MaximumPathSumMatrix {

	public static void main(String[] args) {

	}

	private static int getMaxPathValue(int[][] matrix, int dimension) {
		int[][] dp = new int[dimension][dimension];
		int maxValue = 0;
		for (int j = 0; j < dimension; j++) {
			dp[dimension - 1][j] = matrix[dimension - 1][j];
		}

		for (int i = dimension - 2; i >= 0; i--) {
			for (int j = 0; j < dimension; j++) {
				int max = Integer.MIN_VALUE;

				if (((j - 1) >= 0) && (max < dp[i + 1][j - 1])) {
					max = dp[i + 1][j - 1];
				}
				if (((j - 1) >= 0) && (max < dp[i + 1][j])) {
					max = dp[i + 1][j];
				}
				if (((j + 1) < dimension) && (max < dp[i + 1][j + 1])) {
					max = dp[i + 1][j + 1];
				}

				dp[i][j] = max + matrix[i][j];
			}
		}
		
		for (int j = 0; j < dimension; j++) {
	        if (maxValue < dp[0][j]) {
	            maxValue = dp[0][j]; 
	        }
		}
		return maxValue;
	}
}
