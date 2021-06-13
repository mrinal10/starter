package com.standalone.practice.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	static ArrayList<Integer> levelOrder(Node node){
		ArrayList<Integer> listOfNumbers = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		if(node!=null) {
			q.add(node);
		}
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			listOfNumbers.add(curNode.data);
			if(curNode.left!=null)
				q.add(curNode.left);
			if(curNode.right!=null)
				q.add(curNode.right);
		}		
		return listOfNumbers;
	}
}
