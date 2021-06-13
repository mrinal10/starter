package com.standalone.practice.binarytree;

public class InorderTraversal_Recusrsion {
	static void inorderTrav(Node root) {
		if(root == null) {
			return;
		}
		inorderTrav(root.left);
		System.out.println(root.data);
		inorderTrav(root.right);
	}
}
