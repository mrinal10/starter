package com.standalone.practice.binarytree;

public class MirrorOfTree {
	static Node mirrorify(Node root) {
		if(root == null) {
			return null;
		}
		
		Node mirror = new Node(root.data);
		mirror.right = mirrorify(root.left);
		mirror.left = mirrorify(root.right);
		
		return mirror;
	}
}
