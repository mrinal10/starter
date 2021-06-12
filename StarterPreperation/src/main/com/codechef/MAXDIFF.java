package com.codechef;


import java.util.Arrays;
import java.util.Scanner;

class MAXDIFF {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int total = 0;
			int[] ar = new int[n];
			for (int j = 0; j < ar.length; j++) {
				ar[j] = sc.nextInt();
				total += ar[j];
			}
			int tmp = 0;
			Arrays.sort(ar);
			for (int j = 0; j < k; j++) {
				tmp += ar[j];
			}
			System.out.println(total-tmp-tmp);
		}
		sc.close();
	}
}
