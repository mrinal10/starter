package com.leetcode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		TreeNode t = new TreeNode(-2);
		t.left = new TreeNode(1);
//		t.right = new TreeNode(3);
		System.out.println(maxPathSum(t));
	}

	static int maxVal;
	public static int maxPathSum(TreeNode root) {
		maxVal = root.val;
		maxPathSumUtil(root);
		return maxVal;
	}
	public static int maxPathSumUtil(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int max = 0; 
		int l = maxPathSumUtil(root.left);
		int r = maxPathSumUtil(root.right);
		if (root.val>0) {
			max = root.val; 
			if(l>0){
				max += l;
			}
			if (r>0) {
				max += r;
			}
		}else{
			if (l<r) {
				max += r;
			}else{
				max += l;
			}
		}
		
		if (maxVal<max) {
			maxVal = max;
		}
		return max;
	}
}
