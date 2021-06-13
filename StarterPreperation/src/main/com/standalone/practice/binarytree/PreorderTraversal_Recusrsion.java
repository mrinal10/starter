package com.standalone.practice.binarytree;

public class PreorderTraversal_Recusrsion {
	static void inorderTrav(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		inorderTrav(root.left);
		inorderTrav(root.right);
	}
}
