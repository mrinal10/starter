package com.interviewbit;

public class PartitionList {
	public ListNode partition(ListNode A, int B) {
        ListNode newHead = null;
        ListNode cur = A;
        ListNode curList = null;
        //minData
        while(cur!=null){
            if(cur.val<B){
                System.out.println("cur.val : "+cur.val);
                if(newHead == null){
                    newHead = new ListNode(cur.val);
                    curList = newHead;
                }else{
                    curList.next = new ListNode(cur.val);
                    curList = curList.next;
                }
            }
            cur = cur.next;
        }
        //max or equal Data
        cur = A;
        while(cur!=null){
            if(cur.val>=B){
                if(newHead == null){
                    newHead = new ListNode(cur.val);
                    curList = newHead;
                }else{
                    curList.next = new ListNode(cur.val);
                    curList = curList.next;
                }
            }
            cur = cur.next;
        }
        return newHead;
    }
	public static void main(String[] args) {
		ListNode st = new ListNode(1);
		ListNode st2 = new ListNode(4);
		st.next = st2;
		ListNode st3 = new ListNode(3);
		st2.next = st3;
		ListNode st4 = new ListNode(5);
		st4.next = st3;
		ListNode st5 = new ListNode(2);
		st5.next = st4;
		PartitionList palinLL = new PartitionList();
		System.out.println(palinLL.partition(st, 3));
	}
}
