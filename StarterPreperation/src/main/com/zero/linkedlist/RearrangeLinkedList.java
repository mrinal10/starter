package com.zero.linkedlist;

import java.util.Scanner;

public class RearrangeLinkedList {

	static void frontLastRearrange(LLNode head)
	{
		LLNode rev = reverse(head);
		LLNode l3 = mergeLinkedLists(head, rev);
		printList(l3);
	}
	
	static void printList(LLNode l){
		while ( l!=null) {
			System.out.print(l.data+" ");
			
		}
	}
	
	static LLNode reverse(LLNode A) {
		LLNode cur, prev, next;
		prev = null;
		cur = A;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	static LLNode mergeLinkedLists(LLNode l1, LLNode l2){
		LLNode head = null;
		LLNode cur = l1;
		while (cur!=null) {
			if (head==null) {
				head = new LLNode(l1.data);
				cur = head;
				head.next = l2;
				head = head.next;
				head.next = null;
			}else{
				head.next = l1;
				head = head.next;
				head.next = l2;
				head = head.next;
				head.next = null;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return cur;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while ( t-->0 ) {
			int n = sc.nextInt();
			LLNode head = null;
			LLNode cur = null;
			for (int i = 0; i < n; i++) {
				int temp = sc.nextInt();
				if (i==0) {
					head = new LLNode(temp);
					cur = head;
				}else{
					LLNode ll = new LLNode(temp);
					cur.next = ll;
					cur = cur.next;
				}
			}
			frontLastRearrange(head);
		}
		sc.close();
	}
}
