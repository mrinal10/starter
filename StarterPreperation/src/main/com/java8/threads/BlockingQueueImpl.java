package com.java8.threads;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueueImpl {
	private List queue = new LinkedList();
	private int limit = 10;
	
	public BlockingQueueImpl(int lim) {
		limit = lim;
	}
	public synchronized void enqueue(Object item) throws InterruptedException {
		if(this.queue.size()==limit) {
			wait();
		}
		queue.add(item);
		if(queue.size()==1) {
			notifyAll();
		}
		
	}
	
	public synchronized Object dequeue() throws InterruptedException {
		if(this.queue.size()==0) {
			wait();
		}
		if(queue.size() == this.limit) {
			notifyAll();
		}
		return queue.remove(0);
	}
}
