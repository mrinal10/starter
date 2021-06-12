package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import com.geekforgeeks.microsoft.TreeNode;


class BFSElement{
	int level;
	TreeNode treeNode;
	public BFSElement(int lvl, TreeNode node) {
		treeNode = node;
		level = lvl;
	}
}

public class ReverseBFS {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root==null) {
			return null;
		}
		Queue<BFSElement> queue = new LinkedList<>();
		queue.add(new BFSElement(0, root));
		Map<Integer, List<TreeNode>> map = new HashMap<>();
		while (!queue.isEmpty()) {
			BFSElement el = queue.poll();
			
			int key = el.level;
			List<TreeNode> list = new ArrayList<>();
			if (map.containsKey(key)) {
				list = map.get(key);
			}
			list.add(el.treeNode);
			map.put(key, list);
			
			TreeNode trNd = el.treeNode;
			if(trNd.leftChild!=null){
				queue.add(new BFSElement(key+1, trNd.leftChild));
			}
			if(trNd.rightChild!=null){
				queue.add(new BFSElement(key+1, trNd.rightChild));
			}
		}
		List<List<Integer>> listIntegers = new ArrayList<>();
		
		map.forEach((key, value) -> {
			List<Integer> listIndvidual = new ArrayList<>();
			value.forEach(treeNodde -> {
				int a = treeNodde.data;
				listIndvidual.add(a);
			});
			listIntegers.add(listIndvidual);
		});
		Collections.reverse(listIntegers);
		return listIntegers;
	}
}
