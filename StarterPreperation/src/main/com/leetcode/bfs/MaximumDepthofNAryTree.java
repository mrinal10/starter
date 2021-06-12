package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofNAryTree {

	Queue<Node> allNodes = new LinkedList<Node>();
	public int maxDepth(Node root) {
		allNodes = new LinkedList<Node>();
		allNodes.add(root);
		maxDepthUtil();
		return 0;
	}

	public void maxDepthUtil() {
		if (allNodes.isEmpty()) {
			return;
		}
		Node root = allNodes.poll();
		
		List<Node> childrens = root.children;
		if (childrens!=null) {
			for (int i = 0; i < childrens.size(); i++) {
				allNodes.add(childrens.get(i));
			}
		}
		maxDepthUtil();
	}
	
	public static void main(String[] args) {
		
		Node root5 = new Node(5, null);
		Node root6 = new Node(6, null);
		List<Node> nodeList1 = new ArrayList<>();
		nodeList1.add(root5);
		nodeList1.add(root6);
		
		Node root3 = new Node(6, nodeList1);
		Node root2 = new Node(6, null);
		Node root4 = new Node(6, null);
		List<Node> nodeList2 = new ArrayList<>();
		nodeList2.add(root3);
		nodeList2.add(root2);
		nodeList2.add(root4);
		
		Node root = new Node(1, nodeList2);
		MaximumDepthofNAryTree maxDepth = new MaximumDepthofNAryTree();
		maxDepth.maxDepth(root);
	}

}
