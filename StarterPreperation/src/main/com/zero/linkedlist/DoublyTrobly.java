package com.zero.linkedlist;

public class DoublyTrobly {

	DLLNode clone(DLLNode h) {
		if (h == null) {
			return h;
		}
		DLLNode cur = new DLLNode(h.data);
		cur.d = h.d;
		cur.t = h.t;
		DLLNode newHead = new DLLNode(cur.data);
		newHead.t = cur.t;
		newHead.d = null;
		DLLNode newCur = newHead;
		
		cur = cur.d;
		while (cur!=null) {
			DLLNode temp = new DLLNode(cur.data);
			newCur.d = temp;
			newCur = newCur.d;
			cur = cur.d;
		}
		
		newCur = newHead;
		cur = h;
		while (cur!=null) {
			DLLNode temp = new DLLNode(cur.data);
			newCur.d = temp;
			if (cur.t!=null) {
				newCur.t = findNode(cur.t.data, newHead);
			}
			newCur = newCur.d;
			cur = cur.d;
		}
		
		return newHead;
	}

	private static DLLNode findNode(int value, DLLNode head){
		DLLNode cur = head;
		while (cur!=null) {
			if (cur.data == value) {
				return cur;
			}
			cur = cur.d;
		}
		return null;
	}
	
	public static void main(String[] args) {

	}

}
