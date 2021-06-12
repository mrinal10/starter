package com.practice.walmartlabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.leetcode.ListNode;

public class LinkedListInterSection {
	private ListNode findIntersection(ListNode head1, ListNode head2){
		if (head1== null || head2==null) {
			return null;
		}
		
		Set<Integer> setOfInti = new HashSet<>();
		ListNode cur = head1;
		while (cur!=null) {
			setOfInti.add(cur.val);
			cur = cur.next;
		}
		Set<Integer> setOfInti2 = new HashSet<>();
		cur = head2;
		while (cur!=null) {
			setOfInti2.add(cur.val);
			cur = cur.next;
		}
		
		for (Iterator<Integer> iterator = setOfInti2.iterator(); iterator.hasNext();) {
			Integer curVal = (Integer) iterator.next();
			setOfInti.add(curVal);
		}
		
		return createList(setOfInti);
	}
	
	private ListNode createList(Set<Integer> values){
		ArrayList<Integer> aList = new ArrayList<>();
		if (aList.isEmpty()) {
			return null;
		}
		for (Integer x : values) 
		      aList.add(x);
		Collections.sort(aList);
		ListNode head = new ListNode(aList.get(0));
		ListNode current = head;
		for (int i = 1; i < aList.size(); i++) {
			ListNode cur = new ListNode(aList.get(i));
			current.next = cur;
		}
		return head;
	}
	
	public static void main(String[] args) {
		LinkedListInterSection intrsctn = new LinkedListInterSection();
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		intrsctn.findIntersection(head1, head2);
	}
}
