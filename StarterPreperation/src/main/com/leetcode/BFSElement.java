package com.leetcode;

import com.leetcode.TreeNode;

public class BFSElement {
	public int level;
	public TreeNode treeNode;
	public BFSElement(int lvl, TreeNode node) {
		treeNode = node;
		level = lvl;
	}
}
