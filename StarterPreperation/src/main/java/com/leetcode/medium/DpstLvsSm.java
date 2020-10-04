package com.leetcode.medium;

import com.prep.bfs.TreeNode;

//https://leetcode.com/problems/deepest-leaves-sum/

public class DpstLvsSm {
	public int deepestLeavesSum(TreeNode root) {
		int depth = depthOfTree(root);
		System.out.println("Depth : " + depth);
		return getSum(root, depth-1, 0);
	}

	private int getSum(TreeNode root, int depth, int curDepth) {
		if (root == null) {
			return 0;
		}
		if (depth == curDepth) {
			return root.val;
		} else {
			return getSum(root.left, depth, curDepth + 1) + getSum(root.right, depth, curDepth + 1);
		}
	}

	private int depthOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(depthOfTree(root.left), depthOfTree(root.right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(7);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);

		root.left.left.left = new TreeNode(9);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(4);

		root.left.left.left.left = new TreeNode(7);
		root.left.right.right.right = new TreeNode(8);

		DpstLvsSm sss = new DpstLvsSm();
		System.out.println(sss.deepestLeavesSum(root));
	}

}
