package com.standalone.practice.binarytree;

import java.util.Stack;

public class PostOrderTraversal_Iterative {
	static void inOrderTraversalIterative(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		Stack<Integer> out = new Stack<>();
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			out.push(curr.data);
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
		}
		
		while(!out.isEmpty()) {
			System.out.print(out.pop()+" ");
		}
	}

}
