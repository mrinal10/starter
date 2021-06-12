package com.zero.contest2;

import java.util.Scanner;

public class Problem1 {
	
	static int knapSack(int W, int val[][], int n) {
		if (n == 0 || W == 0)
			return 0;
		if (val[0][n - 1] > W)
			return knapSack(W, val, n - 1);
		else
			return Math.max(val[1][n - 1] + knapSack(W - val[0][n - 1], val, n - 1), knapSack(W, val, n - 1));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lim = sc.nextInt();
		int numOfEle = sc.nextInt();
		int[][] arr = new int[2][numOfEle];
		for (int i = 0; i < arr[0].length; i++) {
			arr[0][i] = sc.nextInt();
			arr[1][i] = sc.nextInt();
		}
		System.out.println(knapSack(lim, arr, numOfEle));
		sc.close();
	}

}
