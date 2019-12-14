package com.prep.tree;

public class LCA {

	public static Node lca(Node root, int v1, int v2) {
		if (root == null) {
			return null;
		}
		int grtr = v1;
		int smlr = v2;
		if (v1 < v2) {
			grtr = v2;
			smlr = v1;
		}
		if (smlr == root.data || grtr == root.data 
					|| (smlr < root.data && grtr > root.data)) {
			return root;
		} else if (smlr < root.data && grtr < root.data) {
			return lca(root.left, smlr, grtr);
		} else {
			return lca(root.right, smlr, grtr);
		}
	}

}