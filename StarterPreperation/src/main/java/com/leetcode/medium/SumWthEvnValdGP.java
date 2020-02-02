package com.leetcode.medium;

import com.prep.bfs.TreeNode;

//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

public class SumWthEvnValdGP {
	public int sumEvenGrandparent(TreeNode root) {
		return (sumOfGrandChildren(0, root.left, false) 
			  + sumOfGrandChildren(0, root.right, false)
			  + sumOfGrandChildren(0, root, false) );
	}

	private int sumOfGrandChildren(int grandPVal, TreeNode root, boolean isConsider) {
		if (root == null)
			return 0;
		int curValue = root.val;
		int value = 0;
		if (grandPVal % 2 == 0 && isConsider) {
			value = curValue;
		}
		int lValue = 0;
		int rValue = 0;
		
		if(root.left!=null) {
			lValue = sumOfGrandChildren(curValue, root.left.left, true)
							+ sumOfGrandChildren(curValue, root.left.right, true);
		}
		if(root.right!=null) {
			rValue = sumOfGrandChildren(curValue, root.right.left, true) 
							+ sumOfGrandChildren(curValue, root.right.right, true);
		}
		value = value + rValue + lValue;		
		return value;
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(7);
		root.right = new TreeNode(8);
		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);
		
		root.left.left.left  =new TreeNode(9);
		root.left.right.left  =new TreeNode(1);
		root.left.right.right  =new TreeNode(4);
		root.right.right.right  =new TreeNode(5);
		
		SumWthEvnValdGP sss = new SumWthEvnValdGP();
		System.out.println(sss.sumEvenGrandparent(root));
	}

}
