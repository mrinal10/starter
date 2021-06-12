package com.zero.tree;

import java.util.*;

class BeingZero {
	TreeMap<Integer, List<Integer>> map;

	void printVerticalTree(BTNode root, int srNo) {
		if (root == null) {
			return;
		}
		if (map.containsKey(srNo)) {
			ArrayList<Integer> ll = (ArrayList<Integer>) map.get(srNo);
			ll.add(root.data);
			map.put(srNo, ll);
		} else {
			ArrayList<Integer> ll = new ArrayList<>();
			ll.add(root.data);
			map.put(srNo, ll);
		}
		printVerticalTree(root.left, srNo - 1);
		printVerticalTree(root.right, srNo + 1);
	}

	void getVerticalOrder(BTNode root) {
		map = new TreeMap<>();

		printVerticalTree(root, 0);
		for (Integer key : map.descendingKeySet()) {
			ArrayList<Integer> list = (ArrayList<Integer>) map.get(key);
			for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
				System.out.print((Integer) iterator.next() + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		BTNode root = new BTNode(1);
		BTNode rootLeft = new BTNode(2);
		BTNode rootRight = new BTNode(3);
		root.left = rootLeft;
		root.right = rootRight;
		BeingZero bx = new BeingZero();
		bx.getVerticalOrder(root);
	}
}
