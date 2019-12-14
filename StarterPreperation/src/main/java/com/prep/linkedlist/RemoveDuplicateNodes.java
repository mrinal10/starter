package com.prep.linkedlist;

public class RemoveDuplicateNodes {
	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
		if (head==null) {
			return null;
		}
		SinglyLinkedListNode cur = head;
		while(cur!=null) {
			while (cur.next!=null && cur.data == cur.next.data) {
				cur.next = cur.next.next;
			}
			cur = cur.next;
		}
		return head;
	}
}
