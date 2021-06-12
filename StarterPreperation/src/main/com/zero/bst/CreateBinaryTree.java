package com.zero.bst;

public class CreateBinaryTree {

	private static void inorder(BSTNode root){
		if (root==null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	
	public static BSTNode create() {
		BSTNode root = new BSTNode(30);
		root.left = new BSTNode(15);
		root.left.left = new BSTNode(10);
		root.left.right = new BSTNode(20);
		root.left.right.right = new BSTNode(5);
		
		root.right = new BSTNode(50);
		root.right.left = new BSTNode(40);
		root.right.right = new BSTNode(70);
		
		inorder(root);
		return root;
	}

}

