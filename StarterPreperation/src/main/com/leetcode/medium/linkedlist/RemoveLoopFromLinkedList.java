package com.leetcode.medium.linkedlist;

public class RemoveLoopFromLinkedList {

	public boolean isLoop(ListNode root) {
		ListNode slow = root;
		ListNode fast = root;

		if (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public ListNode findStartLoop(ListNode root) {
		ListNode slow = root;
		ListNode fast = root;
		boolean isLoop = false;
		if (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				isLoop = true;
			}
		}
		isLoop = false;

		if (isLoop) {
			slow = root;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
	}

	public void removeLoop(ListNode root) {
		ListNode slow = root;
		ListNode fast = root;
		boolean isLoop = false;
		if (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				isLoop = true;
			}
		}
		isLoop = false;

		if (isLoop) {
			slow = root;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
		}

		while (slow.next != null) {
			slow = slow.next;
		}
		slow.next = null;
	}
}
