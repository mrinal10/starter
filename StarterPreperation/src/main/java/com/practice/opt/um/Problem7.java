package com.practice.opt.um;

import java.util.Arrays;

public class Problem7 {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };
		int[] B = { 2, 4 };

		int[] res = getCountArray(A, B);
		for(int i=0; i<res.length; i++) {
			System.out.println(res[i]);
		}
	}

	private static int[] getCountArray(int[] A, int[] B) {
		int[] result = new int[B.length];
		Arrays.sort(A);
		for (int i = 0; i < B.length; i++) {
			result[i] = searchModified(A, B[i])+1;
		}
		return result;
	}

	private static int searchModified(int[] arr, int x) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==x) {
				return i;
			} else if(arr[i]>x) {
				return i-1;
			}
		}
		return arr.length-1;
	}
}
