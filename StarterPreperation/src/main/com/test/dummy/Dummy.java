package com.test.dummy;

import java.util.Scanner;

public class Dummy {

	static int cnt=0;
	static void printSetCnt(int[] set, int a, int b) {

		long size = (long) Math.pow(2, set.length);
		int counter, j;

		for (counter = 0; counter < size; counter++) {
			int sum = 0;
			for (j = 0; j < set.length; j++) {
				if ((counter & (1 << j)) > 0)
					sum += set[j];
			}
			if(sum<=b && sum>=a){
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			cnt = 0;
			printSetCnt(arr, a, b);
			
		}
		sc.close();
	}

}
