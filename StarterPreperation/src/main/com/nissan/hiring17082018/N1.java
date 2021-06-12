package com.nissan.hiring17082018;


import java.util.Arrays;
import java.util.Scanner;

public class N1 {

	private static void findSmallestAvgSum(int[] arr, int avg){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if( avg <= (sum/(i+1)) ){
				System.out.println(i);
				return;
			}
		}
		System.out.println(arr.length);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int[] arr = new int[l];
		for(int i=0; i<l; i++){
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int q = sc.nextInt();
		for(int i=0; i<q; i++){
			int avg = sc.nextInt();
			findSmallestAvgSum(arr, avg);
		}
		sc.close();
	}
}
