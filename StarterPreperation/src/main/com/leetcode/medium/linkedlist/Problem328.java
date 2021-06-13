package com.leetcode.medium.linkedlist;

public class Problem328 {

	public ListNode oddEvenList(ListNode head) {
		int len = 0;
		ListNode last = head;
		while (last.next != null) {
			len++;
			last = last.next;
		}

		ListNode c1 = head;
		while (len-- > 0) {
			if (c1 == head && c1.val % 2 == 0) {
				last.next = c1;
				head = head.next;
				c1.next = null;
				last = last.next;
				c1 = head;
				c1 = c1.next;
			} else if (c1.next != null && c1.next.val % 2 == 0) {
				System.out.println("c1 :: val >" + c1.val);
				ListNode nxt = c1.next;
				last.next = nxt;
				last = last.next;
				c1.next = c1.next.next;
				last.next = null;
				len -= 1;				
			} else {
				c1 = c1.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {

		ListNode listNode5 = new ListNode(7, null);
		ListNode listNode4 = new ListNode(4, listNode5);
		ListNode listNode3 = new ListNode(6, listNode4);
		ListNode listNode2 = new ListNode(5, listNode3);
		ListNode listNode7 = new ListNode(3, listNode2);
		ListNode listNode8 = new ListNode(1, listNode7);
		ListNode head = new ListNode(2, listNode8);

		Problem328 pr = new Problem328();
		head = pr.oddEvenList(head);
		while (head != null) {
			System.out.print(">>>>" + head.val);
			head = head.next;
		}
	}

}
