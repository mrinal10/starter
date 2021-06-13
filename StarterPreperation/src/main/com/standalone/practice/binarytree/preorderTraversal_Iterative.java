package com.standalone.practice.binarytree;

import java.util.Stack;

public class preorderTraversal_Iterative {
	static void inOrderTraversalIterative(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			System.out.println(curr.data);
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}

		}
	}

}
