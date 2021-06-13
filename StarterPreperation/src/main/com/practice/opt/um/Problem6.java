package com.practice.opt.um;

import java.util.Arrays;

public class Problem6 {
	public static void main(String[] args) {
		int[] ratings = {1, 3, 6, 6};//{4, 2, 5, 1};
		System.out.println(getMinDiferenceSum(ratings));
	}
	private static long getMinDiferenceSum(int[] arr) {
		Arrays.sort(arr);
		long totalDiff = 0;
		for(int i=0; i<arr.length-1; ) {
			totalDiff += arr[i+1]-arr[i];
			i += 2;
		}
		return totalDiff;
	}
}
