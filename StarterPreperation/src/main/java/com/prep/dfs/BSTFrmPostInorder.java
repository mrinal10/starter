package com.prep.dfs;

public class BSTFrmPostInorder {
	int inorderIndx = 0;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		inorderIndx = postorder.length - 1;
		return recBuilder(inorder, postorder, 0, inorder.length - 1);
	}

	public TreeNode recBuilder(int[] inorder, int[] postorder, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return null;
		}
		int value = postorder[inorderIndx];
		inorderIndx--;
		TreeNode root = new TreeNode(value);
		if (startIndex == endIndex) {
			return root;
		}
		int inIndx = getIndexInorder(inorder, startIndex, endIndex, value);
		root.left = recBuilder(inorder, postorder, startIndex, inIndx - 1);
		root.right = recBuilder(inorder, postorder, inIndx + 1, endIndex);
		return root;
	}

	private int getIndexInorder(int[] post, int start, int end, int value) {
		for (int i = start; i <= end; i++) {
			if (post[i] == value) {
				return i;
			}
		}
		return -1;
	}
}
