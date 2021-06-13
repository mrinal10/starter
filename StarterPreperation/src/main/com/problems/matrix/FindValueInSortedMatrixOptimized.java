package com.problems.matrix;

public class FindValueInSortedMatrixOptimized {
	public static void main(String[] args) {
		int mat[][] = { { 1, 5, 9 }, { 14, 20, 21 }, { 30, 34, 43 } };
		int x = 43;
		sortedMatrixSearch(mat, mat.length, mat[0].length, x);
	}

	private static int binarySearch(int[] arr, int key, int hi, int lo) {
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

	static void sortedMatrixSearch(int mat[][], int n, int m, int x) {
		if (n == 1) {
			binarySearch(mat[0], 0, m - 1, x);
			return;
		}

		int i_low = 0;
		int i_high = n - 1;
		int j_mid = m / 2;
		while ((i_low + 1) < i_high) {
			int i_mid = (i_low + i_high) / 2;

			if (mat[i_mid][j_mid] == x) {
				System.out.println("Found at (" + i_mid + ", " + j_mid + ")");
				return;
			}

			else if (mat[i_mid][j_mid] > x)
				i_high = i_mid;

			else
				i_low = i_mid;
		}

		if (mat[i_low][j_mid] == x)
			System.out.println("Found at (" + i_low + "," + j_mid + ")");
		else if (mat[i_low + 1][j_mid] == x)
			System.out.println("Found at (" + (i_low + 1) + ", " + j_mid + ")");
		else if (x <= mat[i_low][j_mid - 1])
			binarySearch(mat[i_low], 0, j_mid - 1, x);
		else if (x >= mat[i_low][j_mid + 1] && x <= mat[i_low][m - 1])
			binarySearch(mat[i_low], j_mid + 1, m - 1, x);
		else if (x <= mat[i_low + 1][j_mid - 1])
			binarySearch(mat[i_low + 1], 0, j_mid - 1, x);
		else
			binarySearch(mat[i_low + 1], j_mid + 1, m - 1, x);
	}

}
