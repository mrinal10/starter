package com.practice.babbar;

import java.util.ArrayList;

public class RatInMaze {
	static ArrayList<String> finalList;
	static boolean[][] isVisited;
	private static boolean isSafe(int[][] m, int row, int col, int n) {
		if(row<0 || row>=n || col<0 || col>=n || m[row][col]==0 || isVisited[row][col]) {
			return false;
		}
		return true;
	}
	public static ArrayList<String> findPath(int[][] m, int n) {
        finalList = new ArrayList<String>();
        isVisited = new boolean[n][n];
        findPathUtil(m, n, 0, 0, "");
        return finalList;
    }
	
	private static void findPathUtil(int[][] m ,int n, int row, int col, String path) {
		if(!isSafe(m, row, col, n)) {
			return;
		}
		
		if(row == n-1 && col == n-1) {
			finalList.add(path);
		}
		isVisited[row][col] = true;
		findPathUtil(m ,n, row-1, col, path+"U");
		findPathUtil(m ,n, row, col+1, path+"R");
		findPathUtil(m ,n, row+1, col, path+"D");
		findPathUtil(m ,n, row, col-1, path+"L");
		isVisited[row][col] = false;
	}
}
