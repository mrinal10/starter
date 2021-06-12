package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;
import com.leetcode.BFSElement;
import com.leetcode.TreeNode;

public class MinimumDepth {
	public int minDepth(TreeNode root) {
		if (root==null) {
			return 0;
		}
		Queue<BFSElement> queue = new LinkedList<>();
		queue.add(new BFSElement(1, root));
		int maxLevel = 0;
		while (!queue.isEmpty()) {
			BFSElement bfsElement = queue.poll();
			TreeNode node = bfsElement.treeNode;
			if (maxLevel<bfsElement.level) {
				maxLevel = bfsElement.level;
			}
			if (node.left==null && node.right==null) {
				return bfsElement.level;
			}
			if (node.left!=null) {
				queue.add(new BFSElement(bfsElement.level+1, node.left));
			}
			if (node.right!=null) {
				queue.add(new BFSElement(bfsElement.level+1, node.right));
			}
		}
		return maxLevel;
    }
}
