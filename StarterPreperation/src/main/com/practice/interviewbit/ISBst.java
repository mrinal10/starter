package com.practice.interviewbit;

public class ISBst {
	public int isValidBST(TreeNode A) {
		if (isBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			return 1;
		}
		return 0;
    }
	
	
	public boolean isBST(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		
		if(root.val<= min || root.val>max) {
			return false;
		}
		
		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
	}
	
}
