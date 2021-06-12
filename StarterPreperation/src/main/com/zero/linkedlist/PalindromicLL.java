package com.zero.linkedlist;

import java.util.Scanner;

class PalindromicLL {

	static LLNode findMiddleNode(LLNode h) {
		LLNode s = h;
		LLNode f = h;
		while (f != null && f.next != null) {
			f = f.next.next;
			if (f == null) {
				return s;
			}
			s = s.next;
		}
		return s;
	}

	static LLNode reverse(LLNode A) {
		LLNode cur, prev, next;
		prev = null;
		cur = A;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	

	static boolean isPalindromicList(LLNode A) {
		if (A == null) {
			return true;
		}
//		LLNode m = findMiddleNode(A);
		
		LLNode s = reverse(A);
		while (s != null && A != null) {
			if (s.data != A.data) {
				return false;
			}
			s = s.next;
			A = A.next;
		}
		return true;
	}
	
	private static void printLnkdlst(LLNode head){
		while (head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while ( t-->0 ) {
			int n = sc.nextInt();
			LLNode head = null;
			LLNode cur = null;
			for (int i = 0; i < n; i++) {
				int temp = sc.nextInt();
				if (i==0) {
					head = new LLNode(temp);
					cur = head;
				}else{
					LLNode ll = new LLNode(temp);
					cur.next = ll;
					cur = cur.next;
				}
			}
			System.out.println(isPalindromicList(head));
		}
		sc.close();
//		printLnkdlst(L1);
//		LLNode reversed = reverse(L1);
//		System.out.println();
//		printLnkdlst(reversed);
		
//		System.out.println(isPalindromicList(L1));
	}

}
