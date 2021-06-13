package com.leetcode.medium.linkedlist;

public class ReverseLinkedlist {
	public ListNode reverseList(ListNode head) {
		ListNode next = null;
		ListNode prev = null;
		ListNode cur = head;
		
		while(cur!=null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}
