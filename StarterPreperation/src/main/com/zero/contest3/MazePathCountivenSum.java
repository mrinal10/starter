package com.zero.contest3;

import java.util.*;

public class MazePathCountivenSum {

	static int sum;
	static int[][] arr;
	private static void getMin(String path, int cRow, int cCol, int cSum){
		if(cRow == arr.length && cCol == arr[0].length && cSum == sum){
			System.out.println(path);
			return;
		}
		if(cRow>=arr.length || cCol>=arr[0].length){
			return;
		}
		getMin(path+"->"+arr[cRow][cCol], cRow+1, cCol, cSum+arr[cRow][cCol]);
		getMin(path+"->"+arr[cRow][cCol], cRow, cCol+1, cSum+arr[cRow][cCol]);
	}
	
	public static void main(String[] args) {
		int r, c;
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		arr = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int q = sc.nextInt();
		while (q-- > 0) {
			sum = sc.nextInt();
			getMin(arr[0][0]+"->", 1, 0, arr[0][0]);
			getMin(arr[0][0]+"->", 0, 1, arr[0][0]);
		}
		sc.close();
	}
}