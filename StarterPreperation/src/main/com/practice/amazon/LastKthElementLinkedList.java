package com.practice.amazon;

import com.zero.linkedlist.*;
import com.zero.linkedlist.LinkedList;

public class LastKthElementLinkedList {

	public static void main(String[] args) {
		System.out.println(getKthElement(10));
	}

	private static int getKthElement(int k) {
		LinkedList ll = new LinkedList();
		LLNode head = LinkedList.createLL();

		LinkedList.insertAtEnd(head, 1);
		LinkedList.insertAtEnd(head, 2);
		LinkedList.insertAtEnd(head, 3);
		LinkedList.insertAtEnd(head, 4);
		LinkedList.insertAtEnd(head, 5);
		LinkedList.insertAtEnd(head, 6);
		LinkedList.insertAtEnd(head, 7);
		LinkedList.insertAtEnd(head, 8);
		LinkedList.insertAtEnd(head, 9);
		LinkedList.insertAtEnd(head, 10);
		LinkedList.insertAtEnd(head, 11);
		LinkedList.insertAtEnd(head, 12);

		LLNode frontal = head;
		int cnt = 0;
		while (cnt < k && frontal!=null) {
			frontal = frontal.next;
			cnt++;
		}
		if (frontal==null && cnt<k) {
			return -1;
		}
		LLNode cur = head;
		while (frontal != null) {
			frontal = frontal.next;
			cur = cur.next;
		}

		return cur.data;
	}

}
