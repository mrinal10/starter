package com.practice;

import java.util.Arrays;
import java.util.Scanner;

public class SumitsHappiness {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		//System.out.println("Mrinal :: ");
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			int countNegative = 0;
			for (int j = 0; j < ar.length; j++) {
				int temp = sc.nextInt();
				if (temp < 0) {
					countNegative ++;
				}
				ar[j] = temp;
			}
			
			int countPositive = 0;
			
			Arrays.sort(ar);
			
			for (int j = countNegative; j < n; j++) {
				countPositive += ar[j];
			}
			countPositive = countPositive * (n-countNegative);
			int temp = 0;
			for (int j = 0; j < countNegative; j++) {
				temp += ar[j];
			}
			countPositive += countPositive+ (countNegative*temp);
			
			System.out.println(countPositive);
		}
		sc.close();
	}

}
