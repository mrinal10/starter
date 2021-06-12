package com.zero.backtracking;

import java.util.*;
import java.util.Scanner;

public class NQueen {

	static int[][] ar;
	static int numberOfQueens;
	static List<List<String>> grid = new ArrayList<List<String>>();

	public static List<List<String>> solveNQueens(int n) {
		numberOfQueens = n;
		ar = new int[numberOfQueens][numberOfQueens];
		for (int j = 0; j < numberOfQueens; j++) {
			locateQueens(0, j, numberOfQueens);
			printGrid();
			ar = new int[numberOfQueens][numberOfQueens];
		}
		return grid;
	}

	private static boolean locateQueens(int i, int j, int numberOfQueensRemaining) {
		if (numberOfQueensRemaining == 0) {
			List<String> subGrid = new ArrayList<String>();
			for (int indx = 0; indx < numberOfQueens; indx++) {
				String s = "";
				for (int k = 0; k < numberOfQueens; k++) {
					if (ar[indx][k] == 0)
						s = s + ".";
					else
						s = s + "Q";
				}
				subGrid.add(s);
			}
			grid.add(subGrid);
			return true;
		}
		if (i == numberOfQueens || j == numberOfQueens) {
			return false;
		}
		if (!isInside(i, j) || isAttacking(i, j)) {
			return false;
		}
		ar[i][j] = 1;
		for (int k = 0; k < numberOfQueens; k++) {
			if(locateQueens(i + 1, k, numberOfQueensRemaining - 1)){
				return true;
			}
		}
		ar[i][j] = 0;
		return false;
	}

	private static boolean isInside(int row, int cols) {
		return (!(row < 0 || row >= numberOfQueens || cols < 0 || cols >= numberOfQueens));
	}

	private static boolean isAttacking(int row, int cols) {

		// check for row
		for (int i = 0; i < numberOfQueens; i++) {
			if (ar[row][i] == 1) {
				return true;
			}
		}
		// check for column
		for (int i = 0; i < numberOfQueens; i++) {
			if (ar[i][cols] == 1) {
				return true;
			}
		}

		int i = row;
		int j = cols;
		while (i >= 0 && i < numberOfQueens && j >= 0 && j < numberOfQueens) {
			if ((i != row && j != cols) && (ar[i][j] == 1)) {
				return true;
			}
			i++;
			j++;
		}
		i = row;
		j = cols;
		while (i >= 0 && i < numberOfQueens && j >= 0 && j < numberOfQueens) {
			if ((i != row && j != cols) && (ar[i][j] == 1)) {
				return true;
			}
			i++;
			j--;
		}
		i = row;
		j = cols;
		while (i >= 0 && i < numberOfQueens && j >= 0 && j < numberOfQueens) {
			if ((i != row && j != cols) && (ar[i][j] == 1)) {
				return true;
			}
			i--;
			j++;
		}
		i = row;
		j = cols;
		while (i >= 0 && i < numberOfQueens && j >= 0 && j < numberOfQueens) {
			if ((i != row && j != cols) && (ar[i][j] == 1)) {
				return true;
			}
			i--;
			j--;
		}
		return false;
	}

	private static void printGrid() {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(">>>>>>");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		solveNQueens(n);
		sc.close();
	}
}
