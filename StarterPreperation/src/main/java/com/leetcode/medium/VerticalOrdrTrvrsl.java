package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.prep.bfs.TreeNode;



public class VerticalOrdrTrvrsl {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> listOfValues = new ArrayList<>();		
		Map<Integer, List<Integer>> map = new TreeMap<>();
		vertical(root, 0, map);
		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			listOfValues.add(list);
		}
		return listOfValues;
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
