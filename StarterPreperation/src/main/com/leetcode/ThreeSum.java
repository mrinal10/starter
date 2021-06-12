package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	List<List<Integer>> allList = new ArrayList<>();

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int j2 = j + 1; j2 < nums.length; j2++) {
					if (i != j && i != j2 && j != j2 && (nums[i] + nums[j] + nums[j2] == 0)) {
						System.out.println(nums[i] + " " + nums[j] + " " + nums[j2]);
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[j2]);
						allList.add(list);
					}
				}
			}
		}
		return allList;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		ThreeSum tSUm = new ThreeSum();
		List<List<Integer>> allList = tSUm.threeSum(nums);
		for (int i = 0; i < allList.size(); i++) {
			for (int j = 0; j < allList.get(i).size(); j++) {
				System.out.print(allList.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
