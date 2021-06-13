package com.standalone.practice.binarytree;

import java.util.Stack;

public class InorderTraversal_Iterative {
	static void inOrderTraversalIterative(Node root) {
		Stack<Node> stack = new Stack<>();
		Node curr = root;
		
		while(!stack.isEmpty() || curr!= null) {
			if(curr!=null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop();
				System.out.println(curr.data);
				curr = curr.right;
			}
		}
	}

}
