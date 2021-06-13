package com.gfg.tree;

public class BoundaryTraversal {
	public static void printBoundary(Node root) {
		System.out.print(root.data+" ");
		printLeftBoundary(root.left);
		System.out.print("||");
		printLeafNodes(root);
		System.out.print("||");
		printRightBoundary(root.right);
	}

	private static void printLeftBoundary(Node root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			System.out.print(root.data+" ");
			printLeftBoundary(root.left);
		} else if (root.right != null) {
			System.out.print(root.data+" ");
			printLeftBoundary(root.right);
		}
	}

	private static void printRightBoundary(Node root) {
		if (root == null) {
			return;
		}
		if (root.right != null) {
			System.out.print(root.data+" ");
			printLeftBoundary(root.right);
		} else if (root.left != null) {
			System.out.print(root.data+" ");
			printLeftBoundary(root.left);
		}
	}

	private static void printLeafNodes(Node root) {
		if (root == null) {
			return;
		}
		printLeafNodes(root.left);
		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
		}
		printLeafNodes(root.right);
	}

	public static void main(String args[]) {

		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		printBoundary(root);
	}

}
