package com.zero.tree;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TreeLeftView {
	BTNode root;
	
	private void generateLeftView(){
		generateLeftView(root);
	}
	
	private void generateLeftView(BTNode root){
		if (root==null) {
			return;
		}
		Queue<QItem> queue = new LinkedList<>();
		queue.add(new QItem(root, 0));
		LinkedHashMap<Integer, QItem> map = new LinkedHashMap<Integer, QItem>();
		while (!queue.isEmpty()) {
			QItem dequedElement = queue.poll();
			if(!map.containsKey(dequedElement.leftRightIndicator)){
				map.put(dequedElement.leftRightIndicator, dequedElement);
			}
			if (dequedElement.node.left!=null) {
				queue.add(new QItem(dequedElement.node.left, dequedElement.leftRightIndicator+1));
			}
			if (dequedElement.node.right!=null) {
				queue.add(new QItem(dequedElement.node.right, dequedElement.leftRightIndicator+1));
			}
		}
		for (Map.Entry<Integer, QItem> entry:map.entrySet()) {
			System.out.println(entry.getValue().node.data);
		}
	}
	
	public static void main(String[] args) {
		TreeLeftView tree = new TreeLeftView();
		tree.root = new BTNode(1);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(5);
		tree.root.left.right = new BTNode(4);
		tree.root.right.right = new BTNode(6);
		tree.root.right.right.left = new BTNode(7);
		tree.generateLeftView();
	}

}
