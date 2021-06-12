package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Root_to_leaf_paths {

	public static void main(String[] args) {
	}

	class Solution {
		List<String> allPaths;
	    public List<String> binaryTreePaths(TreeNode root) {
	        allPaths = new ArrayList<>();
	        if(root!=null){
	            binaryTreePathsUtil(root, root.val+"");
	        }
	        return allPaths;
	    }

	    public void binaryTreePathsUtil(TreeNode root, String path) {
	        if (root.left == null && root.right == null) {
	            if (!allPaths.contains(path))
	                allPaths.add(path);
	            return;
	        }
	        if(root.left!=null)
	            binaryTreePathsUtil(root.left, path+"->"+root.left.val);
	        if(root.right!=null)
	            binaryTreePathsUtil(root.right, path+"->"+root.right.val);
	    }
	}
}
