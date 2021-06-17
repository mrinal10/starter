package com.practice.Problems;

import java.util.Scanner;

public class Micro_and_Array_Update {
	private static int getMinimumValue(int[] ar){
		int min = ar[0];
		for(int v : ar){
			if (min>v) {
				min = v;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i= 0;
		while (i<t) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < ar.length; j++) {
				ar[j] = sc.nextInt();
			}
			int minV = getMinimumValue(ar);
			if (minV<k) {
				System.out.println(k-minV);
			} else {
				System.out.println("0");
			}
			i++;
		}
		sc.close();
	}
}
