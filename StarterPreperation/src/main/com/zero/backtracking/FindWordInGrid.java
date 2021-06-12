package com.zero.backtracking;

import java.util.Scanner;

/**
 * 
 * @author Mrinal
 *
 */
public class FindWordInGrid {
	private static char[][] grid;
	private static String nametoFind;

	boolean hasWord(String nameToFind) {
		boolean find = false;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == nameToFind.charAt(0)) {
					find = findWord("", grid.length, grid[0].length, i, j);
					if (find) {
						i = grid.length;
						j = grid[0].length;
					}
				}
			}
		}
		return find;
	}

	boolean findWord(String pathVar, int rowSize, int colSize, int i, int j) {
		if (i >= rowSize || j >= colSize || i < 0 || j < 0) {
			return false;
		}
		pathVar = pathVar + grid[i][j];
		if (nametoFind.trim().equals(pathVar)) {
			return true;
		}
		if (!nametoFind.startsWith(pathVar)) {
			return false;
		}

		boolean left = findWord(pathVar, rowSize, colSize, i, j - 1);
		boolean right = findWord(pathVar, rowSize, colSize, i, j + 1);
		boolean up = findWord(pathVar, rowSize, colSize, i - 1, j);
		boolean down = findWord(pathVar, rowSize, colSize, i + 1, j);
		
		boolean diag = findWord(pathVar, rowSize, colSize, i + 1, j + 1);
		boolean alternateDiag = findWord(pathVar, rowSize, colSize, i - 1, j - 1);
		boolean revdiag = findWord(pathVar, rowSize, colSize, i + 1, j - 1);
		boolean revAlterNateDiag = findWord(pathVar, rowSize, colSize, i - 1, j + 1);
		
		return left || right || up || down || diag || alternateDiag || revdiag || revAlterNateDiag;
	}

	public static void main(String[] args) {
		char[][] grid1 = { 
				{ 'E', 'Q', 'R', 'E', 'C', 'J', 'F', 'O', 'B', 'L', 'O', 'I', 'U', 'H', 'U' },
				{ 'T', 'I', 'R', 'U', 'S', 'W', 'S', 'B', 'B', 'W', 'B', 'F', 'B', 'N', 'M' },
				{ 'B', 'L', 'F', 'U', 'N', 'M', 'U', 'E', 'J', 'G', 'D', 'T', 'D', 'R', 'U' },
				{ 'E', 'A', 'K', 'E', 'Q', 'W', 'N', 'U', 'X', 'Y', 'Z', 'R', 'R', 'L', 'B' },
				{ 'I', 'W', 'F', 'T', 'N', 'J', 'U', 'G', 'S', 'Z', 'Q', 'X', 'J', 'K', 'N' },
				{ 'B', 'O', 'I', 'O', 'N', 'E', 'R', 'E', 'Y', 'N', 'B', 'X', 'G', 'K', 'L' },
				{ 'Q', 'I', 'Q', 'Y', 'X', 'F', 'W', 'L', 'C', 'O', 'F', 'R', 'T', 'C', 'L' },
				{ 'B', 'P', 'M', 'S', 'X', 'E', 'A', 'E', 'N', 'N', 'O', 'O', 'Q', 'S', 'K' },
				{ 'A', 'J', 'F', 'Y', 'C', 'N', 'D', 'L', 'D', 'P', 'M', 'C', 'S', 'W', 'Z' },
				{ 'P', 'I', 'P', 'M', 'H', 'I', 'N', 'S', 'Y', 'J', 'T', 'Q', 'I', 'D', 'B' },
				{ 'E', 'X', 'M', 'G', 'R', 'F', 'V', 'R', 'Z', 'M', 'H', 'V', 'I', 'N', 'F' },
				{ 'B', 'S', 'X', 'M', 'A', 'H', 'B', 'O', 'L', 'L', 'Y', 'J', 'A', 'E', 'K' },
				{ 'B', 'N', 'R', 'K', 'R', 'Q', 'B', 'S', 'W', 'B', 'T', 'N', 'T', 'T', 'C' },
				{ 'U', 'U', 'J', 'C', 'U', 'O', 'U', 'Q', 'A', 'S', 'C', 'P', 'J', 'B', 'B' },
				{ 'B', 'P', 'Y', 'Y', 'W', 'U', 'O', 'O', 'X', 'H', 'R', 'W', 'H', 'L', 'P' } };
		grid = grid1;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Enter Name : ");
			nametoFind = sc.next();
			FindWordInGrid findGrid = new FindWordInGrid();
			System.out.println(findGrid.hasWord(nametoFind));
			System.out.println("want to continue (y/n):");
			char cc = sc.next().charAt(0);
			if (cc == 'n' || cc == 'N') {
				flag = false;
			}
		}
		sc.close();
	}
}