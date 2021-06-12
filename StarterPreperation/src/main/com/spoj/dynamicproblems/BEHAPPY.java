package com.spoj.dynamicproblems;

import java.util.Arrays;
import java.util.Scanner;

public class BEHAPPY {
	static int numberOfGf;
	static int[] minArr;
	static int[] maxArr;
	static int[][] dp;
	static int giftsToDistributed(int index, int giftsLeft){
		if(giftsLeft==0 && index>=numberOfGf){
			return 1;
		}
		if(giftsLeft<0 || index>=numberOfGf){
			return 0;
		}
		
		if(dp[index][giftsLeft]>=0){
			return dp[index][giftsLeft];
		}
		
		int possibilities = 0;
		for (int i = minArr[index]; i <= maxArr[index]; i++) {
			possibilities += giftsToDistributed(index+1, giftsLeft-i);
		}
		dp[index][giftsLeft] = possibilities;
		return possibilities;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		numberOfGf = sc.nextInt();
		dp = new int[105][105];
		int numberOfGifts = sc.nextInt();
		minArr = new int[numberOfGf];
		maxArr = new int[numberOfGf];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < numberOfGf; i++) {
			minArr[i] = sc.nextInt();
			maxArr[i] = sc.nextInt();
		}
		System.out.println(giftsToDistributed(0, numberOfGifts));
		sc.close();
	}
}
