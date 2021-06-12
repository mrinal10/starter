package com.geekforgeeks.amazon;

import com.geekforgeeks.microsoft.*;

public class MaxDiffBetweenAncestornChild {

	public static void main(String[] args) {

	}
	
	int maxDiff(Node root) {
		return maxDiffHlpr(root, 0);
	}
	
	int maxDiffHlpr(Node root, int value) {
		if (root==null) {
			return Integer.MAX_VALUE;
		}
		
		if (root.left!=null && root.right!=null) {
			return root.data;
		}
		
		int v = Math.min(maxDiffHlpr(root.left, value), maxDiffHlpr(root.right, value));
		value = Math.max(value, root.data - v); 
		   
        return Math.min(v, root.data); 
	}
}
