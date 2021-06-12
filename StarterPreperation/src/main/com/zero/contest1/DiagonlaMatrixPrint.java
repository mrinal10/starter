package com.zero.contest1;

public class DiagonlaMatrixPrint {

	private static void diagonalPrint(int[][] ar, int i, int j){
		if (i<0 || i>=ar.length || j<0 || j>=ar[0].length) {
			return;
		}
		System.out.print(ar[i][j]+" ");
		diagonalPrint(ar, i-1, j+1);
	}
	
	public static void main(String[] args) {
		int[][] ar = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
		int i = 0;
		for (i = 0; i < ar.length; i++) {
			diagonalPrint(ar, i, 0);
		}
		for (int j = 1; j < ar[0].length; j++) {
			diagonalPrint(ar, i-1, j);
		}
	}

}
