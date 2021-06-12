package com.zero.contest1;

import java.util.Scanner;

public class SumfromLtoR {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		while (q-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int sum = 0;
			for (int i = l; i <= r; i++) {
				sum += arr[i];
			}
			System.out.println(sum);
		}
		sc.close();
	}

}
