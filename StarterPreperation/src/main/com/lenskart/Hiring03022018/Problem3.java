package com.lenskart.Hiring03022018;

import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t>0) {
			t--;
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = sc.nextInt();
			}
			int max_power = 0;
			int max_power_min = 0;
			for (int i = 1; i < ar.length; i++) {
				
				int temp = 0;
				int temp_min = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					if (ar[i]>ar[j]) {
						temp = ar[j];
					}
					if (ar[i]<ar[j]) {
						temp_min = ar[j];
					}
				}
				int temp_power = ar[i]-temp;
				if (max_power<temp_power) {
					max_power = temp_power;
				}
				
				int temp_power_min = ar[i]-temp_min;
				if (max_power_min>temp_power_min) {
					max_power_min = temp_power_min;
				}
			}
			System.out.println(max_power+" :::: "+max_power_min );
		}
		sc.close();
	}
}