package com.standalone.practice.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LeftView {
	ArrayList<Integer> li;
	Set<Integer> visitedLevels;
	ArrayList<Integer> leftView(Node root) {
		li = new ArrayList<>();
		visitedLevels = new HashSet<Integer>();
		leftViewHelper(root, 0);
		return li;
	}
	
	void leftViewHelper(Node root, int level) {
		if(root==null) {
			return;
		}
		if(!visitedLevels.contains(level)) {
			visitedLevels.add(level);
			li.add(root.data);
		}
		leftViewHelper(root.left, level+1);
		leftViewHelper(root.right, level+1);
	}
}
