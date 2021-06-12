package com.zero.priorityqueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElementStream {

	static PriorityQueue<Integer> minHeap;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			minHeap = new PriorityQueue<Integer>();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				int tmp = sc.nextInt();
				if (minHeap.size()<k) {
					minHeap.add(tmp);
					if(minHeap.size()==k){
						System.out.print(minHeap.peek()+" ");
					}else
						System.out.print("-1 ");
				}else{
					if(minHeap.peek()<tmp){
						minHeap.poll();
						minHeap.add(tmp);
					}
					System.out.print(minHeap.peek()+" ");
				}
			}
			System.out.println();
		}
		sc.close();
	}

}
