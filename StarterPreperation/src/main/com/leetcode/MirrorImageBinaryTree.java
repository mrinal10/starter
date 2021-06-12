package com.leetcode;

public class MirrorImageBinaryTree {

	public static void main(String[] args) {
		
	}
	public TreeNode invertTree(TreeNode root) {
		mirrorTreeUtil(root);
		return root;
    }
	
	public void mirrorTreeUtil(TreeNode root) {
		if (root==null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorTreeUtil(root.left);
		mirrorTreeUtil(root.right);
	}
}
