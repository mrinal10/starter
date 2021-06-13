package com.gfg.arrays;

public class Kadane {
	public static void main(String[] args) {
		
	}
	
	private int getMaxSubarraySum(int[] ar) {
		int max_so_far = 0;
		int max_ending_here = 0;
		
		for(int i=0; i<ar.length; i++) {
			max_ending_here = max_ending_here + ar[i];
			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
		}
		return max_so_far;
	}
}
