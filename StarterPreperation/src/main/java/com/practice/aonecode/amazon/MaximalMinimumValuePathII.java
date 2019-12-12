package com.practice.aonecode.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class point {
	int x;
	int y;
	point(int xx, int yy) {
		x = xx;
		y = yy;
	}
	public boolean equals(point o) {
		return (this.x == o.x && this.y == o.y) ? true : false;
	}
}

public class MaximalMinimumValuePathII {
	List<Integer> list;
	public int maxPathScore(int[][] matrix) {
		list = new ArrayList<Integer>();
		reachTarget(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, matrix[0][0]);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("values : " + list.get(i));
		}
		return list.get(list.size() - 1);
	}

	public void reachTarget(int[][] matrix, int row, int col, int trgtRow, 
			int trgtCol, int minValueTillNow, List<point> visited) {
		if (!isValidLocation(matrix, row, col)) {
			return;
		}
		System.out.println("Min " + row + "  " + col + " : " + minValueTillNow);
		minValueTillNow = Math.min(matrix[row][col], minValueTillNow);
		System.out.println("Min " + row + "  " + col + " : " + minValueTillNow);
		if (row == trgtRow && col == trgtCol) {
			list.add(minValueTillNow);
			return;
		}
		reachTarget(matrix, row + 1, col, trgtRow, trgtCol, minValueTillNow);
		reachTarget(matrix, row, col + 1, trgtRow, trgtCol, minValueTillNow);
		reachTarget(matrix, row - 1, col, trgtRow, trgtCol, minValueTillNow);
		reachTarget(matrix, row, col - 1, trgtRow, trgtCol, minValueTillNow);
	}

	private boolean isValidLocation(int[][] matrix, int row, int col) {
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 9, 1 }, { 1, 2 } };// {{7, 5, 3},{2, 0, 9},{4, 5, 9}};//{{0, 1},{0, 2},{1, 3},{2, 3},{2,
												// 5},{5, 6},{3, 4}};
		MaximalMinimumValuePathI valu = new MaximalMinimumValuePathI();
		System.err.println(valu.maxPathScore(matrix));
	}
}
