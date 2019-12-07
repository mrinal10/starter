package com.prep.dfs;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) {
			return false;
		}		
		int rootvalue = root.val;
        if(sum-rootvalue == 0 && (root.left==null && root.right==null)){
            return true;   
        }
            
		return (
				hasPathSum(root.left, sum-rootvalue)
					|| hasPathSum(root.right, sum-rootvalue));
	}
}
