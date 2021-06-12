package com.zero.backtracking;

/**
 * 
 * @author Mrinal
 *
 */
public class SudokuSolver2 {

	private boolean isSafeinRow(char[][] board, int row, int col, char value) {
		for (int i = 0; i < board[0].length; i++) {
			if (board[row][i] == value) {
				return false;
			}
		}
		return true;
	}

	private boolean isSafeinColumn(char[][] board, int row, int col, char value) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == value) {
				return false;
			}
		}
		return true;
	}

	private boolean isSafeinSubGrid(char[][] board, int row, int col, char value) {

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

	private boolean isSafe(char[][] board, int row, int col, char value) {
		return isSafeinRow(board, row, col, value) && isSafeinColumn(board, row, col, value)
				&& isSafeinSubGrid(board, row, col, value);
	}

	private int[] findNextEmptyPosition(char[][] board) {
		int[] locations = new int[2];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
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

	boolean solveBoardHelper(char[][] board, int row, int colm) {
		int[] nextEmptyLocation = findNextEmptyPosition(board);

		int curRow = nextEmptyLocation[0];
		int curCol = nextEmptyLocation[1];
		if (curCol == -1 && curRow == -1) { // indicates no Unassigned position
											// left
			return true;
		}
		boolean isSolutionAchieved = false;
		for (int i = 1; i < 10; i++) {
			if (isSafe(board, curRow, curCol, String.valueOf(i).charAt(0))) {
				board[curRow][curCol] = String.valueOf(i).charAt(0);
				
				isSolutionAchieved = solveBoardHelper(board, curRow, curCol);
				if (!isSolutionAchieved) {
					board[curRow][curCol] = '.';
				}
			}
		}
		return isSolutionAchieved;
	}

	void solveBoard(char[][] board) {
		solveBoardHelper(board, 0, 0);
	}

	void printSolutionBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(">>>>>>>>");
	}

	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
			
			
			
		SudokuSolver2 sudokuSolver2 = new SudokuSolver2();
//		sudokuSolver.printSolutionBoard(board);
		sudokuSolver2.solveBoard(board);
		sudokuSolver2.printSolutionBoard(board);
	}

}
