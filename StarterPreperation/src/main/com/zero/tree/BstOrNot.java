package com.zero.tree;

public class BstOrNot {
	private BSTNode root;	

	private static boolean isBST(BSTNode root, int lower, int higher) {
		if (root==null) {
			return true;
		}
		
		if (!(root.data<=higher && root.data>=lower)) {
			return false;
		}
		return isBST(root.left, lower, root.data) && isBST(root.right, root.data, higher);
	}
	
	public static void main(String[] args) {
		BstOrNot tree = new BstOrNot();
		tree.root = new BSTNode(15);
		tree.root.left = new BSTNode(10);
		tree.root.right = new BSTNode(33);
		tree.root.left.left = new BSTNode(4);
		tree.root.right.left = new BSTNode(22);
		System.out.println(isBST(tree.root, -100, 5000));
	}
}
