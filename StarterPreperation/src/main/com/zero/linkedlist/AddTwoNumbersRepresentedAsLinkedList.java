package com.zero.linkedlist;

import java.util.Scanner;


class LinkedListM{
	LLNode head;
	
	LinkedListM(int n){
		head = null;
		while(n!=0){
			int rem = n%10;
			if(head == null){
				head = new LLNode(rem);
			}else{
				head = addNodeToStart(head, rem);
			}
			n = n/10;
		}
	}
	
	private static LLNode addNodeToStart(LLNode head, int n){
		LLNode newNode = new LLNode(n);
		newNode.next = head;
		head = newNode;
		return head;
	}
	
	public static int getLength(LLNode head){
		int count = 0;
		LLNode cur = head;
		while(cur!=null){
			count++;
			cur = cur.next;
		}
		return count;
	}
}

public class AddTwoNumbersRepresentedAsLinkedList {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-->0){
			int number1 = sc.nextInt();
			int number2 = sc.nextInt();
			
			LinkedListM first = new LinkedListM(number1);
			LinkedListM second = new LinkedListM(number2);
			
			LLNode head1 = first.head;
			LLNode head2 = second.head;
			
			int number = number1+number2;
			LinkedListM ans  = new LinkedListM(number);
			
			LLNode cur = ans.head;
			while (cur!=null) {
				System.out.print(cur.data+"->");
				cur = cur.next;
			}
		}
		sc.close();
	}

}
