package com.leetcode.medium.linkedlist;

class MyLinkedList {
	
	private Node head;
	
	class Node {
		private int val;
		private Node next;

		public Node() {}

		public Node(int v) {
			val = v;
			next = null;
		}
	}

	public MyLinkedList() {
		head = new Node();
	}

	public int get(int index) {
		Node  cur = head;
		int cnt = 0;
		while (cnt < index &&  cur != null) {
			 cur =  cur.next;
			 cnt++;
		}
		return cur.val;
	}

	public void addAtHead(int val) {
		Node temp = new Node(val);
		if (head == null) {
			head = temp;
		} else {
			temp.next = head;
			head = temp;
		}
	}

	public void addAtTail(int val) {
		Node temp = head;
		if (temp == null) {
			head = new Node(val);
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(val);
		}
	}
	
	public void addAtIndex(int index, int val) {
		Node  cur = head;
		int cnt = 0;
		while (cnt < index - 1 &&  cur != null) {
			 cur =  cur.next;
			 cnt++;
		}
		Node temp = new Node(val);
		temp.next = cur.next;
		cur.next = temp;
	}

	public void deleteAtIndex(int index) {
		Node  cur = head;
		int cnt = 0;
		while (cnt < index - 1 &&  cur != null) {
			 cur =  cur.next;
			 cnt++;
		}
		if(cur.next!=null) {
			cur.next = cur.next.next;
		}
	}	
}


class Test{
	public static void main(String[] args) {		
		 MyLinkedList obj = new MyLinkedList(); 
		 int param_1 = obj.get(109);
		 obj.addAtHead(10); 
		 obj.addAtTail(12); 
		 obj.addAtIndex(1,15);
		 obj.deleteAtIndex(2);
	}
}