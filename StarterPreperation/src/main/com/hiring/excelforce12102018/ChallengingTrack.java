package com.hiring.excelforce12102018;

import java.util.Scanner;

public class ChallengingTrack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases-- > 0) {
			int n = sc.nextInt();
			long p = sc.nextLong();
			boolean flag = true;
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 0; i < arr.length; i++) {
				if (i != 0) {
					for (int j = i; j < arr.length; j++) {
						if (arr[j] > 0) {
							if ((i&1) == 0 &&(arr[j] & 1) == 0) {
								arr[j] -= 1;
							} else if ((i&1) == 1 &&(arr[j] & 1) == 1) {
								arr[j] -= 1;
							}
						}
					}
				}
				p = p - arr[i];
				if (p<0) {
					System.out.println("No");
					flag = false;
					break;
				}
			}
			if(flag){
				System.out.println("Yes "+p);
			}
		}
		sc.close();
	}

}
