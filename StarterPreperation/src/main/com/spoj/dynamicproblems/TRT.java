package com.spoj.dynamicproblems;

import java.util.Scanner;

public class TRT {
	static int noOfTreats;
	static int[] treatsValues;
	static int[][] dp;
	static int findMaxValue(int startIndx, int endIndx) {
		if (startIndx > endIndx) {
			return 0;
		}
		if(dp[startIndx][endIndx] != 0){
			return dp[startIndx][endIndx];
		}
		int retValue = 0;
		int age = noOfTreats-(endIndx-startIndx);
		retValue = (treatsValues[startIndx] * age) + findMaxValue(startIndx + 1, endIndx);
		retValue = Math.max(retValue, (treatsValues[endIndx] * age) + findMaxValue(startIndx, endIndx - 1));
		dp[startIndx][endIndx] = retValue;
		return retValue;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		noOfTreats = sc.nextInt();
		dp = new int[noOfTreats][noOfTreats];
		treatsValues = new int[noOfTreats];
		for (int i = 0; i < noOfTreats; i++) {
			treatsValues[i] = sc.nextInt();
		}
		System.out.println(findMaxValue(0, noOfTreats - 1));
		sc.close();
	}

}
