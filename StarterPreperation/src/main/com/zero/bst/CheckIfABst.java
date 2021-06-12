package com.zero.bst;

public class CheckIfABst {

	public static void main(String[] args) {
		BSTNode root = CreateBinaryTree.create();
		System.out.println(isBST(root));
	}
	
	private static boolean isBST(BSTNode root){
		if (root==null) {
			return true;
		}
		if(root.left != null){
			if(root.left.data<=root.data)
				return isBST(root.left);
			else
				return false;
		}
		
		if(root.right != null){
			if(root.right.data>=root.data)
				return isBST(root.right);
			else
				return false;
		}
		return true;
	}

}
