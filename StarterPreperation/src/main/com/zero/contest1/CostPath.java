package com.zero.contest1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class CostPath {
	static String[][] grid;
	static PriorityQueue<Integer> pq;

	static void getDthValueHlpr(int row, int column, int r, int c, int cost) {
		if (row > r || column > c || grid[row][column].equals("##")) {
			return;
		}
		if (row == r && column == c) {
			pq.add(cost + Integer.parseInt(grid[r][c]));
			return;
		}
		getDthValueHlpr(row + 1, column, r, c, cost + Integer.parseInt(grid[row][column]));
		getDthValueHlpr(row, column + 1, r, c, cost + Integer.parseInt(grid[row][column]));
	}

	static void getDthValue(int r, int c, int d) {
		pq = new PriorityQueue<>();
		if (grid[r][c].equals("##")) {
			System.out.println("Obstacle");
		} else {
			getDthValueHlpr(0, 0, r, c, 0);
			if (pq.size() >= d) {
				while (d - 1 > 0) {
					pq.poll();
					d -= 1;
				}
				System.out.println(pq.poll());
			} else if (pq.size() < d) {
				System.out.println("Not so many paths");
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();

			grid = new String[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					grid[i][j] = sc.next();
				}
			}
			int q = sc.nextInt();
			while (q-- > 0) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int d = sc.nextInt();
				getDthValue(r, c, d);
			}
		}
		sc.close();
	}

}
