package com.codechef;

import java.util.Scanner;

public class Mutatedminions {

	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[] ar = new int[n];
			for (int j = 0; j < ar.length; j++) {
				ar[j] = sc.nextInt();
			}
			
			int count = 0;
			for (int j = 0; j < ar.length; j++) {
				int t1 = ar[j]+k;
				if (t1%n == 0) {
					count++;
				}
			}
			
			System.out.println(count);
		}
		sc.close();
	}
}
