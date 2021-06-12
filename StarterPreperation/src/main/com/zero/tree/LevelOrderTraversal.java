package com.zero.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class BeingZeroBST {
	TreeMap<Integer, List<Integer>> map;

	void printEachLevelOnNewLine(BSTNode root) {
		map = new TreeMap<>();
		populate(root, 0);
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> l = entry.getValue();
			for (Iterator<Integer> iterator = l.iterator(); iterator.hasNext();) {
				System.out.print(iterator.next() + " ");
			}
			System.out.println();
		}
	}

	void populate(BSTNode root, int i) {
		if (root == null) {
			return;
		}
		List<Integer> list = new ArrayList<Integer>();
		if (map.containsKey(i)) {
			list = map.get(i);
			list.add(root.data);
			map.put(i, list);
		} else {
			list.add(root.data);
			map.put(i, list);
		}
		populate(root.left, i + 1);
		populate(root.right, i + 1);
	}
}