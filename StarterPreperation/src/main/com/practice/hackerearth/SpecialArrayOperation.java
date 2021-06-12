package com.practice.hackerearth;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

class NumberComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
}

public class SpecialArrayOperation {
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOFElements = sc.nextInt();
		int numberOfQueries = sc.nextInt();
		PriorityQueue<Integer> minPq = new PriorityQueue<>();
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(numberOFElements, new NumberComparator());
		for (int i = 0; i < numberOFElements; i++) {
			int t = sc.nextInt();
			maxPq.add(t);
			minPq.add(t);
		}
		int sum = 0;
		Iterator<Integer> it = minPq.iterator();
		while (it.hasNext()) {
			sum += it.next();
		}
		map.put(0, sum);
		for (int i = 1; i <= numberOFElements; i++) {

			int maxEl = maxPq.poll();
			int minEl = minPq.poll();
			maxPq.remove(minEl);
			minPq.remove(maxEl);
			int difference = maxEl - minEl;
			maxPq.add(difference);
			minPq.add(difference);
			sum = 0;

			it = minPq.iterator();
			while (it.hasNext()) {
				sum += it.next();
			}
			map.put(i, sum);
		}
		
		for (int i = 0; i < numberOfQueries; i++) {
			int q = sc.nextInt();
			System.out.println(map.get(q));
		}
		sc.close();
	}

}
