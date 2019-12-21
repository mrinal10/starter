package com.prep.linkedlist;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class RemoveNthLast {
	public static void main(String[] args) {

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int  l = getLen(head);
		int k = l-n;
        if(k==0){
            return head.next;
        }
		if (k<0) {
			return null;
		}
		ListNode cur = head;
		while(k>1) {
            k--;
			cur = cur.next;
		}
        if(cur.next!=null)
		    cur.next = cur.next.next;
		return head;
	}
	
	private int getLen(ListNode head) {
		if(head==null) {
			return 0;
		}
		return 1+getLen(head.next);
	}
}
