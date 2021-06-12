package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RotateArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		int k = 3;
		rotate(arr, k);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+", ");
		}
	}
	
    public static void rotate(int[] nums, int k) {
        Deque<Integer> al = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
			al.addFirst(nums[i]);
		}
        
        for (int i = 0; i < k; i++) {
			int v = al.pop();
			al.add(v);
		}
        
        for (int i = nums.length-1; i >=0; i--) {
        	nums[i] = al.pop();
        }
    }

}
