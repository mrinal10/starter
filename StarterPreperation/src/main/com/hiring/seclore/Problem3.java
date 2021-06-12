package com.hiring.seclore;

import java.util.*;

public class Problem3 {
	private static Map<Integer, CustomNode> tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totNodes = sc.nextInt();
		tree = new HashMap<>();
		for (int i = 0; i < totNodes; i++) {
			int value = sc.nextInt();
			CustomNode customNode = new CustomNode(value);
			tree.put(i + 1, customNode);
		}

		for (int i = 0; i < totNodes - 1; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();

			CustomNode parentNode = tree.get(parent);
			List<Integer> allChilds = parentNode.getChilds();
			allChilds.add(child);
			parentNode.setChilds(allChilds);
			tree.put(parent, parentNode);
		}

		int noOfQueries = sc.nextInt();
		for (int i = 0; i < noOfQueries; i++) {
			int typeQuery = sc.nextInt();
			int q1 = sc.nextInt();
			int q2 = sc.nextInt();
			if (typeQuery == 1) { // Modify Value
				CustomNode nodetoBeModified = tree.get(q1);
				nodetoBeModified.setValue(q2);
				tree.put(q1, nodetoBeModified);
			} else { // query Value
				if (findNode(q1, q2))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
		sc.close();
	}

	private static boolean findNode(int parentNode, int childValue) {
		if (!tree.containsKey(parentNode)) {
			return false;
		}
		CustomNode curNode = tree.get(parentNode);
		if (curNode.getValue() == childValue) {
			return true;
		}
		List<Integer> allChilds = curNode.getChilds();
		if (allChilds.isEmpty()) {
			return false;
		}
		boolean res = false;
		for (int i = 0; i < allChilds.size(); i++) {
			int curChild = allChilds.get(i);
			try {
				res = findNode(curChild, childValue);
				if (res) {
					return res;
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return res;
	}
}

class CustomNode {
	private int value;
	private List<Integer> childs;

	public CustomNode(int v) {
		value = v;
		childs = new ArrayList<>();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Integer> getChilds() {
		return childs;
	}

	public void setChilds(List<Integer> childs) {
		this.childs = childs;
	}
}