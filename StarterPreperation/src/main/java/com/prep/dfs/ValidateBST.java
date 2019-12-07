package com.prep.dfs;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class ValidateBST {
	public static boolean isValidBST(TreeNode root) {
		return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}

	public static boolean isValid(TreeNode root, long max, long min) {
		if (root == null) {
			return true;
		}
		long rooVal = root.val;
		
		if (rooVal >= max || rooVal <= min) {
			return false;
		}
		if (root.right != null && root.val > root.right.val) {
			return false;
		}
		if (root.left != null && root.val < root.left.val) {
			return false;
		}
		return (isValid(root.left, rooVal, min) && isValid(root.right, max, rooVal));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2147483647);
		//root.left = new TreeNode(2);
		//root.right = new TreeNode(3);
		System.out.println(isValidBST(root));
	}
}
