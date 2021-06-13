package com.problems.matrix;

public class FindValueInSortedMatrix {
	public static void main(String[] args) {
		int mat[][] = { {1, 5, 9},
                {14, 20, 21},
                {30, 34, 43} };
		int x = 22;
		printIndex(mat, x);
	}
	
	private static void printIndex(int[][] mat, int key) {
		int i = 0;
		int j = mat.length-1;
		
		while(i<mat.length-1 && j>=0) {
			if(mat[i][j] == key) {
				System.out.println(i+", "+j);
				return;
			} else if(mat[i][j]<key) {
				i++;
			} else {
				j--;
			}
		}
		System.out.println(-1+", "+ -1);
	}
}
