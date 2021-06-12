package com.test.dummy;

import java.util.Scanner;

public class AddTwoLinkedList {

	class LLNode {
		int val;
		LLNode next;

		public LLNode(int val) {
			this.val = val;
		}
	}

	void printlist(LLNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}

	LLNode head1, head2, result;
	int carry;

	void push(int val, int list) {
		LLNode newLLNode = new LLNode(val);
		if (list == 1) {
			newLLNode.next = head1;
			head1 = newLLNode;
		} else if (list == 2) {
			newLLNode.next = head2;
			head2 = newLLNode;
		} else {
			newLLNode.next = result;
			result = newLLNode;
		}

	}

	void addsamesize(LLNode n, LLNode m) {
		if (n == null)
			return;

		addsamesize(n.next, m.next);

		int sum = n.val + m.val + carry;
		carry = sum / 10;
		sum = sum % 10;

		push(sum, 3);

	}

	LLNode cur;

	void propogatecarry(LLNode head1) {
		if (head1 != cur) {
			propogatecarry(head1.next);
			int sum = carry + head1.val;
			carry = sum / 10;
			sum %= 10;

			push(sum, 3);
		}
	}

	int getsize(LLNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	void addlists() {
		if (head1 == null) {
			result = head2;
			return;
		}

		if (head2 == null) {
			result = head1;
			return;
		}

		int size1 = getsize(head1);
		int size2 = getsize(head2);

		if (size1 == size2) {
			addsamesize(head1, head2);
		} else {
			if (size1 < size2) {
				LLNode temp = head1;
				head1 = head2;
				head2 = temp;
			}
			int diff = Math.abs(size1 - size2);

			LLNode temp = head1;
			while (diff-- >= 0) {
				cur = temp;
				temp = temp.next;
			}

			addsamesize(cur, head2);

			propogatecarry(head1);
		}
		if (carry > 0)
			push(carry, 3);

	}

	// Driver program to test above functions
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			String s = sc.next();
			String s1 = sc.next();
			AddTwoLinkedList list = new AddTwoLinkedList();
			list.head1 = null;
			list.head2 = null;
			list.result = null;
			list.carry = 0;
			char arr1[] = s.toCharArray();
			char arr2[] = s1.toCharArray();
	
			for (int i = arr1.length - 1; i >= 0; --i)
				list.push(Integer.parseInt(String.valueOf(arr1[i])), 1);
	
			for (int i = arr2.length - 1; i >= 0; --i)
				list.push(Integer.parseInt(String.valueOf(arr2[i])), 2);
	
			list.addlists();
			list.printlist(list.result);
		}
		sc.close();
	}
}
