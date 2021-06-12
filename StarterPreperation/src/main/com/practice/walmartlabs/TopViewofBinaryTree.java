package com.practice.walmartlabs;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.geekforgeeks.microsoft.TreeNode;

public class TopViewofBinaryTree {
	
	class QItem {
		TreeNode node;
		int leftRightIndicator;

		public QItem(TreeNode n, int h) {
			node = n;
			leftRightIndicator = h;
		}
	}

	
	public void printTopView(TreeNode root) {
		Queue<QItem> queue = new LinkedList<>();
		queue.add(new QItem(root, 0));
		TreeMap<Integer, QItem> map = new TreeMap<>();
		while (!queue.isEmpty()) {
			QItem dequedElement = queue.poll();
			int leftRightIndicator = dequedElement.leftRightIndicator;
			TreeNode n = dequedElement.node;
			
			if (!map.containsKey(leftRightIndicator)) {
				map.put(leftRightIndicator, dequedElement);
			}
			
			if (n.leftChild != null)
				queue.add(new QItem(n.leftChild, leftRightIndicator - 1));
			if (n.rightChild != null)
				queue.add(new QItem(n.rightChild, leftRightIndicator + 1));
		}
		
		for (Map.Entry<Integer, QItem> entry : map.entrySet()) {
			System.out.print(entry.getValue().node.data + " ");
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
