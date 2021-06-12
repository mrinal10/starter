package com.datastructures;

public interface BinaryHeap {
	public Node getMin();
	public Node getMax();
	
	public Node extractMin();
	public Node extractMax();
	
	public Node decreaseKey();
	public Node increaseKey();
	
	public Node insert();
	public Node delete();	
	
	public void print();
}
