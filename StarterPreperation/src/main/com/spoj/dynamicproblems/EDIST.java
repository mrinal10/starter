package com.spoj.dynamicproblems;

import java.util.Scanner;

class EDIST {
	static String s;
	static String t;
	static int[][] dp;
	
	private static int getResult(int lenS, int lenT){
		if(dp[lenS][lenT]!=0){
			return dp[lenS][lenT];
		}
		if(lenS==0){
			dp[lenS][lenT] = lenT;
			return lenT;
		}
		if(lenT==0){
			dp[lenS][lenT] = lenS;
			return lenS;
		}
		if(s.charAt(lenS-1)==t.charAt(lenT-1)){
			return getResult(lenS-1, lenT-1);
		}
		dp[lenS][lenT] =  Math.min(Math.min(getResult(lenS-1, lenT), getResult(lenS, lenT-1)), getResult(lenS-1, lenT-1))+1;
		return dp[lenS][lenT];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-->0) {
			s = sc.next();
			t = sc.next();
			dp = new int[s.length()+1][t.length()+1];
			System.out.println(getResult(s.length(), t.length()));
		}
		sc.close();
	}
}
