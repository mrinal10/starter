package com.practice.dp;

public class KnapSack01_DP {
	static int val[] = new int[] { 60, 100, 120 };
	static int wt[] = new int[] { 10, 20, 30 };

	public static void main(String args[]) {
		int W = 60;
		System.out.println(knapSack(W, val.length, val, wt));
	}
	
	private static int knapSack(int maxWeight, 
			int numberOfElements, int[] prices, int[] weights) {
		int[][] arr = new int[numberOfElements+1][maxWeight+1];

		for (int i = 0; i <= numberOfElements; i++) {
			for (int j = 0; j <= maxWeight; j++) {
				if (i==0 || j==0) {
					arr[i][j] = 0;
				}else if(weights[i-1] <= j) {
					arr[i][j] = Math.max(prices[i-1]+arr[i-1][j-weights[i-1]], arr[i-1][j]);
				}else {
					arr[i][j] = arr[i-1][j];
				}
			}
		}
//		for (int i = 0; i <= numberOfElements; i++) {
//			for (int j = 0; j <= maxWeight; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		return arr[numberOfElements][maxWeight];
	}
}
