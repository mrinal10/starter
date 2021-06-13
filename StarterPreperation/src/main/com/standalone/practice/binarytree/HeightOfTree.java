package com.standalone.practice.binarytree;

public class HeightOfTree {
	int height(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
