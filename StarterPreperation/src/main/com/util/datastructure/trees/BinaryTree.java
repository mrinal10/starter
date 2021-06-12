package com.util.datastructure.trees;

import com.util.nodes.BinaryNode;

public class BinaryTree<T> {
	private BinaryNode<T> rootNode = new BinaryNode<T>();
	
	public BinaryNode<T> getRootNode() {
		return rootNode;
	}

	public BinaryNode<T> createrootNode(T value){
		rootNode.setData(value);
		return rootNode;
	}
	
	public BinaryNode<T> createNode(T value){
		BinaryNode<T> newNode = new BinaryNode<T>();
		newNode.setData(value);
		return newNode;
	}
	
	public BinaryNode<T> addLeftNode(BinaryNode<T> node){
		rootNode.setleft(node);
		return rootNode;
	}
	
	public BinaryNode<T> addRightNode(BinaryNode<T> node){
		rootNode.setRight(node);
		return rootNode;
	}
}
