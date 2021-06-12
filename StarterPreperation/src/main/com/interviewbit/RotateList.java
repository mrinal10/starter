package com.interviewbit;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (k == 0)
			return head;
		ListNode current = head;

		if(k>getLen(head)){
			k = k-((k - getLen(head))%k);
		}
		
		int fromF = getLen(head)-k;
		while(fromF>1){
			current = current.next;
			fromF--;
		}
		
		ListNode temp = current.next;
		current.next = null;
		
		current = temp;
		while (current.next!=null) {
			current = current.next;
		}
		current.next = head;
		return temp;
	}

	public int getLen(ListNode a) {
		int len = 0;
		ListNode cur = a;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		return len;
	}
}
