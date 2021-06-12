package com.zero.linkedlist;

public class LinkedList {
	static LLNode head;
	public LinkedList(){
		head = new LLNode(0);
	}
	public static LLNode insertAtEnd(LLNode head, int ned){
		if (head.data == 0) {
			head.data = ned;
		}else{
			LLNode cur = head;
			while(cur.next!=null){
				cur = cur.next;
			}
			LLNode temp = new LLNode(ned);
			cur.next = temp;
		}
		return head;
	}
	public static LLNode createLL() {
		head.data = 0;
		head.next = null;
		return head;
	}

}
