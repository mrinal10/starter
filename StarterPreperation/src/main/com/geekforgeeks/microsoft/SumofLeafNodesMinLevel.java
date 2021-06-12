package com.geekforgeeks.microsoft;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SumofLeafNodesMinLevel {

	static Map<Integer, Integer> map;

	public static void main(String[] args) {
		
		map = new HashMap<>();
		TreeNode node = new TreeNode(10);
		TreeNode node1 = new TreeNode(20);
		TreeNode node2 = new TreeNode(30);
		node.leftChild = node1;
		node.rightChild = node2;
		TreeNode node3 = new TreeNode(40);
		TreeNode node4 = new TreeNode(60);
		node1.leftChild = node3;
		node1.rightChild = node4;
		TreeNode node5 = new TreeNode(90);
		node2.leftChild = node5;
		
		getHighestLeafSum(node, 0);

		int minValue = Integer.MAX_VALUE;
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> it = keySet.iterator();

		while (it.hasNext()) {
			int curV = it.next();
			if (curV < minValue) {
				minValue = curV;
			}
		}
		System.out.println(map.get(minValue));
	}

	private static void getHighestLeafSum(TreeNode root, int level) {
		System.out.println(root.data+" :: "+level);
		if (root.leftChild == null && root.rightChild == null) {
			
			int sumV = 0;
			if (map.containsKey(level)) {
				sumV = map.get(level);
			}
			sumV += root.data;
			map.put(level, sumV);
		} else {
			if (root.leftChild != null) {
				getHighestLeafSum(root.leftChild, level + 1);
			} 
			if (root.rightChild != null) {
				getHighestLeafSum(root.rightChild, level + 1);
			}
		}
	}

}
