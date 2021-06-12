package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.leetcode.TreeNode;
import com.leetcode.BFSElement;

public class RightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> listIntegers = new ArrayList<>();
        if (root==null) {
			return listIntegers;
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
			if(trNd.left!=null){
				queue.add(new BFSElement(key+1, trNd.left));
			}
			if(trNd.right!=null){
				queue.add(new BFSElement(key+1, trNd.right));
			}
		}
        
		for(Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()){
        	List<Integer> listIndvidual = new ArrayList<>();
			entry.getValue().forEach(treeNodde -> {
				int a = treeNodde.val;
				listIndvidual.add(a);
			});
            
			listIntegers.add(listIndvidual.get(listIndvidual.size()-1));
		}
		return listIntegers;

	}
}
