package com.zero.recursion;

public class SortedInsertPOsition {
	int sortedInsertPosition(int a[], int k) {
		return sortedInsertPositionHelper(a, 0, a.length-1, k);
	}

	int sortedInsertPositionHelper(int arr[], int l, int r, int k) {
		int mid = 0;
		
		if (l <= r) {
			mid = (l + r) / 2;
			if(mid == 0|| mid == arr.length-1){
				return mid;
			}
			if(r-l == 1){
				return r;
			}
			if (arr[mid] > k) {
				return sortedInsertPositionHelper(arr, l, mid, k);
			} else {
				return sortedInsertPositionHelper(arr, mid, r, k);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SortedInsertPOsition insertPos = new SortedInsertPOsition();
		int[] arr = {1, 5, 7, 9, 20, 24, 26, 28, 35, 38, 44};
		System.out.println(insertPos.sortedInsertPosition(arr, 25));

	}

}
