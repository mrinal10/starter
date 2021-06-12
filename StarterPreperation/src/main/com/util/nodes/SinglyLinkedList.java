package com.util.nodes;


public class SinglyLinkedList<T> {
	SinglyLinkedNode<T> head = null;
	
	public void appendNode(T data){
		try {
			SinglyLinkedNode<T> sNode = new SinglyLinkedNode<>();
			sNode.setData(data);
			
			if (head == null) {
				head = sNode;
			} else {
				SinglyLinkedNode<T> sCurr = head;
				while (sCurr.getNext()!=null) {
					sCurr = sCurr.getNext();
				}
				sCurr.setNext(sNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prependNode(T data){
		SinglyLinkedNode<T> sNode = new SinglyLinkedNode<>();
		sNode.setData(data);
		
		if (head == null) {
			head = sNode;
		} else {
			sNode.setNext(head);
			head = sNode;
		}
	}

	public void printList(){
		SinglyLinkedNode<T> curNode = head;
		while (curNode!=null) {
			System.out.print(curNode.getData().toString());
			if (curNode.getNext()!=null) {
				System.out.print(" -> ");
			}
			curNode = curNode.getNext();
		}
		System.out.println();
	}
	
	public static void traverseList(SinglyLinkedNode<Integer> headNode) {
		while (headNode.getNext()!=null) {
			System.out.println(headNode.getData()+" -> ");
		}
	}
}
