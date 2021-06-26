package com.standalone.practice.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {
	static ArrayList<Integer> levelOrder(Node node){
		ArrayList<Integer> listOfNumbers = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		if(node!=null) {
			q.add(node);
		}
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			stack.add(curNode.data);
			if(curNode.right!=null)
				q.add(curNode.right);
			if(curNode.left!=null)
				q.add(curNode.left);
		}		
		while(!stack.isEmpty()) {
			listOfNumbers.add(stack.pop());
		}
		return listOfNumbers;
	}

}