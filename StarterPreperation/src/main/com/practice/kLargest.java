package com.practice;

import java.util.PriorityQueue;
import java.util.Scanner;

public class kLargest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];

		for (int i = 0; i < ar.length; i++) {
			ar[i] = sc.nextInt();
		}
		int[] ar1 = new int[n];
		ar1[0] = ar[0];
		
		for (int i = 1; i < ar.length; i++) {
			for (int j = 1; i < i; j++) {
				ar1[j] = ar[j];
			}
			if (i<3) {
				System.out.println(findKthLargest(ar1, 3)*findKthLargest(ar1, 2)*findKthLargest(ar1, 1));
			}else{
				System.out.println("-1");
			}
		}
		sc.close();
	}

//	public static int createPriorityQueue(int[] nums, int k) {
//		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
//		for (int i : nums) {
//			q.offer(i);
//			if (q.size() > k) {
//				q.poll();
//			}
//		}
//		return q.peek();
//	}
	
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for (int i : nums) {
			q.offer(i);
			if (q.size() > k) {
				q.poll();
			}
		}
		System.out.println(q.peek());
		return q.peek();
	}
}
