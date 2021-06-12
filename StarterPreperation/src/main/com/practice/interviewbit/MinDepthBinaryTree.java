package com.practice.interviewbit;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class MinDepthBinaryTree {
	public static void main(String[] args) {
		
	}
	
	
	public int minDepth(TreeNode A) {
		if (A==null) {
			return 1;
		}
		
		if(A.left== null) {
			return 1+minDepth(A.right);
		}
		
		if(A.right== null) {
			return 1+minDepth(A.left);
		}
		
		return 1+Math.min(minDepth(A.left), minDepth(A.right));
    }
}
