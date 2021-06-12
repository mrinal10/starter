package com.zero.tree;

public class LowestCommonAncestor {
	BTNode root;
	BTNode lcaUtil(BTNode root, int a, int b) {
		if (root == null) {
			return null;
		}
		if (root.data == a || root.data == b) {
			return root;
		}
		BTNode leftNode = lcaUtil(root.left, a, b);
		BTNode rightNode = lcaUtil(root.right, a, b);
		if (leftNode == null && rightNode == null) {
			return null;
		}
		if (leftNode != null && rightNode != null) {
			return root;
		}
		return leftNode != null ? leftNode : rightNode;
	}

	boolean findNode(BTNode root, int a) {
		if (root == null) {
			return false;
		}
		if (root.data == a) {
			return true;
		}
		return findNode(root.left, a) || findNode(root.right, a);
	}

	BTNode lca(BTNode root, int a, int b) {
		if (findNode(root, a) && findNode(root, b)) {
			return lcaUtil(root, a, b);
		}
		return null;
	}
	BTNode lca(int a, int b) {
		return lca(root, a, b);
	}
	public static void main(String[] args) {
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = new BTNode(1);
		tree.root.left = new BTNode(2);
		tree.root.right = new BTNode(3);
		tree.root.left.left = new BTNode(5);
		tree.root.left.right = new BTNode(4);
		tree.root.right.right = new BTNode(6);
		tree.root.right.right.left = new BTNode(7);
		BTNode res = tree.lca(5, 2);
		if(res!=null)
			System.out.println(res.data);
		else
			System.out.println("null");
	}

}
