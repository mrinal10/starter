package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.prep.bfs.TreeNode;

class QNode {
	TreeNode node;
	int verticals;
	QNode(TreeNode n, int vrtcl) {
		node = n;
		verticals = vrtcl;
	}
}

public class VerticalOrdrTrvrsl_lvlOrdr {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> listOfValues = new ArrayList<>();		
		Map<Integer, List<Integer>> map = new TreeMap<>();
		verticalLevelOrderTraversal(root,map);
		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			listOfValues.add(list);
		}
		return listOfValues;
	}
	
	private void verticalLevelOrderTraversal(TreeNode root, 
					Map<Integer, List<Integer>> map) {
	    Queue<QNode> q = new LinkedList<>(); 
	    if (root==null) {
			return;
		}
	    QNode qNode = new QNode(root, 0);
	    q.add(qNode);
	    
	    while (!q.isEmpty()) {
	    	QNode curNode = q.poll();
			int lvl = curNode.verticals;
			List<Integer> listInt = new ArrayList<Integer>();
			if(map.containsKey(lvl)) {
				listInt = map.get(lvl);
			}
			listInt.add(curNode.node.val);
			map.put(lvl, listInt);
			if (curNode.node.left!=null) {
				QNode lft = new QNode(curNode.node.left, lvl-1);
			}
			if (curNode.node.right!=null) {
				QNode rght = new QNode(curNode.node.right, lvl+1);
			}
		}
	}
	
	private void vertical(TreeNode root, int lvl, 
			Map<Integer, List<Integer>> listOfValues) {
		if (root == null) {
			return;
		}
		List<Integer> ll;
		if(!listOfValues.containsKey(lvl)) {
			ll = new ArrayList<Integer>();
		}else {
			ll = listOfValues.get(lvl);
		}
		
		ll.add(root.val);
		listOfValues.put(lvl, ll);
		vertical(root.left, lvl-1, listOfValues);
		vertical(root.right, lvl+1, listOfValues);
	}
}
