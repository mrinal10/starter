package com.aprilEasy;

import java.util.Scanner;

public class UnderstandComputer {

	private static int getBitCount(int n) {
//		System.out.println("getBitCount :: "+n);
		int value = 2;
		int pow = 1;
		if (n==1) {
//			System.out.println(n+" :: "+1);
			return 1;
		}
		while(n>=value) {
			value = (int) Math.pow(value, pow);
			pow++;
		}
//		System.out.println(n+" :: "+(pow-1));
		return pow-1;
	}
	
	private static int getComputer(int value){
		int count = 0;
		for(int i=1; i<=value; i++) {
			int dividend = value/i;
			
			if (getBitCount(dividend)<=getBitCount(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(getComputer(n));
		}
		sc.close();
	}
	
}
