package com.leetcode.practice.microsoft;

public class Problem1448 {
	public int goodNodes(TreeNode root) {
		return goodNodes(root, Integer.MIN_VALUE);
	}

	public int goodNodes(TreeNode root, int maxValueTillNow) {
		if (root == null) {
			return 0;
		}

		if (root.val >= maxValueTillNow) {
			maxValueTillNow = root.val;
			return 1 + (goodNodes(root.left, maxValueTillNow) + goodNodes(root.right, maxValueTillNow));
		} else {
			return (goodNodes(root.left, maxValueTillNow) + goodNodes(root.right, maxValueTillNow));
		}
	}
}
