package com.zero;

public class CountZeros {

	int countZeroes(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		int sIndex = findFirstIndex(a, 0, a.length - 1);
		if (sIndex == -1) {
			return 0;
		}
		return a.length - sIndex;
	}

	int findFirstIndex(int a[], int l, int h) {
		int mid = (l + h) / 2;
		if (h - l <= 1) {
			if (a[l] == 0) {
				return l;
			} else if (a[h] == 0) {
				return h;
			}
			return -1;
		}
		while (l < h) {
			if (a[mid] > 0) {
				return findFirstIndex(a, mid + 1, h);
			} else {
				return findFirstIndex(a, l, mid);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 0, 0, 0 };

		CountZeros czrs = new CountZeros();
		System.out.println(czrs.countZeroes(arr));
	}
}
