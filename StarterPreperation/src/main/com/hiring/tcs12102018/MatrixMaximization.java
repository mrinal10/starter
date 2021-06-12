package com.hiring.tcs12102018;

import java.util.Scanner;

public class MatrixMaximization {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] mtrx = new int[r][c];
		for (int i = 0; i < r; i++) {
			for(int j=0; j<c; j++){
				mtrx[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}

}
