package com.leetcode;

public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int i = 0;
		ListNode cur = head;
		ListNode prev = head;
		while (i < n && cur.next != null) {
			prev = cur;
			cur = cur.next;
			i++;
		}
		if (i == n - 1) {
			if (head == cur) {
				head = null;
			} else  {
				prev.next = null;
			}
		} else if (i == n) {
			ListNode h = head;
			while (cur.next != null) {
				h = h.next;
				cur = cur.next;
			}
			h.next = h.next.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode h = new ListNode(1);
		h.next = new ListNode(2);
		// h.next.next = new ListNode(3);
		// h.next.next.next = new ListNode(4);
		// h.next.next.next.next = new ListNode(5);
		//
		RemoveNthNodeFromEndofList remov = new RemoveNthNodeFromEndofList();
		// remov.removeNthFromEnd(h, 2);
		ListNode n = remov.removeNthFromEnd(h, 2);
		while (n != null) {
			System.out.print(n.val + " -> ");
			n = n.next;
		}
	}

}
