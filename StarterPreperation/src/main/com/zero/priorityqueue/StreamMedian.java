package com.zero.priorityqueue;

import java.util.*;

public class StreamMedian {
	private static void addNumber(PriorityQueue<Integer> minQueue, PriorityQueue<Integer> maxQueue, int number){
		if (minQueue.isEmpty() || number<minQueue.peek()) {
			minQueue.add(number);
		}else{
			maxQueue.add(number);
		}
	}
	private static void rebalanceHeaps(PriorityQueue<Integer> minQueue, PriorityQueue<Integer> maxQueue){
		if (maxQueue.size()-minQueue.size()>=2) {
			minQueue.add(maxQueue.poll());
		}else if(minQueue.size() - maxQueue.size()>=2){
			maxQueue.add(minQueue.poll());
		}
	}
	private static void printMedian(PriorityQueue<Integer> minQueue, PriorityQueue<Integer> maxQueue){
		double median = 0;
		if (minQueue.size()>maxQueue.size()) {
			median = minQueue.peek();
		}else if(maxQueue.size()>minQueue.size()){
			median = maxQueue.peek();
		}else{
			median = (minQueue.peek()+maxQueue.peek())/2.0;
		}
		System.out.print(median+" ");
	}
	private static void getMedian(int[] array){
		PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) { 	return -1 * o1.compareTo(o2); 	}
		});
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>();
		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			addNumber(minQueue, maxQueue, number);
			rebalanceHeaps(minQueue, maxQueue);
			printMedian(minQueue, maxQueue);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-->0) {
			int  n = sc.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = sc.nextInt();
			}  
			getMedian(ar);
			System.out.println();
		}
		sc.close();
	}

}
