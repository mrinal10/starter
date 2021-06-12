package com.redlock.hiring15062018;
import java.util.Scanner;


public class Problem1 {
	int global = 0;
	public void print(int arr[][], int row, int col, int result, int pos) {
		if (row == arr.length - 1 && col == arr[0].length - 1) {
			result += arr[row][col];
			global += result;
			return;
		}
		if (row >= arr.length || col >= arr[0].length) {
			return;
		}

		result = arr[row][col];
		print(arr, row, col + 1, result, pos + 1);
		print(arr, row + 1, col, result, pos + 1);
	}

	public void printGlobal(){
		System.out.println(global);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		try {
			Problem1 pam = new Problem1();
			for (int i = 0; i < tCase; i++) {
				int N = sc.nextInt();
				int M = sc.nextInt(); 
				int K = sc.nextInt();
				
				int arr[][] = new int[N][M];
				for (int j = 0; j < K; j++) {
					int i1 = sc.nextInt();
					int j1 = sc.nextInt();
					int k1 = sc.nextInt();
	
					arr[i1-1][j1-1] = k1;
				}
				pam.print(arr, 0, 0, 0, 0);
				pam.printGlobal();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
}