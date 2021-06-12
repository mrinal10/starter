package com.zero.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeBottomView {
	class QItem {
		BTNode node;
		int leftRightIndicator;

		QItem(BTNode curNode, int indicator) {
			node = curNode;
			leftRightIndicator = indicator;
		}
	}

	BTNode root = null;

	private void inOrder() {
		inOrder(root);
	}

	private void inOrder(BTNode rut) {
		if (rut == null) {
			return;
		}
		inOrder(rut.left);
		System.out.println(rut.data);
		inOrder(rut.right);
	}

	private void bottomView() {
		bottomView(root);
	}

	private void bottomView(BTNode rootOFtree) {
		if (root == null) {
			return;
		}

		TreeMap<Integer, QItem> map = new TreeMap<>();

		Queue<QItem> queue = new LinkedList<>();
		queue.add(new QItem(rootOFtree, 0));

		while (!queue.isEmpty()) {
			QItem dequedElement = queue.remove();
			int leftRightIndicator = dequedElement.leftRightIndicator;
			BTNode n = dequedElement.node;

			map.put(leftRightIndicator, dequedElement);

			if (n.left != null)
				queue.add(new QItem(n.left, leftRightIndicator - 1));
			if (n.right != null)
				queue.add(new QItem(n.right, leftRightIndicator + 1));
		}
		for (Map.Entry<Integer, QItem> entry : map.entrySet()) {
			System.out.print(entry.getValue().node.data + " ");
		}
	}

	public static void main(String[] args) {
		TreeBottomView tree = new TreeBottomView();
		tree.root = new BTNode(1);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(4);
		tree.root.right.left = new BTNode(5);
		tree.root.right.left.right = new BTNode(15);
		tree.root.right.left.right.right = new BTNode(25);

		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder();
		System.out.println("");

		/* convert tree to its mirror */
		tree.bottomView();

		/* print inorder traversal of the minor tree */
//		System.out.println("Inorder traversal of binary tree is : ");
//		tree.inOrder();
	}
}
