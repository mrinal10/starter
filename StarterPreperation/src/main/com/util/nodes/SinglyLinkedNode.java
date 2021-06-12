package com.util.nodes;

public class SinglyLinkedNode<T> {
	private T data;
	private  SinglyLinkedNode<T> next;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public SinglyLinkedNode<T> getNext() {
		return next;
	}
	public void setNext(SinglyLinkedNode<T> next) {
		this.next = next;
	}
}
