package com.zero.contest1;

import java.util.Scanner;

public class CountSumPath {

	private static int count = 0;

	static void countSumPathHelper(int[][] a, int sum, int r, int c, int rlim, int clim) {
		sum -= a[r][c];
		if (sum == 0 && r == rlim && c == clim) {
			count++;
		} else if ((sum == 0) || (r == rlim && c == clim)) {
			return;
		} else if (r == rlim && c < clim) {
			countSumPathHelper(a, sum, r, c + 1, rlim, clim);
		} else if (r < rlim && c == clim) {
			countSumPathHelper(a, sum, r + 1, c, rlim, clim);
		} else {
			countSumPathHelper(a, sum, r, c + 1, rlim, clim);
			countSumPathHelper(a, sum, r + 1, c, rlim, clim);
		}
	}

	static void countSumPath(int[][] a, int sum) {
		int r = a.length - 1;
		int c = a[0].length - 1;
		countSumPathHelper(a, sum, 0, 0, r, c);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] mat = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		int q = sc.nextInt();
		while (q-- > 0) {

			int sum = sc.nextInt();
			countSumPath(mat, sum);
			System.out.println(count);

		}
		sc.close();
	}

}
