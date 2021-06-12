package com.expedia.hiring;

import java.util.Scanner;

public class ProductRating {
	static int[] arr;
	static int a = 100;

	public static void main(String args[]) throws Exception {

		int a = 200;
		System.out.println(a);
		m();

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N-- > 0) {
			int n = sc.nextInt();
			arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(printCombinations());
		}
		sc.close();
	}

	public static void m() {
		System.out.println(a);
	}

	private static int printCombinations() {
		int cnt = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 2; j < arr.length; j++) {
				for (int k = i + 1; k < arr.length - 1; k++) {
					if ((i < k && k < j) && (((arr[i] >= arr[k]) && (arr[k] >= arr[j]))
							|| ((arr[i] <= arr[k]) && (arr[j] >= arr[k])))) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

}
