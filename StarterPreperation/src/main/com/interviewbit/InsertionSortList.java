package com.interviewbit;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode A) {
		ListNode newHead = null;
		ListNode cur = A;
		while(cur!=null){
			int d = cur.val;
			if(newHead == null){
				newHead = new ListNode(d);
			}else{
				ListNode newNode = new ListNode(d);
				if(d<newHead.val){
					newNode.next = newHead;
					newHead = newNode;
				}else{
					boolean isAssigned = false;
					ListNode curNew = newHead;
					while(curNew.next!=null){
						if(curNew.next.val>d){
							newNode.next = curNew.next;
							curNew.next = newNode;
							isAssigned = true;
							break;
						}
						curNew = curNew.next;
					}
					if(!isAssigned){
							curNew.next = newNode;
					}
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
		InsertionSortList palinLL = new InsertionSortList();
		System.out.println(palinLL.insertionSortList(st));
	}
}
