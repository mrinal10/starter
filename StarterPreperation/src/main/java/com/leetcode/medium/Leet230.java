package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import com.prep.bfs.TreeNode;

public class Leet230 {
	List<Integer> listInt;
	public void init1(TreeNode root) {
		listInt = new ArrayList<Integer>();
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
    
    public int kthSmallest(TreeNode root, int k) {
        init1(root);
        return listInt.get(k-1);
    }
}
