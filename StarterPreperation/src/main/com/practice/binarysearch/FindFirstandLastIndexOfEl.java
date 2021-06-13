package com.practice.binarysearch;

public class FindFirstandLastIndexOfEl {
	public static void main(String[] args) {

	}

	public int[] searchRange(final int[] A, int B) {
		int[] res = new int[2];
		res[0] = getLeftIndex(A, B);
		res[1] = getRightIndex(A, B);
		return res;
	}

	private int getLeftIndex(int[] A, int findIndx) {
		int indx = -1;
		int a = 0;
		int l = A.length - 1;

		while (a <= l) {
			int mid = (a + l) / 2;
			if (A[mid] >= findIndx) {
				l = mid - 1;
			} else {
				a = mid + 1;
			}
			if (A[mid] == findIndx)
				indx = mid;
		}

		return indx;
	}

	private int getRightIndex(int[] A, int findIndx) {
		int indx = -1;
		int a = 0;
		int l = A.length - 1;

		while (a <= l) {
			int mid = (a + l) / 2;
			if (A[mid] <= findIndx) {
				a = mid + 1;
			} else {
				l = mid - 1;
			}
			if (A[mid] == findIndx)
				indx = mid;
		}

		return indx;
	}
}
