package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Problem212 {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> ll = new ArrayList<String>();

		int row = board.length;
		int col = board[0].length;

		for (String w : words) {
			boolean flag = true;
			for (int i = 0; i < row && flag; i++) {
				for (int j = 0; j < col && flag; j++) {
					flag = !DFS(getDuplicate(board), w, i, j, 0);
					if (!flag) {
						ll.add(w);
					}
				}
			}
		}
		return ll;
	}

	private char[][] getDuplicate(char[][] board) {
		int row = board.length;
		int col = board[0].length;

		char[][] duplicated = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				duplicated[i][j] = board[i][j];
			}
		}
		return duplicated;
	}

	public boolean DFS(char[][] board, String word, int row, int col, int k) {
		int r = board.length;
		int c = board[0].length;

		if (row < 0 || row >= r || col < 0 || col >= c) {
			return false;
		}

		if (word.charAt(k) == board[row][col]) {
			char temp = board[row][col];
			board[row][col] = '#';

			if (k == word.length() - 1) {
				return true;
			} else if (DFS(board, word, row - 1, col, k + 1) || DFS(board, word, row, col - 1, k + 1)
					|| DFS(board, word, row + 1, col, k + 1) || DFS(board, word, row, col + 1, k + 1)) {
				return true;
			}
			board[row][col] = temp;
		}
		return false;
	}
}
