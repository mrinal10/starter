package com.gfg.tree;

public class AllNodesAtKDistance {
	private static void printDownNodes(Node root, int k) {
		if (root == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
			return;
		}

		printDownNodes(root.left, k - 1);
		printDownNodes(root.right, k - 1);
	}

	private static int printkdistanceNode(Node root, Node targetNode, int k) {
		if (root == null) {
			return -1;
		}
		if (root == targetNode) {
			printDownNodes(root, k);
			return 0;
		}

		int leftDepth = printkdistanceNode(root.left, targetNode, k);
		if (leftDepth != -1) {
			if (leftDepth + 1 == k) {
				System.out.println(root.data);
			} else
				printDownNodes(root.left, leftDepth - k - 2);

			return 1 + leftDepth;
		}

		int rightDepth = printkdistanceNode(root.right, targetNode, k);
		if (rightDepth != -1) {
			if (rightDepth + 1 == k) {
				System.out.println(root.data);
			} else
				printDownNodes(root.right, rightDepth - k - 2);
			return 1 + rightDepth;
		}
		return -1;
	}

	public static void main(String args[]) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		Node target = root.left.right;
		printkdistanceNode(root, target, 2);
	}
}
