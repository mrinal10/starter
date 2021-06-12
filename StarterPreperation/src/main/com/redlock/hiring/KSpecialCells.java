package com.redlock.hiring;

import java.util.Scanner;

public class KSpecialCells {
	static int[][] grid;
	static int value = 0;

	private static void findMaxValue(int r, int c, int v) {
		if (r == grid.length - 1 && c == grid[0].length - 1) {
			value = value + v;
			return;
		}
		if (r >= grid.length) {
			return;
		}
		if (c >= grid[0].length) {
			return;
		}
		findMaxValue(r + 1, c, v + grid[r][c]);
		findMaxValue(r, c + 1, grid[r][c] + v);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int q = sc.nextInt();
			grid = new int[r][c];

			for (int i = 0; i < q; i++) {
				int r1 = sc.nextInt();
				int c1 = sc.nextInt();

				int valueAtGridCell = sc.nextInt();
				grid[r1 - 1][c1 - 1] = valueAtGridCell;
			}
			findMaxValue(0, 0, 0);
			System.out.println(value);
			sc.close();
		}
	}

}
