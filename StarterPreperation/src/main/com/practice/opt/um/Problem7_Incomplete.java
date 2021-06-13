package com.practice.opt.um;

import java.util.Arrays;

public class Problem7_Incomplete {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };
		int[] B = { 2, 4 };

		getCountArray(A, B);
	}

	private static int[] getCountArray(int[] A, int[] B) {
		Arrays.sort(A);
		for (int i = 0; i < B.length; i++) {
			System.out.println(binarySearchModified(A, 0, A.length-1, B[i])+1);
		}
		return null;
	}

	private static int binarySearchModified(int[] arr, int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;

			if (arr[mid] == x)
				return mid;

			if (mid == arr.length - 1 && arr[mid] < x)
					return mid;
			if (arr[mid - 1] < x && arr[mid + 1] > x)
				return mid - 1;

			if (arr[mid] > x)
				return binarySearchModified(arr, l, mid - 1, x);

			return binarySearchModified(arr, mid + 1, r, x);
		}

		return -1;
	}
}
