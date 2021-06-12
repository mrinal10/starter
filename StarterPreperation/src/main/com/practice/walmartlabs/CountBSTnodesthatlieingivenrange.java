package com.practice.walmartlabs;

public class CountBSTnodesthatlieingivenrange {
	int getCountOfNode(Node root, int low, int high) {
		if (root == null) {
			return 0;
		}

		if (root.data > high) {
			return getCountOfNode(root.left, low, high);
		} else if (root.data < low) {
			return getCountOfNode(root.right, low, high);
		} else {
			return 1 + getCountOfNode(root.left, low, high) + getCountOfNode(root.right, low, high);
		}
	}
}
