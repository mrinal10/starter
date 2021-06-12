package com.practice.walmartlabs;

import java.util.Scanner;

public class SpiralTraversal {

	public static void main(String[] args) {
		int n, m;
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		int[][] matrx = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrx[i][j] = sc.nextInt();
			}
		}
		spiralTraversalRow(matrx);
		sc.close();
	}
	
	private static void spiralTraversalRow(int[][] matrix){
		int starting = 0 ;
		int ending = matrix[0].length-1;
		int hi = 1;
		int low = matrix.length-1;
		for (int i = 0; i <= matrix.length/2; i++) {
			for (int j = starting; j <= ending; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			spiralTraversalColRev(matrix, hi, low, ending);
			
			for (int j = ending; j >= starting; j--) {
				System.out.print(matrix[matrix.length-i-1][j] + " ");
			}
			spiralTraversalCol(matrix, hi, low, starting);
			hi++;
			low--;
			starting++;
			ending--;
		}
	}
	
	private static void spiralTraversalCol(int[][] matrix, int hi, int low, int col){
		for (int i = low-1; i>=hi; i--) {
			System.out.print(matrix[i][col]+" ");
		}
	}
	
	private static void spiralTraversalColRev(int[][] matrix, int hi, int low, int col){
		
		for (int i = hi; i <low; i++) {
			System.out.print(matrix[i][col]+" ");
		}
	}
}
