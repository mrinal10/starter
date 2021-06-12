package com.zero.exam;

public class AllSubArrayOfArray {

	private static void printSubArray(int[] arr, int l, int r) {
		if (l > r) {
			return;
		}
		printArray(arr, l, r);
		printSubArray(arr, l, r-1);

	}

	private static void printArray(int[] arr, int l, int r){
		for (int i = l; i <=r; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {12,44,3,56,32,7,544,78,54,2,113,452,678};
		for (int i = 0; i < arr.length; i++) {
			printSubArray(arr, i, arr.length-1);
		}
	}
}
