package com.prep.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class LinkedListNode{
	public int val;
	public LinkedListNode next;
	public LinkedListNode(int value) {
		val = value;
		next = null;
	}
}



class CustomLinkedList{
	LinkedListNode root;
	public CustomLinkedList() {
		root = null;
	}
	public CustomLinkedList(int rootValue) {
		root = new LinkedListNode(rootValue);
	}
	
	public void appendNode(int value) {
		if(root == null) {
			root = new LinkedListNode(value);
		}else {
			LinkedListNode cur = root;
			while(cur.next!=null) {
				cur = cur.next;
			}
			LinkedListNode newNode = new LinkedListNode(value);
			cur.next = newNode;
		}		
	}
}

public class BinaryTreeLevelOrderTraversalLinkedList {

	class QNode{
		TreeNode tNode;
		int level;
		public QNode(TreeNode tN, int l) {
			tNode = tN;
			level = l;
		}
	}
	
	public List<CustomLinkedList> levelOrder(TreeNode root) {
		List<CustomLinkedList> list = new ArrayList<CustomLinkedList>();
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
	
	private List<CustomLinkedList> addToList(List<CustomLinkedList> list, QNode qNode) {
		int level = qNode.level;
		if (list.size()<level) {
			CustomLinkedList linkedList = new CustomLinkedList();
			list.add(linkedList);
		}
		CustomLinkedList existingLinkedList = list.get(level-1);
		existingLinkedList.appendNode(qNode.tNode.val);
		return list;
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalLinkedList trvl = new BinaryTreeLevelOrderTraversalLinkedList();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.left.right = new TreeNode(17);
		List<CustomLinkedList> listV = trvl.levelOrder(root);
		for(CustomLinkedList list : listV) {
			LinkedListNode cur = list.root;
			while(cur != null) {
				System.out.print(cur.val+" ");
				cur = cur.next;
			}
			System.out.println();
		}
	}
}


