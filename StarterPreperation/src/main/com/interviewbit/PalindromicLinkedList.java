package com.interviewbit;

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class PalindromicLinkedList {

	public int lPalin(ListNode A) {
		ListNode reversed = reverseList(A);

		ListNode cur = A;
		ListNode cur2 = reversed;
		while (cur.next != null) {
			if (cur.val != cur2.val) {
				return 1;
			}
			cur = cur.next;
			cur2 = cur2.next;
		}
		return 0;
	}

	public ListNode reverseList(ListNode head) {
		ListNode cur = head;
		ListNode newHead = null;
		while (cur != null) {
			ListNode ll = new ListNode(cur.val);
			ll.next = newHead;
			newHead = ll;
			cur=cur.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		ListNode st = new ListNode(1);
		ListNode st2 = new ListNode(2);
		st.next = st2;
		ListNode st3 = new ListNode(1);
		st2.next = st3;
//		ListNode st4 = new ListNode(4);
//		st4.next = st3;
//		ListNode st5 = new ListNode(5);
//		st5.next = st4;
		PalindromicLinkedList palinLL = new PalindromicLinkedList();
		System.out.println(palinLL.lPalin(st));
	}
	
}
