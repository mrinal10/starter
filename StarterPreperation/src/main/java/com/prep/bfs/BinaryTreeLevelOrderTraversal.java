package com.prep.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class BinaryTreeLevelOrderTraversal {

	class QNode{
		TreeNode tNode;
		int level;
		public QNode(TreeNode tN, int l) {
			tNode = tN;
			level = l;
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<QNode> queue = new LinkedList<>();
		if(root==null) {
			return list;
		}
		queue.add(new QNode(root, 1));
		while (!queue.isEmpty()) {
			QNode qN = queue.poll();
			list = addToList(list, qN);
			int lvl = qN.level;
			TreeNode tNode = qN.tNode;
			if (tNode.left!=null) {
				queue.add(new QNode(tNode.left, lvl+1));
			}
			if(tNode.right!=null) {
				queue.add(new QNode(tNode.right, lvl+1));
			}
		}
		return list;
	}
	
	private List<List<Integer>> addToList(List<List<Integer>> list, QNode qNode) {
		int level = qNode.level;
		if (list.size()<level) {
			List<Integer> listN = new ArrayList<>();
			list.add(listN);
		}
		List<Integer> lis = list.get(level-1);
		lis.add(qNode.tNode.val);
		return list;
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal trvl = new BinaryTreeLevelOrderTraversal();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.left.right = new TreeNode(17);
		List<List<Integer>> listV = trvl.levelOrder(root);
		for(List<Integer> list : listV) {
			for(int a : list) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
	}
}


