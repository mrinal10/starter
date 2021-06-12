package com.practice.walmartlabs;

import java.util.Scanner;

public class AkelaNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases-- > 0) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = sc.nextInt();
			}
			System.out.println(getAkela(ar, 0, ar.length - 1));
		}
		sc.close();
	}

	private static int getAkela(int[] ar, int start, int end) {
		
		if (start >= end) {
			return ar[start];
		}
		int mid = (start + end) / 2;

		if (ar[mid] != ar[mid-1] && ar[mid] != ar[mid+1]) {
			return ar[mid];
		} else if (ar[mid] == ar[mid - 1]) {
			return getAkela(ar, mid + 1, end);
		}
		return getAkela(ar, start, mid - 1);
	}
}
