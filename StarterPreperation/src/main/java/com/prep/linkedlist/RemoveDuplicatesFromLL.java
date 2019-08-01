package com.prep.linkedlist;

import java.util.Scanner;

class LinkedListNode{
	int value;
	LinkedListNode next;
	public LinkedListNode(int toAssignValue) {
		value = toAssignValue;
		next = null;
	}
}

class LinkedL{
	LinkedListNode root = null;
	public LinkedL() {
		root = null;
	}
	
	public LinkedL(int value) {
		root = new LinkedListNode(value);
	}
	
	
	public void appendNode(int valueToAppend){
		if (this.root == null) {
			root = new LinkedListNode(valueToAppend);
		}else {
			LinkedListNode cur = this.root;
			while(cur.next!=null) {
				cur = cur.next;
			}
			cur.next = new LinkedListNode(valueToAppend);
		}
	}
	
	public void printLinkedList() {
		LinkedListNode cur = root;
		while(cur!=null) {
			System.out.print(cur.value +"-> ");
			cur = cur.next;
		}
	}
	
	public void sortLinkedList() {
		
	}
	
	private LinkedListNode getMidNode(LinkedListNode head) {
		return null;
	}
	
	public void removeDuplicatesFromLinkedList() {
		
	}
}




class MainClass{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfNodes = sc.nextInt();
		LinkedL ll = new LinkedL();
		while(numberOfNodes-->0) {
			int numberToInsrt = sc.nextInt();
			ll.appendNode(numberToInsrt);
		}
		ll.printLinkedList();
		sc.close();
	}
}