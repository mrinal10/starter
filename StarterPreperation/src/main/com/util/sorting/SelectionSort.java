package com.util.sorting;

import java.util.Scanner;

public class SelectionSort {
	private static void getItSortedSelectionWay(int[] n) {
		for (int i = 0; i < n.length; i++) {
			int biggElementIndex = 0;
			int currElement = n[0];
			for(int j=0; j<n.length-i; j++) {
				currElement = n[j];
				if (currElement>n[biggElementIndex]) {
					biggElementIndex = j;
				}
			}
			n = ArrayUtil.swap(n, biggElementIndex, n.length-i-1);
		}
		ArrayUtil.printAll(n);
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.err.println("Insert the length of array : ");
		int n = sc.nextInt();
		int[] ar = ArrayUtil.inserttoArray(n);
//		int[] ar = {11, 25, 10, 256, 91, 45, 6, 85};
		getItSortedSelectionWay(ar);
	}
}
