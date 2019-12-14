package com.prep.tree;
import com.prep.tree.Node;

public class BST_Insertion {
	
	public static Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}
		if(root.data>data) {
			root.left = insert(root.left, data);
		}else {
			root.right = insert(root.right, data);
		}
		return root;
	}
}
