package com.gfg.tree;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Problem545 {
	List<Integer> nodeValueList;

	void printLeaves(TreeNode node) {
		if (node == null)
			return;
		printLeaves(node.left);
		if (node.left == null && node.right == null)
			nodeValueList.add(node.val);
		printLeaves(node.right);
	}

	void printBoundaryLeft(TreeNode node) {
		if (node == null)
			return;
		if (node.left != null) {
			nodeValueList.add(node.val);
			printBoundaryLeft(node.left);
		} else if (node.right != null) {
			nodeValueList.add(node.val);
			printBoundaryLeft(node.right);
		}
	}

	void printBoundaryRight(TreeNode node) {
		if (node == null)
			return;
		if (node.right != null) {
			printBoundaryRight(node.right);
			nodeValueList.add(node.val);
		} else if (node.left != null) {
			printBoundaryRight(node.left);
			nodeValueList.add(node.val);
		}
	}

	void printBoundary(TreeNode node) {
		if (node == null)
			return;
		nodeValueList.add(node.val);
		printBoundaryLeft(node.left);
		printLeaves(node.left);
		printLeaves(node.right);
		printBoundaryRight(node.right);
	}

	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		nodeValueList = new LinkedList<>();
		printBoundary(root);
		return nodeValueList;
	}
}
