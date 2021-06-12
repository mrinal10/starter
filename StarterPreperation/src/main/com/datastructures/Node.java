package com.datastructures;

public class Node {
	private int nodeValue;
	private Node leftNode, rightNode;
	
	public int getNodeValue() {
		return nodeValue;
	}
	public void setNodeValue(int nodeValue) {
		this.nodeValue = nodeValue;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}	
}
