package com.prep.tree;

public class IsBST {
	boolean checkBST(Node root) {
		return isBSTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isBSTree(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data > max || root.data < min) {
			return false;
		}
		return (isBSTree(root.left, min, root.data) && isBSTree(root.right, root.data, max));
	}
}
