package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		List<ListNode> allHeads = new ArrayList<ListNode>();
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {

				allHeads.add(lists[i]);
			}
		}
		while (!allHeads.isEmpty()) {
			int leastNumber = Integer.MAX_VALUE;
			int leastIndex = 0;
			System.out.println("allHeads.size() :: " + allHeads.size());
			for (int i = 0; i < allHeads.size(); i++) {
				if (allHeads.get(i) != null && allHeads.get(i).val < leastNumber) {
					leastNumber = allHeads.get(i).val;
					leastIndex = i;
				}
			}
			System.out.println("leastIndex :: " + leastIndex);
			ListNode nextNode = new ListNode(leastNumber);
			cur.next = nextNode;
			cur = cur.next;
			ListNode nextNodeIt = allHeads.get(leastIndex);
			if (nextNodeIt.next == null && allHeads.size() >= leastIndex - 1) {
				allHeads.remove(leastIndex);
			} else if (allHeads.size() >= leastIndex - 1) {
				allHeads.remove(leastIndex);
				allHeads.add(leastIndex, nextNodeIt.next);
			}
		}
		return head.next;
	}

	ListNode swap(ListNode a, ListNode b) {
		ListNode merge = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.val > b.val) {
			merge = b;
			merge.next = swap(a, b.next);
		} else {
			merge = a;
			merge.next = swap(a.next, b);
		}
		return merge;
	}
}
