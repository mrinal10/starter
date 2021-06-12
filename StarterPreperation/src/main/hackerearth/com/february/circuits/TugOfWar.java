package com.february.circuits;

import java.util.Scanner;

public class TugOfWar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		float a[] = new float[N];
		int[] b = new int[N];
		
		for (int i = 0; i < b.length; i++) {
			a[i] = sc.nextFloat();
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		
		for (int i = 1; i < N; i++) {
			
			float totFL = 0;
			for (int j = 0; j < i; j++) {
				totFL += a[i]/(Math.log(2+(b[i]-b[j])));
			}
			
			
		}
		
		sc.close();
	}
}
