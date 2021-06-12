package com.practice.microsoft;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindNthLargestNumberFromAunsortedArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
		
		int[] ar = { 22, 5, 6, 87, 7,88, 71, 4, 54, 7, 88, 9, 415 };
		for (int i = 0; i < ar.length; i++) {
			pQueue.add(ar[i]);
		}
		for (int i = 0; i < pQueue.size(); i++) {
			System.out.println(pQueue.poll());
		}
		sc.close();
	}
}
