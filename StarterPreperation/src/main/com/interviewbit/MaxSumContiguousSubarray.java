package com.interviewbit;

import java.util.List;

public class MaxSumContiguousSubarray {
	public int maxSubArray(final List<Integer> A) {
		int[] arr = new int[A.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = A.get(i);
		}
		
		int maxSoFar = Integer.MIN_VALUE;
		int maxValue = 0;
		for (int i = 0; i < arr.length; i++) {
			maxValue += arr[i];
			if (maxSoFar<=maxValue) {
				maxSoFar = maxValue;
			}
			if (maxSoFar<0) {
				maxSoFar = 0;
			}
		}
		return maxSoFar;
    }
}
