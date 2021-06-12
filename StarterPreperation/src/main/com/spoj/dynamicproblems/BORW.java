package com.spoj.dynamicproblems;

import java.util.Scanner;

public class BORW {
	static int[] arr;
	static int[][][] dp;
	private static int getMin(int index, int lastBlackValue, int lastWhiteValue){
		if (index>=arr.length) {
			return 0;
		}		
		if(dp[index][lastBlackValue][lastWhiteValue]!=0){
			return dp[index][lastBlackValue][lastWhiteValue];
		}
		int v=20000;
		if (arr[index]<lastWhiteValue && arr[index]>lastBlackValue) {
			v = Math.min(Math.min(getMin(index+1, lastBlackValue, arr[index]), getMin(index+1, lastBlackValue, lastWhiteValue)+1),
					getMin(index+1, arr[index], lastWhiteValue));
		}else if (arr[index]<lastWhiteValue) {
			v = Math.min(getMin(index+1, lastBlackValue, arr[index]), getMin(index+1, lastBlackValue, lastWhiteValue)+1);
		}else if (arr[index]>lastBlackValue) {
			v = Math.min(getMin(index+1, arr[index], lastWhiteValue), getMin(index+1, lastBlackValue, lastWhiteValue)+1);
		}
		dp[index][lastBlackValue][lastWhiteValue] = v;
		return v;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == -1) {
				break;
			}
			dp = new int[202][202][202];
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(getMin(0, 0, 201));
		}
		sc.close();
	}
}
