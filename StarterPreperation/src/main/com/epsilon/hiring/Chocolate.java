package com.epsilon.hiring;

import java.util.Scanner;

public class Chocolate {
	
	static int[] dp;
	static String s;
	
	
	private static boolean isVowel(char c){
		return c=='u'||c=='U'||c=='a'||c=='A'||c=='e'||c=='E'||c=='i'||c=='I'||c=='o'||c=='O';
	}
	
	private static int getValue(int index){
		if (index>=s.length()) {
			return 0;
		}
		if (dp[index]!=0) {
			return dp[index];
		}
		
		if ( isVowel(s.charAt(index))  ){
			dp[index] = getValue(index+1)+1;
		}else{
		    dp[index] = getValue(index+1);
		}
		return dp[index];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t ; i++) {
			s = sc.next();
			dp = new int[s.length()];
			int v = 0;
			getValue(0);
			for (int j = 0; j < s.length(); j++) {
				v += dp[j];
			}
			
			int temp = v;
			System.err.println("temp : "+v);
			for (int j = s.length()-2; j >= 0; j--) {
				int tmp = dp[j];
				for (int k = j; k < args.length; k++) {
					
				}
			}
			System.out.println(v);
		}
		sc.close();
	}
}
