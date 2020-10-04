package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.prep.bfs.TreeNode;

class BSTIterator {	
    List<Integer> listInt;
    int curVal ;
	public BSTIterator(TreeNode root) {
		listInt = new ArrayList<Integer>();
    	curVal = Integer.MIN_VALUE;
    	init(root);
    }
    
    private void init(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	
    	if(root.left!=null) {
    		init(root.left);
    	}
    	
    	listInt.add(root.val);
    	
    	if(root.right!=null) {
    		init(root.right);
    	}
    }
    
    public int next() {
    	for(int i=0; i<listInt.size(); i++) {
    		if (curVal<listInt.get(i)) {
				curVal = listInt.get(i);
				return curVal;
			}
    	}
    	return -1;
    }
    
    public boolean hasNext() {
    	for(int i=0; i<listInt.size(); i++) {
    		if (curVal<listInt.get(i)) {
				return true;
			}
    	}
    	return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */