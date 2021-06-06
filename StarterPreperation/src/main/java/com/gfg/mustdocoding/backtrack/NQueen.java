package com.gfg.mustdocoding.backtrack;

import java.util.Scanner;

public class NQueen {

	private static boolean isSafe(int row, int col, int[][] board) {
		int dim = board.length;
		if (row >= dim || col >= dim) {
			return false;
		}
		for(int i=0; i<row; i++) {
			if (board[i][col] == 1) {
				return false;
			}
		}
		
		for(int i=0; i<col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		
	    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 1) 
                return false; 
        for (int i = row, j = col; j >= 0 && i < dim; i++, j--) 
            if (board[i][j] == 1) 
                return false; 
		return true;
	}

	private static boolean nQnUtil(int[][] board, int col) {
		int dim = board.length;
		if (col >= dim) {
			return true;
		}
		for (int i = 0; i < dim; i++) {
			if (isSafe(i, col, board)) {
				board[i][col] = 1;
				if (nQnUtil(board, col + 1)) {
					return true;
				}
				board[i][col] = 0;
			}
		}
		return false;
	}

	private static void printSolMatrix(int[][] chessBoard) {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[0].length; j++) {
				System.out.print(chessBoard[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the chess Board Dimension: ");
		int n = sc.nextInt();
		int[][] chessBoard = new int[n][n];
		if (nQnUtil(chessBoard, 0)) {
			printSolMatrix(chessBoard);
		}else
			System.out.println("No Solution Found.");
		sc.close();
	}
	
	
}
