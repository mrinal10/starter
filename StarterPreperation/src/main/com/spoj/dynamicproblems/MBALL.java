package com.spoj.dynamicproblems;

import java.util.Scanner;

class MBALL {
	static int ar[] = {2,3,6,7,8};
	static int[] dp;
	private static int getPossibleScore(int n){
		if(n<0){
			return Integer.MIN_VALUE;
		}
		if(n==0){
			return 1;
		}
		if(dp[n]!=0){
			return dp[n];
		}
		int count =0;
		for (int i = 0; i < ar.length; i++) {
			int temp = getPossibleScore(n-ar[i]);
			if(temp>0){
				count++;
			}
		}
		dp[n] = count;
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-->0) {
			int n = sc.nextInt();
			dp = new int[n];
			System.out.println(getPossibleScore(n));
		}
		sc.close();
	}

}
