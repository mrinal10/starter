package com.prep.linkedlist;

public class InsertNodeAtSpecificPosition {
	static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
		int cnt = 0;
		SinglyLinkedListNode cur = head;
		while (cnt != position - 1) {
			cur = cur.next;
			cnt++;
		}
		SinglyLinkedListNode temp = cur.next;
		cur.next = new SinglyLinkedListNode(data);
		cur.next.next = temp;
		return head;
	}

	static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
		return null;
	}

}
