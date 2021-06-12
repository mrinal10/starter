package com.leetcode;

import java.util.Arrays;


public class MaxTimeFromDigits {
	static int hourLim = 23;
	static int minLim = 59;
	
	static int indxa = 0;
	static int indxb = 0;
	
	public static String largestTimeFromDigits(int[] A) {
		Arrays.sort(A);
		int firstELement = -1;
		int ndELement = 0;
		int hr = findLargest(A);
		for (int i = 0; i < A.length; i++) {
			if (firstELement!=-1) {
				if (i==indxb) {
					ndELement = i;
				}
			}else{
				if (i==indxa) {
					firstELement = i;
				}
			}
		}
		int min = findLargest(firstELement, ndELement);
		System.out.println(hr+" : "+min);
		return null;

	}
	
	private static int findLargest(int[] A){
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i!=j) {
					int v = i*10+j;
					if (v<=hourLim && v>max) {
						indxa = i;
						indxb = j;
						max = v;
					}
				}
			}
		}
		return max;
	}
	
	private static int findLargest(int A, int b){
		if (A*10+b<b*10+A && (b*10+A)<=minLim) {
			return b*10+A;
		}
		return A*10+b;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		largestTimeFromDigits(A);
	}
}
