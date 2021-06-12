package com.zero.contest1;

import java.util.Scanner;

public class BiotonicArray {
	
	private static int findNum(int[] arr, int k){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == k){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			int i = 0;
			while (n-- > 0) {
				arr[i] = sc.nextInt();
				i++;
			}
			int q = sc.nextInt();
			while (q-- > 0) {
				int qn = sc.nextInt();
				System.out.println(findNum(arr, qn));
			}
		}
		sc.close();
	}

}
