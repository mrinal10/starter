package com.zero.tree;

import java.util.*;

public class TopViewOfTree {
	
	class QItem {
		BTNode node;
		int leftRightIndicator;

		public QItem(BTNode n, int h) {
			node = n;
			leftRightIndicator = h;
		}
	}

	void topView(BTNode root) {
		if (root == null) {
			return;
		}

		TreeMap<Integer, QItem> map = new TreeMap<>();

		Queue<QItem> queue = new LinkedList<>();
		queue.add(new QItem(root, 0));

		while (!queue.isEmpty()) {
			QItem dequedElement = queue.remove();
			int leftRightIndicator = dequedElement.leftRightIndicator;
			BTNode n = dequedElement.node;

			if (!map.containsKey(leftRightIndicator)) {
				map.put(leftRightIndicator, dequedElement);
			}

			if (n.left != null)
				queue.add(new QItem(n.left, leftRightIndicator - 1));
			if (n.right != null)
				queue.add(new QItem(n.right, leftRightIndicator + 1));
		}
		for (Map.Entry<Integer, QItem> entry : map.entrySet()) {
			System.out.print(entry.getValue().node.data + " ");
		}
	}
}