package com.practice.heap;

public class FindKthLargestFromArray {
	public static void main(String[] args) {
		MaxHeapL mHeap = new MaxHeapL(10);
		int[] ar = {1, 23, 12, 9, 30, 2, 50};
		for(int i=0; i<ar.length; i++) {
			mHeap.insert(ar[i]);
		}
		
		int k = 3;
		
		for(int i=0; i<k; i++) {
			System.out.println(mHeap.getMax());
		}
	}

}

class MaxHeapL{
	int curSize;
	int maxSize;
	int[] heap;
	
	MaxHeapL(int sizeOfHeap){
		maxSize = sizeOfHeap;
		heap = new int[maxSize];
	}
	
	public int parent(int pos) {
		return pos/2;
	}
	
	public int leftChild(int pos) {
		return pos*2+1;
	}
	
	public int rightChild(int pos) {
		return pos*2 + 2;
	}
	
	public void swap(int lpos, int rpos) {
		int t = heap[lpos];
		heap[lpos] = heap[rpos];
		heap[rpos] = t;
	}
	
	public boolean isLeaf(int pos) {
		if(pos<=curSize && pos >curSize/2) {
			return true;
		}
		return false;
	}
	
	public void maxHeapify(int pos) {
		if(isLeaf(pos)) {
			return;
		}
		
		if(heap[leftChild(pos)] > heap[pos] || heap[rightChild(pos)] > heap[pos]) {
			if(heap[leftChild(pos)]>heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}
	
	public void insert(int value) {
		heap[++curSize] = value;
		
		int current = curSize;
		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	public int getMax() {
		int popped = heap[0];
		heap[0] = heap[curSize--];
		maxHeapify(0);
		return popped;
	}
}
