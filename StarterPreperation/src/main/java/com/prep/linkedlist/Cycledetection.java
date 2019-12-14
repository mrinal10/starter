package com.prep.linkedlist;

public class Cycledetection {
	static boolean hasCycle(SinglyLinkedListNode head) {
		SinglyLinkedListNode hare = head;
		SinglyLinkedListNode tortoise = head;
		
		while(hare.next!=null && hare.next.next!=null) {
			hare = hare.next.next;
			tortoise = tortoise.next;
			if (hare==tortoise) {
				return true;
			}
		}
		return false;
	}
}
