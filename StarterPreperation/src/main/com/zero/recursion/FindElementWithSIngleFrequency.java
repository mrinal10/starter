package com.zero.recursion;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class FindElementWithSIngleFrequency {
	private static BigInteger findAkelaInLogHelper(BigInteger arr[], int l, int r) {
		
		int mid = (l + r) / 2;
		while (l <= r) {
			if (mid == 0 || mid == arr.length - 1) {
				return arr[mid];
			}
			mid = (l + r) / 2;
			if (mid % 2 == 1) {
				if (arr[mid] == arr[mid + 1]) {
					return findAkelaInLogHelper(arr, l, mid - 1);
				} else if (arr[mid] == arr[mid - 1]) {
					return findAkelaInLogHelper(arr, mid + 1, r);
				} else {
					return arr[mid];
				}
			} else {
				if (arr[mid] == arr[mid + 1]) {
					return findAkelaInLogHelper(arr, mid + 2, r);
				} else if (arr[mid] == arr[mid - 1]) {
					return findAkelaInLogHelper(arr, l, mid + 1);
				} else {
					return arr[mid];
				}
			}
		}
		return new BigInteger("-1");
	}

	private static BigInteger findAkelaInLogN(BigInteger arr[]) {
		Arrays.sort(arr);
		return findAkelaInLogHelper(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger[] arr = new BigInteger[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextBigInteger();
		}
		System.out.println(findAkelaInLogN(arr));
		sc.close();
	}

}
