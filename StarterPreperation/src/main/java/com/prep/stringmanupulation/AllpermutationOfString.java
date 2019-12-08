package com.prep.stringmanupulation;

import java.util.*;

public class AllpermutationOfString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			allPermutation(s, 0, s.length() - 1);
		}

		sc.close();
	}

	private static void allPermutation(String s, int startIndx, int endIndx) {
		if (startIndx == endIndx) {
			System.out.println(s);
		} else {
			for (int i = startIndx; i <= endIndx; i++) {
				s = swap(s, startIndx, i);
				allPermutation(s, startIndx+1, endIndx);
				s = swap(s, startIndx, i);
			}
		}
	}

	private static String swap(String s, int toIndx, int fromIndx) {
		char[] arr = s.toCharArray();
		char c = arr[toIndx];
		arr[toIndx] = arr[fromIndx];
		arr[fromIndx] = c;
		return String.valueOf(arr);
	}
}
