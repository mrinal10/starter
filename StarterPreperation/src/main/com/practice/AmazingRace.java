package com.practice;

import java.util.Scanner;

public class AmazingRace {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			
			for (int j = 0; j < ar.length; j++) {
				ar[j] = sc.nextInt();
			}
			int maxVal = 0;
			int index = 0;
			for (int j = 0; j < ar.length; j++) {
				int indx = j+1;
				int canSee=0;
				if (j==0) {
					for (int k = 1; k < ar.length; k++) {
						canSee++;
						if (ar[j]<=ar[k]) {
							break;
						}
					}
				}else if(j==ar.length-1){
					for (int k = ar.length-2; k >= 0; k--) {
						canSee++;
						if (ar[j]<=ar[k]) {
							break;
						}
					}
				}else{
					for (int k = j+1; k < ar.length; k++) {
						canSee++;
						if (ar[j]<=ar[k]) {
							break;
						}
					}
					for (int k = j-1; k >= 0; k--) {
						canSee++;
						if (ar[j]<=ar[k]) {
							break;
						}
					}
				}
				if (maxVal<(canSee*indx)) {
					maxVal=(canSee*indx);
					index = indx;
				}
			}
			System.out.println(index);
		}
		sc.close();
	}
}
