package com.prep.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrdertraversal {
	static class QItem {
		int level;
		Node qNode;

		public QItem(Node node, int lvl) {
			qNode = node;
			level = lvl;
		}
	}

	public static void levelOrder(Node root) {
		Queue<QItem> queue = new LinkedList<QItem>();
		if (root == null) {
			return;
		}
		QItem qitm = new QItem(root, 0);
		queue.add(qitm);

		while (!queue.isEmpty()) {
			QItem qitem = queue.poll();
			System.out.print(qitem.qNode.data+" ");
			if (qitem.qNode.left!=null) {
				queue.add(new QItem(qitem.qNode.left, qitem.level-1));
			}
			if (qitem.qNode.right!=null) {
				queue.add(new QItem(qitem.qNode.right, qitem.level+1));
			}
		}
	}
}
