package com.geekforgeeks.microsoft;

import java.util.Scanner;

public class MatrixSpiralPrint {
	static int[][] mat = {{1,2,3,4,15},{5,6,7,8,18},{9,10,11,12,22},{13,14,15,16,26}};
	
	private static void spiralPrint(int r, int c){
		if (r>=mat.length) {
			return;
		}
		for (int i = c; i < mat[r].length-c; i++) {
			System.out.print(mat[r][i]+" ");
		}
		for (int i = r+1; i < mat[0].length-r-2; i++) {
			System.out.print(mat[i][mat[0].length-c-1]+" ");
		}
		for (int i = mat[0].length-c-1; i >=c ; i--) {
			System.out.print(mat[mat.length-c-1][i]+" ");
		}
		for (int i = mat[0].length-r-3; i>=r+1 ; i--) {
			System.out.print(mat[i][c]+" ");
		}
		spiralPrint(r+1, c+1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
//			int r = sc.nextInt();
//			int c = sc.nextInt();
//			
//			mat = new int[r][c];
//			for (int i = 0; i < mat.length; i++) {
//				for (int j = 0; j < mat[0].length; j++) {
//					mat[i][j] = sc.nextInt();
//				}
//			}
			spiralPrint(0,0);
		}
		sc.close();
	}

}
