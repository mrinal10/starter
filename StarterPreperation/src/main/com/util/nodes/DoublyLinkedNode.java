package com.util.nodes;

public class DoublyLinkedNode<T> {
	T data;
	SinglyLinkedNode<T> next;
	SinglyLinkedNode<T> prev;
	
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
	public SinglyLinkedNode<T> getPrev() {
		return next;
	}
	public void setPrev(SinglyLinkedNode<T> prev) {
		this.prev = prev;
	}
}
