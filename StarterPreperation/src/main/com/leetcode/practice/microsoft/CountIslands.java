package com.leetcode.practice.microsoft;

public class CountIslands {
	boolean[][] isVisited;
	private boolean isSafe(int[][] matrix, int r, int c) {
		return r<matrix.length && c<matrix[0].length && r >= 0 && c >= 0 && !isVisited[r][c] && matrix[r][c]==1;
	}
	
	private int countIslands(int[][] matrix){
		int count = 0;
		isVisited = new boolean[matrix.length][matrix[0].length];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j]==1 && !isVisited[i][j]) {
					DFS(matrix, i, j);
					count++;
				}
			}
		}
		return count;		
	}
	
	private void DFS(int[][] matrix, int r, int c) {
		isVisited[r][c] = true;
		int[] rowWise = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colWise = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for(int i=0; i<8; i++) {
			if(isSafe(matrix, r+rowWise[i], c+colWise[i]))
				DFS(matrix, r+rowWise[i], c+colWise[i]);
		}
	}
	
	
	public static void main(String[] args) throws java.lang.Exception
    {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                  { 0, 1, 0, 0, 1 },
                                  { 1, 0, 0, 1, 1 },
                                  { 0, 0, 0, 0, 0 },
                                  { 1, 0, 1, 0, 1 } };
                                  CountIslands I = new CountIslands();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }
}
