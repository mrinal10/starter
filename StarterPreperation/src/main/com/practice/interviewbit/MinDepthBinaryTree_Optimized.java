package com.practice.interviewbit;

import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;

import com.zero.linkedlist.LinkedList;

class Qitem {
	TreeNode node;
	int depth;

	Qitem(TreeNode nd, int dpt) {
		dpt = depth;
		node = nd;
	}
}

public class MinDepthBinaryTree_Optimized {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		Queue<Qitem> q = (Queue<Qitem>) new LinkedList();
		q.add(new Qitem(root, 1));
		while (!q.isEmpty()) {
			Qitem qi = q.poll();

			TreeNode nde = qi.node;
			int depth = qi.depth;

			if (nde.left != null) {
				q.add(new Qitem(nde.left, depth+1));
			}
			if (nde.right != null) {
				q.add(new Qitem(nde.right, depth+1));
			}
			return depth;			
		}
		return 0;
	}


	public int[][] verticalOrderTraversal(TreeNode root) {
		TreeMap<Integer,Vector<Integer>> m = new TreeMap<>(); 
		int hd =0; 
		getVerticalOrder(root,hd,m);
		int l = m.keySet().size();
		int[][] arr = new int[l][100];
		int j=0; 
		for(Map.Entry entry : m.entrySet()){
			Vector<Integer> v = (Vector<Integer>) entry.getValue();
			int[] vv = new int[v.size()];
			for(int i=0; i<v.size(); i++){
				vv[i] = v.get(i);
			}
			arr[j] = new int[vv.length];
			arr[j] = vv;
			j++;
		}
		return arr;
	}

	void getVerticalOrder(TreeNode root, int hd, 
			TreeMap<Integer,Vector<Integer>> m) 
	{ 
		// Base case 
		if(root == null) 
			return; 

		//get the vector list at 'hd' 
		Vector<Integer> get =  m.get(hd); 

		// Store current node in map 'm' 
		if(get == null) 
		{ 
			get = new Vector<>(); 
			get.add(root.val); 
		} 
		else
			get.add(root.val); 

		m.put(hd, get); 

		// Store nodes in left subtree 
		getVerticalOrder(root.left, hd-1, m); 

		// Store nodes in right subtree 
		getVerticalOrder(root.right, hd+1, m); 
	} 
}
