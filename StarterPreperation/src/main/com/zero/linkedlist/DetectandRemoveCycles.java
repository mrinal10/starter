package com.zero.linkedlist;

public class DetectandRemoveCycles {
    static LLNode head; 

	void removeCycle(LLNode head) {
		if (head == null || head.next == null) {
			return;
		}

		LLNode slow = head.next;
		LLNode fast = head.next.next;

		while (fast != null && fast.next != null && fast != slow) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast == slow) { // loop exists
			fast = head;
		
			while (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}
	
			while (fast.next != slow) {
				fast = fast.next;
			}
			fast.next = null;
		}
		
	}
	// Function to print the linked list 
    void printList(LLNode node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
    
	public static void main(String[] args) {
		DetectandRemoveCycles list = new DetectandRemoveCycles();
		list.head = new LLNode(1);
		list.head.next = new LLNode(2);
		list.head.next.next = new LLNode(3);
		list.head.next.next.next = new LLNode(4);
		list.head.next.next.next.next = new LLNode(5);

		// Creating a loop for testing
		head.next.next.next.next.next = head;
		list.removeCycle(head);
		System.out.println("Linked List after removing loop : ");
		list.printList(head);
	}
}
