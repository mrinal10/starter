package com.interviewbit;

public class MergeSortedLists {
	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		if (B == null) {
			return A;
		}

		if (A == null) {
			return B;
		}

		ListNode curA = A;
		ListNode curB = B;
		ListNode newHd = null;
		ListNode cur = null;
		ListNode newPtr = null;

		while (curA != null && curB != null) {
			if (curA.val <= curB.val) {
				if (newHd == null) {
					newHd = new ListNode(curA.val);
					newPtr = newHd;
				} else {
					cur = new ListNode(curA.val);
					newPtr.next = cur;
					newPtr = newPtr.next;
				}
				curA = curA.next;
			} else {
				if (newHd == null) {
					newHd = new ListNode(curB.val);
					newPtr = newHd;
				} else {
					cur = new ListNode(curB.val);
					newPtr.next = cur;
					newPtr = newPtr.next;
				}
				curB = curB.next;
			}
		}

		while (curA != null) {
			cur = new ListNode(curA.val);
			newPtr.next = cur;
			newPtr = newPtr.next;

			curA = curA.next;
		}

		while (curB != null) {
			cur = new ListNode(curB.val);
			newPtr.next = cur;
			newPtr = newPtr.next;

			curB = curB.next;
		}

		return newHd;
	}
}
