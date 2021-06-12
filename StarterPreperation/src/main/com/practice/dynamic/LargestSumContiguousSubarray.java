package com.practice.dynamic;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		maxSubarray(a);
	}
	
	private static void maxSubarray(int[] arr){
		int max_till_now = Integer.MIN_VALUE;
		int max_current = 0;
		
		for (int i = 0; i < arr.length; i++) {
			max_current = max_current+arr[i];
			if (max_till_now<max_current) {
				max_till_now = max_current;
			}
			if(max_current<0){
				max_current = 0;
			}
			System.out.println(max_till_now);
		}
		System.out.println(">>>"+max_till_now);
	}

}
