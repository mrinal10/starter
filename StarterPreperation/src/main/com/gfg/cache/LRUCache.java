package com.gfg.cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {
	private int CACHE_SIZE;
	Deque<Integer> doubleEndedQueue;
	Set<Integer> setEl;

	public LRUCache(int capacity) {
		CACHE_SIZE = capacity;
		doubleEndedQueue = new LinkedList<>();
		setEl = new HashSet<Integer>();
	}

	public void refer(int value) {
		if (!setEl.contains(value)) {
			if(doubleEndedQueue.size() == CACHE_SIZE) {
				setEl.remove(doubleEndedQueue.removeLast());
			}
		} else {
			doubleEndedQueue.remove(value);			
		}
		doubleEndedQueue.push(value);
		setEl.add(value);
	}
	
	public void display() {
        Iterator<Integer> itr = doubleEndedQueue.iterator();
        while (itr.hasNext()) { 
            System.out.print(itr.next() + " "); 
        } 
    }
	
	public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.refer(2);
        cache.refer(2);
        cache.refer(1);
        cache.display();
    }
}
