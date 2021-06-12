package com.datastructures;

public class MaxHeap implements BinaryHeap{
	
	private int[] Heap;
    private int size;
    private int maxsize;
 
    private static final int FRONT = 1;
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }
	@Override
	public Node getMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node extractMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node extractMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node decreaseKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node increaseKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void print() {
		for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i] 
                + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        } 
	}

}


