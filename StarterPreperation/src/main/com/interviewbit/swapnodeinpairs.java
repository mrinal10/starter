package com.interviewbit;

public class swapnodeinpairs {
	public ListNode swapNodesinpair(ListNode head) {
		if (head == null || head.next==null) {
			return null;
		}
		ListNode firstHead = head;
		ListNode lastNode = head.next;
		firstHead.next = lastNode.next;
		lastNode.next = firstHead;
		head = lastNode;
		firstHead.next = swapNodesinpair(firstHead.next);
		return head;
	}
	

	public static void main(String[] args) {
		ListNode st = new ListNode(1);
		ListNode st2 = new ListNode(2);
		st.next = st2;
		ListNode st3 = new ListNode(3);
		st2.next = st3;
		ListNode st4 = new ListNode(4);
		st3.next = st4;
		ListNode st5 = new ListNode(5);
		st4.next = st5;
		ListNode st6 = new ListNode(7);
		st5.next = st6;
		ListNode st7 = new ListNode(8);
		st6.next = st7;
		ListNode st8 = new ListNode(9);
		st7.next = st8;
		swapnodeinpairs palinLL = new swapnodeinpairs();
		ListNode newHd = palinLL.swapNodesinpair(st);
		while (newHd != null) {
			System.out.print(newHd.val + " .. ");
			newHd = newHd.next;
		}
	}
}
