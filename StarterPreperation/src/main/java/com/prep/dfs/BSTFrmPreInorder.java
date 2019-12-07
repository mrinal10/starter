package com.prep.dfs;

public class BSTFrmPreInorder {
	int preOrderIndex = 0;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return recBuilder(preorder, inorder, 0, preorder.length-1);
	}
	
	private TreeNode recBuilder(int[] pre, int[] in, int start, int end) {
		if (start > end) 
            return null; 
		int nodeValue = pre[preOrderIndex];
		preOrderIndex++;
		TreeNode root = new TreeNode(nodeValue);
		if (start == end) {
			return root;
		}
		int inOrderIndex = getIndexOfValue(in, start, end, nodeValue);
		root.left = recBuilder(pre, in, start, inOrderIndex-1);
		root.right = recBuilder(pre, in, inOrderIndex+1, end);
		return root;
	}
	
	private int getIndexOfValue(int[] arr, int start, int end, int value) {
		for(int i=start; i<=end; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

}
