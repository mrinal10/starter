package com.practice.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.prep.bfs.TreeNode;

public class LeftViewBinaryTree {
	static Map<Integer, Integer> map;
	public static void leftView(TreeNode root) {
		map = new HashMap<Integer, Integer>();
		preorderTraversal(root, 0);
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
	
	private static void preorderTraversal(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if(!map.containsKey(level))
			map.put(level, root.val);
		preorderTraversal(root.left, level+1);
		preorderTraversal(root.right, level+1);
	}
}
