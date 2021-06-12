package com.zero.backtracking;

public class LongestIncreasingSubsequence {

	int[] hlpr;
	int longestLISLength(int arr[]) {
		hlpr = new int[arr.length];
		for(int i=1; i<arr.length; i++){
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]){
					hlpr[i] = Math.max(hlpr[i], hlpr[j]+1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max<hlpr[i]) {
				max = hlpr[i];
			}
		}
		return max+1;
	}

	public static void main(String[] args) {
		int[] ar = {3,4,-1,0,6,2,3};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.longestLISLength(ar));
	}

}
