package com.leetcode.bfs;

import java.util.List;

public class MaximumDepthNAryTree {
	public int maxDepth(Node root) {
		if (root == null)
			return 0;
		
		int maxDepth = 1;
		List<Node> children = root.children;
		for (int i = 0; i < children.size(); i++) {
			int depth = 1+maxDepth(children.get(i));
			if (depth>maxDepth) {
				maxDepth = depth;
			}
		}
		return maxDepth;
	}
}
