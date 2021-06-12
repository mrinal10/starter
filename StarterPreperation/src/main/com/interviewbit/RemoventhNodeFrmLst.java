package com.interviewbit;

public class RemoventhNodeFrmLst {
	public ListNode removeNthFromEnd(ListNode A, int B) {
		int len = getLen(A);
		if(len==1 && B==1){
			return null;
		}
		if (B <= len) {
			int fromFirst = len - B;
			int indx = 0;
			ListNode cur = A;
			while(indx<fromFirst-1){
				cur = cur.next;
				indx++;
			}
			cur.next = cur.next.next;
		}else{
			A = A.next;
		}
		return A;
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
