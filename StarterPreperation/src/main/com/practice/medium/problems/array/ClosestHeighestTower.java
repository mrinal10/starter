package com.practice.medium.problems.array;

import java.util.Scanner;

public class ClosestHeighestTower {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int[] ar = new int[l];
			
			for (int j = 0; j < ar.length; j++) {
				ar[j] = sc.nextInt();
			}
			getValue(ar);
		}
		
		sc.close();
	}
	
	private static void getValue(int[] arn){
		int temp = 0;
		for (int i = 0; i < arn.length; i++) {
			temp += getNextBig(arn, i);
		}
		
		System.out.println(temp);
	}
	
	private static int getNextBig(int[] ar, int startIndex) {
		int temp = ar[startIndex];
		for (int i = startIndex; i < ar.length; i++) {
			
			if (temp < ar[i]) {
				temp = ar[i];
				break;
			}
		}
		if (temp == ar[startIndex]) {
			return 0;
		}
		return temp;
	}

}
