package com.zero.graph;

import java.util.*;

public class TopologicalSort {

	static Set<Integer> alreadyVisited;
	static Stack<Integer> allNode;
	void topSortUtil(int node, Map<Integer, List<Integer>> g){
		alreadyVisited.add(node);
		List<Integer> adjacentNodelist = g.get(node);
		for (Iterator<Integer> iterator = adjacentNodelist.iterator(); iterator.hasNext();) {
			Integer integer = iterator.next();
			if (!alreadyVisited.contains(integer)) {
				topSortUtil(integer, g);
			}
		}
		allNode.add(node);
	}
	
	void topSort(Map<Integer, List<Integer> > g){ 
		alreadyVisited = new HashSet<>();
		allNode = new Stack<Integer>();
		Set<Integer> set = g.keySet();
		for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if (!alreadyVisited.contains(integer)) {
				topSortUtil(integer, g);
			}
		}
		while (allNode.empty()==false)
            System.out.print(allNode.pop() + " ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
