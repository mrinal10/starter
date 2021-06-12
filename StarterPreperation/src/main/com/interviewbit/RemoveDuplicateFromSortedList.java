package com.interviewbit;

public class RemoveDuplicateFromSortedList {

	public static void main(String[] args) {
			ListNode st = new ListNode(2);
			ListNode st2 = new ListNode(2);
			st.next = st2;
			ListNode st3 = new ListNode(2);
			st2.next = st3;
//			ListNode st4 = new ListNode(3);
//			st3.next = st4;
//			ListNode st5 = new ListNode(4);
//			st4.next = st5;
			RemoveDuplicateFromSortedList palinLL = new RemoveDuplicateFromSortedList();
			ListNode newHd = palinLL.deleteDuplicates(st);
			while (newHd!=null) {
				System.out.print(newHd.val+" .. ");
				newHd = newHd.next;
			}
	}
	
	public ListNode deleteDuplicates(ListNode A) {
		if(A==null){
			return A;
		}
		
		ListNode newH = new ListNode(A.val);
		ListNode newPtr = A;
		
		ListNode cur = A;

		int prevData = cur.val;
		while(cur.next!=null){
			int curData = cur.next.val;
			if (prevData!=curData) {
				ListNode ll = new ListNode(curData);
				newPtr.next = ll;
				newPtr = newPtr.next;
			}
			prevData = curData;
			cur=cur.next;
		}
		
		return newH;
		
    }

}
