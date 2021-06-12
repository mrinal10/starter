package com.practice.walmartlabs;

public class IsAMirrorTree {
	boolean areMirror(Node a, Node b) {
		if ((a == null && b != null) || (a != null && b == null)) {
			return false;
		}
		if (a == null && b == null) {
			return true;
		}
		if (a.data != b.data) {
			return false;
		}
		return areMirror(a.left, b.right) && areMirror(a.right, b.left);
	}
}
