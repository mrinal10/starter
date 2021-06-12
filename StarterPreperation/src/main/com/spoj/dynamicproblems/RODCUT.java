package com.spoj.dynamicproblems;

import java.util.Scanner;

public class RODCUT {
	
	private static int getOptionsHlpr(int remainingRod){
		if (remainingRod==0) {
			return 0;
		}
		int options = 0;
		return options;
	}
	
	private static int getOptions(int rodLength){
		for (int i = 1; i <= rodLength; i++) {
			getOptionsHlpr(rodLength-i);
		}
		return rodLength;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			System.out.println(getOptions(n));
		}
		sc.close();
	}
	
	
}
