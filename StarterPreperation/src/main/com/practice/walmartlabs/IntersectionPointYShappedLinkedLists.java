package com.practice.walmartlabs;

class NodeL {
	int data;
	NodeL next;

	NodeL(int d) {
		data = d;
		next = null;
	}
}

public class IntersectionPointYShappedLinkedLists {

	public int intersectPoint(NodeL headA, NodeL headB) {
		int lenA = 0;
		int lenB = 0;

		NodeL hA = headA;
		NodeL hB = headB;

		while (hA != null) {
			hA = hA.next;
			lenA++;
		}

		while (hB != null) {
			hB = hB.next;
			lenB++;
		}

		hA = headA;
		hB = headB;
		int diff = Math.abs(lenB - lenA);
		if (lenA < lenB) {
			while (diff > 0) {
				hB = hB.next;
				diff--;
			}
		} else if (lenA > lenB) {
			while (diff > 0) {
				hA = hA.next;
				diff--;
			}
		}

		while (hA != hB) {
			hA = hA.next;
			hB = hB.next;
		}
		if (hA == hB) {
			return hA.data;
		}
		return -1;
	}

	public static void main(String[] args) {

	}
}
