package com.leetcode;

public class NonDecreasingArray {

	public static void main(String[] args) {
		int[] arr = {4,2,3};// {3,4,2,3};
		System.out.println(checkPossibility(arr));
	}
	
	public static boolean checkPossibility(int[] nums) {
        if(nums.length==0){
            return true;
        }

        int marker = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i]>marker) {
				count++;
				if (count>0) {
					return false;
				}
			}else{
				marker = nums[i];
			}
		}
        
        return true;
    }

}
