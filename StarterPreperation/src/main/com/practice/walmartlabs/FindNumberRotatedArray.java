package com.practice.walmartlabs;

import java.util.Scanner;

public class FindNumberRotatedArray {

	public static int findPivot(int[] ar) {
		return 0;
	}

	public static void binarySearch() {

	}
	
	public static int pivotedBinarySearch(int[] ar, int valueToFind){
		int pivot = findPivot(ar);
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases-- > 0) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = sc.nextInt();
			}
			int valuTFnd = sc.nextInt();
			System.out.println(pivotedBinarySearch(ar, valuTFnd));

		}
		sc.close();
	}
}
