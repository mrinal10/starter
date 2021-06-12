package com.zero.tree;

public class HeightOfTree {
	BTNode root;
	
	private int getHeight(BTNode root){
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	public static void main(String[] args) {
		HeightOfTree tree = new HeightOfTree();
		tree.root = new BTNode(1);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(5);
		tree.root.left.right = new BTNode(4);
		tree.root.right.right = new BTNode(6);
		tree.root.right.right.left = new BTNode(7);
		System.out.println(tree.getHeight(tree.root));
	}

}
