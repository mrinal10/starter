package com.util.nodes;

public class BinaryNode<T> {
	private T data;
	private  BinaryNode<T> left, right;
	
	public BinaryNode<T> getRight() {
		return right;
	}
	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryNode<T> getleft() {
		return left;
	}
	public void setleft(BinaryNode<T> next) {
		this.left = next;
	}
}
