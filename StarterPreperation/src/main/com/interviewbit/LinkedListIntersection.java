package com.interviewbit;

public class LinkedListIntersection {
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		int lA = getLen(a);
		int lB = getLen(b);
		
		int diff = lA - lB;
		ListNode curB = b;
		ListNode curA = a;
		
		if(diff<0){
			diff = Math.abs(diff);
			while(diff>0){
				curB = curB.next;
				diff--;
			}
			while(curB!=curA){
				curB=curB.next;
				curA = curA.next;
			}
			return curA;
		}
		while(diff>0){
			curA = curA.next;
			diff--;
		}
		while(curB!=curA){
			curB=curB.next;
			curA = curA.next;
		}
		return curA;
    }
	
	
	public int getLen(ListNode a){
		int len = 0;
		ListNode cur = a;
		while(cur!=null){
			len++;
			cur = cur.next;
		}
		return len;
	}
}
