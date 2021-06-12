package com.spoj.dynamicproblems;

import java.util.Arrays;
import java.util.Scanner;

public class FARIDA {
	static int[] goldOfMonsters;
	static int numberOfMonsters;
	static int[] dp;
	
	private static int maxCoins(int index){
		if(index>=numberOfMonsters){
			return 0;
		}
		if(dp[index]>=0){
			return dp[index];
		}
		int retVal = 0;
		retVal = Math.max(retVal, goldOfMonsters[index]+maxCoins(index+2));
		retVal = Math.max(retVal, maxCoins(index+1));
		dp[index] = retVal;
		return retVal;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		dp = new int[1005];
		goldOfMonsters = new int[1005];
		int cnt = 1;
		while ( t-->0) {
			numberOfMonsters = sc.nextInt();
			Arrays.fill(dp, 0, numberOfMonsters, -1);
			for (int i = 0; i < numberOfMonsters; i++) {
				goldOfMonsters[i] = sc.nextInt();
			}
			System.out.println("Case "+cnt+": "+maxCoins(0));
			cnt++;
		}
		sc.close();
	}

}
