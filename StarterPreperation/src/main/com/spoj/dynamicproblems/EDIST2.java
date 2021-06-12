package com.spoj.dynamicproblems;

import java.util.Scanner;

public class EDIST2 {
	static int[][] dp;
	static char a[];
	static char b[];
	
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
		if(a[lenS-1]==b[lenT-1]){
			return getResult(lenS-1, lenT-1);
		}else{
			int repetation = getResult(lenS-1, lenT-1)+1;
			int insert = getResult(lenS, lenT-1)+1;
			int deletion = getResult(lenS-1, lenT)+1;
			dp[lenS][lenT] = Math.min(repetation, Math.min(insert, deletion));
		}
		return dp[lenS][lenT];
	}
	
	static int editDistance(char a[], char b[]) 
	{ 
		dp = new int[a.length+1][b.length+1];
		return getResult(a.length, b.length);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-->0) {
			String s = sc.next();
			String  t = sc.next();
			a = s.toCharArray();
			b = t.toCharArray();
			System.out.println(editDistance(a,b));
		}
		sc.close();
	}
}
