package com.article.practice.medium.article;

import com.util.datastructure.trees.BinaryTree;
import com.util.nodes.BinaryNode;

public class TopThreeElementsinTree {
	public static void main(String[] args) {
		BinaryTree<Integer> newTree = new BinaryTree<>();
		BinaryNode<Integer> rootNode = newTree.createrootNode(10);
		
		BinaryNode<Integer> firstLeft = new BinaryNode<Integer>();
		firstLeft.setData(12);
		BinaryNode<Integer> sLeft = new BinaryNode<Integer>();
		sLeft.setData(19);
		BinaryNode<Integer> tLeft = new BinaryNode<Integer>();
		tLeft.setData(9);
		
		sLeft.setleft(tLeft);
		firstLeft.setleft(sLeft);
		
		BinaryNode<Integer> fRight = new BinaryNode<Integer>();
		fRight.setData(2);
		BinaryNode<Integer> sRight = new BinaryNode<Integer>();
		sRight.setData(120);
		BinaryNode<Integer> tRight = new BinaryNode<Integer>();
		tRight.setData(18);
		
		sRight.setRight(tRight);
		fRight.setRight(sRight);
		
		rootNode.setleft(firstLeft);
		rootNode.setRight(fRight);
		
		int f = rootNode.getData();
		int s = rootNode.getData();
		int t = rootNode.getData();
		
		getthreemin(rootNode, f, s, t);
		
		System.out.println("f : "+f);
		System.out.println("s : "+s);
		System.out.println("t : "+t);
		
	}
	
	
	
	private static void getthreemin(BinaryNode<Integer> root, int first, int second, int third){
		System.out.println("root.getData() :: " + root.getData());
		// if data is greater than first large number
		  // update the top three list
		  if (root.getData() > first) {
		    third = second;
		    second = first;
		    first = root.getData();
		  }
		 
		  // if data is greater than second large number
		  // and not equal to first update the bottom 
		  // two list
		  else if (root.getData() > second && root.getData() != first) {
		    third = second;
		    second = root.getData();
		  }
		 
		  // if data is greater than third large number
		  // and not equal to first & second update the 
		  // third highest list
		  else if (root.getData() > third && 
		           root.getData() != first && 
		           root.getData() != second)
		    third = root.getData();
		 
		  getthreemin(root.getleft(), first, second, third);
		  getthreemin(root.getRight(), first, second, third);
	}
}
