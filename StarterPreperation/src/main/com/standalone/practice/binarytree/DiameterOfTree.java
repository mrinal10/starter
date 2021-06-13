package com.standalone.practice.binarytree;

public class DiameterOfTree {
	int diameter(Node root) {
		return diameterH(root);
	}

	int diameterH(Node root) {
		if (root == null) {
			return 0;
		}

		int l_Height = height(root.left);
		int r_Height = height(root.right);

		int l_diameter = diameterH(root.left);
		int r_diameter = diameterH(root.right);

		return Math.max(Math.max(l_diameter, r_diameter), l_Height + r_Height + 1);
	}

	int height(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
