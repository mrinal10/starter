package com.practice.heap;

public class MaxHeap {
	private int[] heap;
	private int curSize;
	private int maxSize;

	MaxHeap(int size) {
		maxSize = size;
		heap = new int[maxSize];
		curSize = 0;
	}

	public int parent(int pos) {
		return pos / 2;
	}

	public int leftChild(int pos) {
		return pos * 2;
	}

	public int rightChild(int pos) {
		return pos * 2 + 1;
	}

	public boolean isLeaf(int pos) {
		if (pos > (curSize / 2) && pos <= curSize) {
			return true;
		}
		return false;
	}

	public void swap(int fpos, int lpos) {
		int temp = heap[fpos];
		heap[fpos] = heap[lpos];
		heap[lpos] = temp;
	}

	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;

		if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
			if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	public void insert(int element) {
		heap[++curSize] = element;

		int current = curSize;
		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public int extractMax() {
		int popped = heap[1];
		heap[1] = heap[curSize--];
		maxHeapify(1);
		return popped;
	}
}
