package com.leetcode.medium.linkedlist;

public class Problem328_variation {

	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		int len = 0;
		ListNode last = head;
		while (last.next != null) {
			len++;
			last = last.next;
		}

		ListNode c1 = head;
		int cnt = 0;
		while (len-- > 0) {
			if (cnt % 2 == 0) {
				last.next = c1.next;
				last = last.next;
				c1.next = c1.next.next;
				last.next = null;
				cnt++;
				len--;
			}
			c1 = c1.next;
			cnt++;
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

		Problem328_variation pr = new Problem328_variation();
		head = pr.oddEvenList(head);
		while (head != null) {
			System.out.print(">>>>" + head.val);
			head = head.next;
		}
	}

}
