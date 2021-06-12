package com.gfg.interviewprep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};

public class NAryLvlOrder {

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<List<Node>> q = new LinkedList<List<Node>>();
		if (root!=null) {
			q.add(root.children);
			if (!q.isEmpty()) {
				List<Node> childList = q.remove();
				List<Integer> listInt = new ArrayList<>();
				for (int i = 0; i < childList.size(); i++) {
					listInt.add(childList.get(i).val);
					list.add(listInt);
				}
				
				List<Node> granChildList = new ArrayList<>();
				for(Node node:childList){
					
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
