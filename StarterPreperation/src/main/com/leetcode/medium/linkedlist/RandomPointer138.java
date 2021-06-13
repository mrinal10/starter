package com.leetcode.medium.linkedlist;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class RandomPointer138 {
	public Node copyRandomList(Node head) {
		Node cur = head;
		Node newHead = null;
		while (cur != null) {
			Node newNode = new Node(cur.val);
			newNode.next = cur.next;
			cur.next = newNode;
			newNode.random = cur.random;
			cur = cur.next.next;
		}
		newHead = head.next;
		cur = head;
		Node curN = newHead;
		while (curN != null) {
			if (curN.random != null) {
				curN.random = curN.random.next;
			} else {
				curN.random = null;
			}
			if (curN.next != null) {
				curN = curN.next.next;
			} else {
				curN = null;
			}
		}
		
		cur = head;
		curN = newHead;
		while (curN.next != null) {
			cur.next = cur.next.next;
			cur = cur.next;
			curN.next = curN.next.next;
			curN = curN.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		// [7,null],[13,0],[11,4],[10,2],[1,0]
		Node seven = new Node(7);
		Node thirteen = new Node(13);
		Node eleven = new Node(11);
		Node ten = new Node(10);
		Node one = new Node(1);

		seven.next = thirteen;
		seven.random = null;

		thirteen.next = eleven;
		thirteen.random = seven;

		eleven.next = ten;
		eleven.random = one;

		ten.next = one;
		ten.random = thirteen;

		one.next = null;
		one.random = seven;

		RandomPointer138 newHd = new RandomPointer138();
		newHd.printList(seven);
		newHd.copyRandomList(seven);
	}

	public void printList(Node head) {
		Node cur = head;
		while (cur != null) {
			if(cur.random != null) {
				System.out.println(cur.val + " :<>: " + cur.random.val);
			} else {
				System.out.println(cur.val + " :<>: null");
			}
			cur = cur.next;
		}
		System.out.println("::::::::::::::::::::::::::::::::::::");
	}
}
