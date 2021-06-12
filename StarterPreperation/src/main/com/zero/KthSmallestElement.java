package com.zero;


import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestElement {

	static int findKthSmallest(int[] arr, int k){
		PriorityQueue<Integer> pQueue = new PriorityQueue(k);
		pQueue.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if(pQueue.peek()<arr[i]){
				pQueue.add(arr[i]);
			}
		}
		int v = 0;
		for (int i = 0; i < k; i++) {
			v = pQueue.poll();
		}
		return v;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int q = sc.nextInt();
			for (int i = 0; i < q; i++) {
				int k = sc.nextInt();
				System.out.println(findKthSmallest(arr, k));
			}
		}		
		sc.close();
	}

}
