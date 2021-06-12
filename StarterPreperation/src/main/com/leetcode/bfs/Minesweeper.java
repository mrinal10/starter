package com.leetcode.bfs;

import java.util.Scanner;

public class Minesweeper {

	public char[][] updateBoard(char[][] board, int[] click) {
		int rwClicked = click[0];
		int clmnClicked = click[1];
		if (board[rwClicked][clmnClicked] == 'M') {
			board[rwClicked][clmnClicked] = 'X';
			return board;
		}else{
			
		}
		return board;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ro = sc.nextInt();
		int colmn = sc.nextInt();
		char[][] block = new char[ro][colmn];
		for (int i = 0; i < ro; i++) {
			for (int j = 0; j < colmn; j++) {
				block[i][j] = sc.next().charAt(0);
			}
		}
		sc.close();
	}
}
