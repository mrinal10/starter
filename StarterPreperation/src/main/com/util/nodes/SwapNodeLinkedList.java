package com.util.nodes;

import java.util.Scanner;



public class SwapNodeLinkedList {

	public static void main(String[] args) throws InterruptedException {
		SinglyLinkedList<Integer> linkedList = createaDummy();

		SinglyLinkedNode<Integer> hNode = reverse(linkedList);
		SinglyLinkedList.traverseList(hNode);
	}
	
	
	
	private static SinglyLinkedNode<Integer> reverse(SinglyLinkedList<Integer> linkedList) 
						throws InterruptedException {
		
		SinglyLinkedNode<Integer> headNode = linkedList.head;
		
		int linkedListLength = 0;
		while(headNode.getNext()!=null) {
			linkedListLength++;
		}
		
		SinglyLinkedList<Integer> linkedListTemp = new SinglyLinkedList<Integer>();
		
		for (int i = 0; i!=1 && i < linkedListLength; i++) {
			SinglyLinkedNode<Integer> tempNode = null;
			while(headNode.getNext().getNext() != null) {
				tempNode = headNode.getNext().getNext();
				headNode.getNext().setNext(null);
				System.out.println("tempNode.getData() >>> "+tempNode.getData());
				linkedListTemp.appendNode(tempNode.getData());
			}
		}
		linkedListTemp.appendNode(headNode.getData());
		headNode = linkedListTemp.head;
		
		return headNode;
	}
		
	public static void swap(SinglyLinkedList<Integer> linkedList) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter Key 1 : ");
		int key1 = sc.nextInt();
		System.out.println("Enter Key 2 : ");
		int key2 = sc.nextInt();
		swapNode(key1, key2, linkedList);
		sc.close();
	}
	
	private static void swapNode(int key1, int key2, SinglyLinkedList<Integer> linkedList){
		if (key1 != key2) {
			SinglyLinkedNode<Integer> headOfList = linkedList.head;
			
			SinglyLinkedNode<Integer> currX = new SinglyLinkedNode<Integer>();
			currX = linkedList.head;
			SinglyLinkedNode<Integer> prevX = new SinglyLinkedNode<Integer>();
			
			try {
				while (currX!=null || currX.getData().intValue()!= key1) {
					System.out.println(headOfList.getData()+" :::::  "+currX.getData());
					prevX = currX;
					currX = currX.getNext();
				}
				SinglyLinkedNode<Integer> currY = headOfList;
				SinglyLinkedNode<Integer> prevY = null;
				while (currY!=null || currY.getData()!= key2) {
					prevY = currY;
					currY = currY.getNext();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		linkedList.printList();
	}
	
	public static SinglyLinkedList<Integer> createaDummy(){
		SinglyLinkedList<Integer> sList = new SinglyLinkedList<Integer>();
		int[] ra = {18,7,90,34,11,12,23,45,43,8};
		for (int i = 0; i < ra.length;i++){//n; i++) {
			int keyValue = ra[i];
			sList.appendNode(keyValue);
		}
		sList.printList();
		return sList;
	}

	
}
