package com.prep.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
class Node1 {
	int data;
	Node1 left;
	Node1 right;

	Node1(int n) {
		data = n;
	}
}
public class TopViewBinaryTree {

	

	Node1 root;

	public TopViewBinaryTree() {
		root = null;
	}

	public static void topView(Node1 root) {
		class QueueObj {
			Node1 Node1;
			int hd;

			QueueObj(Node1 Node1, int hd) {
				this.Node1 = Node1;
				this.hd = hd;
			}
		}
		Queue<QueueObj> q = new LinkedList<QueueObj>();
		Map<Integer, Integer> topViewMap = new TreeMap<Integer, Integer>();

		if (root == null) {
			return;
		} else {
			q.add(new QueueObj(root, 0));
		}

		while (!q.isEmpty()) {
			QueueObj qObj = q.poll();
			if (!topViewMap.containsKey(qObj.hd)) {
				topViewMap.put(qObj.hd, qObj.Node1.data);
			}
			if (qObj.Node1.left != null) {
				q.add(new QueueObj(qObj.Node1.left, qObj.hd - 1));
			}
			if (qObj.Node1.right != null) {
				q.add(new QueueObj(qObj.Node1.right, qObj.hd + 1));
			}
		}

		for (Map.Entry<Integer, Integer> entry : topViewMap.entrySet()) {
			System.out.print(entry.getValue() + " ");
		}
	}

	// Driver Program to test above functions
	public static void main(String[] args) {
		TopViewBinaryTree tree = new TopViewBinaryTree();
		tree.root = new Node1(1);
		tree.root.left = new Node1(2);
		tree.root.right = new Node1(3);
		tree.root.left.right = new Node1(4);
		tree.root.left.right.right = new Node1(5);
		tree.root.left.right.right.right = new Node1(6);
		System.out.println("Following are Node's in top view of Binary Tree");
		tree.topView(tree.root);
	}
}
