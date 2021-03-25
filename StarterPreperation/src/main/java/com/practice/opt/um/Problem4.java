package com.practice.opt.um;

import java.util.Arrays;

public class Problem4 {
	
	public static void main(String[] args) {
		int n = 4;
		int[] cars = {2, 10, 8, 17};
		int k = 3;
		System.out.println(getMinLength(k, n, cars));

	}
	
	private static int getMinLength(int k, int n, int[] arr) {
		Arrays.sort(arr);		
		int minLen = Integer.MAX_VALUE;
		for(int i=0; i<n-(k-1); i++) {
			if(minLen > (arr[i+k-1]-arr[i])) {
				minLen = (arr[i+k-1]-arr[i])+1;
			}
		}	
		return minLen;
	}
}
