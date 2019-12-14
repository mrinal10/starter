package com.prep.linkedlist;

public class MergePointLists {
	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		int len1 = getLength(head1);
		int len2 = getLength(head2);

		SinglyLinkedListNode temp1 = head1;
		SinglyLinkedListNode temp2 = head2;
		int d = 0;
		if (len1 > len2) {
			d = len1 - len2;
			while (d > 0) {
				temp1 = temp1.next;
				d--;
			}
		} else {
			d = len2 - len1;
			while (d > 0) {
				temp2 = temp2.next;
				d--;
			}
		}

		while (temp1 != null || temp2 != null) {
			temp1 = temp1.next;
			temp2 = temp2.next;
			if (temp1 == temp2) {
				return temp1.data;
			}
		}
		return -1;
	}

	static int getLength(SinglyLinkedListNode head) {
		int l = 0;
		SinglyLinkedListNode hd = head;
		while (hd != null) {
			hd = hd.next;
			l++;
		}
		return l;
	}
}
