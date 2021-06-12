package com.geekforgeeks.microsoft;

public class MirrorTree {

	public static void main(String[] args) {

	}

	void mirror(Node node) {
		if (node==null) {
			return;
		}
		if (node.left!=null && node.right!=null) {
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}else if(node.left!=null){
			node.right = node.left;
			node.left = null;
		}else if(node.right!=null){
			node.left = node.right;
			node.right = null;
		}
		
		mirror(node.left);
		mirror(node.right);
	}

}
