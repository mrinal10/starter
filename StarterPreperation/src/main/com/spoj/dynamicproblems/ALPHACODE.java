package com.spoj.dynamicproblems;

import java.util.Scanner;

public class ALPHACODE {

	static int[] dp;
	static String s;
	private static int getValue(int indx){
		System.out.println("indx :: "+indx);
		if(indx>=s.length()){
			return 0;
		}
		if(indx==s.length()-1){
			return dp[indx] = 1;
		}
		if (dp[indx]!=0) {
			return dp[indx];
		}
		
		String temp = s.substring(indx, indx+2);
		int valueSingle = getValue(indx+1);
		int valueOnDoubleIncr = 0;
		if (Integer.parseInt(temp)<=26) {
			valueOnDoubleIncr = getValue(indx+2);
		}
		return dp[indx] = valueSingle+valueOnDoubleIncr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		while(!s.equals("0")){
			dp = new int[s.length()];

			for (int i = 0; i < dp.length; i++) {
				System.out.print(dp[i]+" ");
			}
			s = sc.next();
		}
		sc.close();
	}

}
