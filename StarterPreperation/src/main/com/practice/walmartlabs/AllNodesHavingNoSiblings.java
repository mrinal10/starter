package com.practice.walmartlabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Node {
	int data;
	Node left;
	Node right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}


public class AllNodesHavingNoSiblings {
	List<Integer> allSingleChildren;
	void printSibling(Node node) {
		allSingleChildren = new ArrayList<>();
		printSiblingsRec(node);
		Collections.sort(allSingleChildren);
		
		for (Iterator<Integer> iterator = allSingleChildren.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next()+" ");
		}
		if (allSingleChildren.size()==0) {
			System.out.println(-1);
		}
	}
	
	void printSiblingsRec(Node node){
		if (node==null || (node.left == null && node.right==null)) {
			return;
		}

		if (node.left == null) {
			allSingleChildren.add(node.right.data);
			printSiblingsRec(node.right);
		}else if(node.right == null){
			allSingleChildren.add(node.left.data);
			printSiblingsRec(node.left);
		}else{
			printSiblingsRec(node.left);
			printSiblingsRec(node.right);
		}
	}
}
