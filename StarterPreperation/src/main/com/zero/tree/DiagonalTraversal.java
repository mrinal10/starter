package com.zero.tree;

import java.util.*;

public class DiagonalTraversal {
	TreeMap<Integer, List<Integer>> map;

	void printDiagonal(BTNode root, int srNo) {
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
		printDiagonal(root.left, srNo - 1);
		printDiagonal(root.right, srNo);
	}

	void diagonalTraversal(BTNode root) {
		map = new TreeMap<>();

		printDiagonal(root, 0);
		for (Integer key : map.descendingKeySet()) {
			ArrayList<Integer> list = (ArrayList<Integer>) map.get(key);
			for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
				System.out.print((Integer) iterator.next() + " ");
			}
			System.out.println();
		}

	}
}
