package com.leetcode;

import java.util.Arrays;

public class MajorityELement {

	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int indx = nums.length/2;
		return nums[indx];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
