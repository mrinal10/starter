package com.zero.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;



public class PracticeTreeTopView {
	class QItem{
		BTNode node;
		int leftRightIndicator;
		QItem(BTNode curNode, int indicator){
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

	private void topView() {
		topView(root);
	}

	private void topView(BTNode rut) {
		if(rut==null){
			return;
		}
		TreeMap<Integer, QItem> map = new TreeMap<Integer, QItem>();
		Queue<QItem> queueList = new LinkedList<QItem>();
		queueList.add(new QItem(rut, 0));
		
		while (!queueList.isEmpty()) {
//			System.out.println("queueList.size() :: "+queueList.size());
			QItem dequedElement = queueList.remove();
			int indicator = dequedElement.leftRightIndicator;
			BTNode cureNode = dequedElement.node;
//			System.out.println("indicator :::: "+indicator);
			if (!map.containsKey(indicator)) {
				map.put(indicator, dequedElement);
			}
			
			if (cureNode.left!=null) {
				queueList.add(new QItem(cureNode.left, indicator-1));
			}
			if (cureNode.right!=null) {
				queueList.add(new QItem(cureNode.right, indicator+1));
			}
		}
		for(Map.Entry<Integer, QItem> entry : map.entrySet()){
			System.out.println(entry.getValue().node.data);
		}
	}

	public static void main(String[] args) {
		PracticeTreeTopView tree = new PracticeTreeTopView();
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
		tree.topView();

		/* print inorder traversal of the minor tree */
//		System.out.println("Inorder traversal of binary tree is : ");
//		tree.inOrder();
	}

}
