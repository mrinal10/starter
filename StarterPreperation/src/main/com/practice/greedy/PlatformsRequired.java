package com.practice.greedy;

import java.util.Scanner;

public class PlatformsRequired {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int arrival[]=new int[n];
			int departure[]=new int[n];
			for (int j = 0; j < n; j++) {
				arrival[j]=sc.nextInt();
				departure[j]=sc.nextInt();
			}
			int currentC = 0;
			int maxCount = currentC;
			int j= 0;
			int k = 0;
			while(k<n && j < n) {
				if (arrival[k]<departure[j]) {
					k++;
					currentC++;
					if (maxCount<currentC) {
						maxCount = currentC;
					}
				}else{
					j++;
					currentC = 0;
				}
//				System.out.println("currentC :: "+currentC);
			}
			System.out.println(maxCount);
		}
		sc.close();
	}
}
