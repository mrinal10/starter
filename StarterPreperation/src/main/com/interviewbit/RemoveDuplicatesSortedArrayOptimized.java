package com.interviewbit;

public class RemoveDuplicatesSortedArrayOptimized {
	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 1, 1, 1, 1, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 7, 8, 8, 8, 12, 13, 14, 14, 15 };
		int newLength = removeDuplicates(a);
		for (int i = 0; i < newLength; i++) {
			System.out.println(a[i]);
		}
	}

	public static int removeDuplicates(int[] a) {
		int i = 0;
		int j = 1;
		for (i = 0; i < a.length && j<a.length; i++) {
			while (j < a.length && a[i] == a[j]) {
				j++;
			}
			if (j < a.length) {
				a[i + 1] = a[j];
			}
		}
		
		return i;
	}
}
