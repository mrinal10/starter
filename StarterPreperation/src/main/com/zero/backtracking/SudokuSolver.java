package com.zero.backtracking;

/**
 * 
 * @author Mrinal
 *
 */
public class SudokuSolver {

	private boolean isSafeinRow(int[][] board, int row, int col, int value) {
		for (int i = 0; i < board[0].length; i++) {
			if (board[row][i] == value) {
				return false;
			}
		}
		return true;
	}

	private boolean isSafeinColumn(int[][] board, int row, int col, int value) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == value) {
				return false;
			}
		}
		return true;
	}

	private boolean isSafeinSubGrid(int[][] board, int row, int col, int value) {

		int subGridStartRow = row - (row % 3);
		int subGridStartColumn = col - (col % 3);
		for (int i = subGridStartRow; i < subGridStartRow + 3; i++) {
			for (int j = subGridStartColumn; j < subGridStartColumn + 3; j++) {
				if (i != row && j != col) {
					if (board[i][j] == value) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean isSafe(int[][] board, int row, int col, int value) {
		return isSafeinRow(board, row, col, value) && isSafeinColumn(board, row, col, value)
				&& isSafeinSubGrid(board, row, col, value);
	}

	private int[] findNextEmptyPosition(int[][] board) {
		int[] locations = new int[2];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					locations[0] = i;
					locations[1] = j;
					return locations;
				}
			}
		}
		locations[0] = -1;
		locations[1] = -1;
		return locations;
	}

	boolean solveBoardHelper(int[][] board, int row, int colm) {
		int[] nextEmptyLocation = findNextEmptyPosition(board);

		int curRow = nextEmptyLocation[0];
		int curCol = nextEmptyLocation[1];
		if (curCol == -1 && curRow == -1) { // indicates no Unassigned position
											// left
			return true;
		}
		boolean isSolutionAchieved = false;
		for (int i = 1; i < 10; i++) {
			if (isSafe(board, curRow, curCol, i)) {
				board[curRow][curCol] = i;
				isSolutionAchieved = solveBoardHelper(board, curRow, curCol);
				if (!isSolutionAchieved) {
					board[curRow][curCol] = 0;
				}
			}
		}
		return isSolutionAchieved;
	}

	void solveBoard(int[][] board) {
		solveBoardHelper(board, 0, 0);
	}

	void printSolutionBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(">>>>>>>>");
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 3, 0, 0, 4, 0, 0 }, { 9, 0, 0, 0, 1, 0, 0, 0, 0 }, { 4, 0, 8, 0, 7, 0, 5, 0, 3 },
				{ 0, 0, 0, 6, 0, 0, 9, 0, 0 }, { 0, 0, 0, 1, 5, 7, 0, 0, 0 }, { 0, 0, 5, 0, 0, 2, 0, 0, 0 },
				{ 2, 0, 4, 0, 0, 0, 6, 0, 5 }, { 0, 0, 0, 0, 2, 0, 0, 0, 8 }, { 0, 0, 6, 7, 0, 8, 0, 0, 0 } };
		
		SudokuSolver sudokuSolver = new SudokuSolver();
//		sudokuSolver.printSolutionBoard(board);
		sudokuSolver.solveBoard(board);
		sudokuSolver.printSolutionBoard(board);
	}

}
