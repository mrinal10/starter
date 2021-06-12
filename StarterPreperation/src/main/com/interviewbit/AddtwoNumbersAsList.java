package com.interviewbit;

public class AddtwoNumbersAsList {
	public ListNode addTwoNumbers(ListNode A, ListNode B) {
		if(A==null){
			return B;
		}
		if(B==null){
			return A;
		}
		ListNode curA = A;
		ListNode curB = B;
		ListNode cur = null;
		ListNode head = null;
		int carry = 0;

		while(curA!=null && curB!=null){
			if(head==null){
				carry = (curA.val+curB.val)%10;
				head = new ListNode(carry);
				cur = head;
				carry = (curA.val+curB.val)/10;
			}else{
				int val = (curA.val+curB.val+carry)%10;
				carry = (curA.val+curB.val+carry)/10;
				cur.next = new ListNode(val);
				cur = cur.next;
			}
			curA =  curA.next;
			curB =  curB.next;
		}
		while(curA!=null){
			int val = (curA.val+carry)%10;
			carry = (curA.val+carry)/10;
			cur.next = new ListNode(val);
			cur = cur.next;
			curA =  curA.next;
		}
		
		while(curB!=null){
			int val = (curB.val+carry)%10;
			carry = (curB.val+carry)/10;
			cur.next = new ListNode(val);
			cur = cur.next;
			curB =  curB.next;
		}
		
		if(carry>0){
			cur.next = new ListNode(carry);
			cur = cur.next;
		}
		return head;
    }
	
	public static void main(String[] args) {
		ListNode st = new ListNode(9);
		ListNode st2 = new ListNode(9);
		st.next = st2;
		ListNode st3 = new ListNode(1);
		st2.next = st3;
		ListNode st4 = new ListNode(1);
//		st3.next = st4;
//		ListNode st5 = new ListNode(5);
//		st4.next = st5;
//		ListNode st6 = new ListNode(7);
//		st5.next = st6;
//		ListNode st7 = new ListNode(8);
//		st6.next = st7;
//		ListNode st8 = new ListNode(9);
//		st7.next = st8;
		AddtwoNumbersAsList palinLL = new AddtwoNumbersAsList();
		ListNode newHd = palinLL.addTwoNumbers(st, st4);
		while (newHd != null) {
			System.out.print(newHd.val + " .. ");
			newHd = newHd.next;
		}
	}
}
