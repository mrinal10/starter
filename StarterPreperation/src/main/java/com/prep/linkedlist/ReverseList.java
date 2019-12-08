package com.prep.linkedlist;

public class ReverseList {
	public static LinkedListNode reverseList(LinkedListNode head) {
		LinkedListNode prev = null;
		LinkedListNode next = null;
		LinkedListNode cur = head;
		while(cur!=null) {
			prev = cur;
			cur = cur.next;
			prev.next = next;
			next = prev;
		}		
		return prev;
	}
	
	public static void main(String[] args) {
		int n=6;
		LinkedListNode root = new LinkedListNode(0);
		LinkedListNode cur = root;
		for(int i=1; i<n; i++) {
			LinkedListNode temp = new LinkedListNode(i);
			cur.next = temp;
			cur = cur.next;
		}
		print(root);
		System.out.println();
		root = reverseList(root);
		print(root);
	}
	
	private static void print(LinkedListNode root) {
		LinkedListNode cur = root;
		while(cur!=null) {
			System.out.print(cur.value+" --> ");
			cur = cur.next;
		}
	}
}
