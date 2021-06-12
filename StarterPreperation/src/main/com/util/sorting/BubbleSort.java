package com.util.sorting;

public class BubbleSort {
	
	private static int[] bubble(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			for (int j = 0; j < arr.length-i; j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] ar = {11, 25, 10, 256, 91, 45, 6, 85};
		ar = bubble(ar);
		ArrayUtil.printAll(ar);

	}

}
