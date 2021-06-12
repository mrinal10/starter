package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MatrixMedian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				ArrayList<Integer> innerList = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					int inp = sc.nextInt();
					innerList.add(inp);
				}
				Collections.sort(innerList);
				aList.add(innerList);
			}
			System.out.println(findMedian(aList));
		}
		sc.close();
	}

	static int findMedian(ArrayList<ArrayList<Integer>> m) {
		int r = m.size();
		int c = m.get(0).size();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < r; i++) {
			if (m.get(i).get(0) < min)
				min = m.get(i).get(0);
			if (m.get(i).get(c - 1) > max)
				max = m.get(i).get(c - 1);
		}

		int desired = (r * c + 1) / 2;
		while (min < max) {
			int mid = min + (max - min) / 2;
			int place = 0;
			int get = 0;

			for (int i = 0; i < r; ++i) {
				int[] arr = new int[m.get(i).size()];
				for (int j = 0; j < arr.length; j++) {
					arr[j] = m.get(i).get(j);
				}
				get = Arrays.binarySearch(arr, mid);
				if (get < 0)
					get = Math.abs(get) - 1;
				else {
					while (get < m.get(i).size() && m.get(i).get(get) == mid){
						get += 1;
					}
				}
				place = place + get;
			}
			if (place < desired)
				min = mid + 1;
			else
				max = mid;
		}
		return min;
	}

}
