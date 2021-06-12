package com.zero;

public class FindAkela {
	int findAkelaInLogHelper(int arr[], int l, int r) {
		int mid = (l + r) / 2;
		while (l <= r) {
			if (mid == 0 || mid == arr.length - 1) {
				return arr[mid];
			}
			mid = (l + r) / 2;
			if (mid % 2 == 1) {
				if (arr[mid] == arr[mid + 1]) {
					return findAkelaInLogHelper(arr, l, mid - 1);
				} else if (arr[mid] == arr[mid - 1]) {
					return findAkelaInLogHelper(arr, mid + 1, r);
				} else {
					return arr[mid];
				}
			} else {
				if (arr[mid] == arr[mid + 1]) {
					return findAkelaInLogHelper(arr, mid + 2, r);
				} else if (arr[mid] == arr[mid - 1]) {
					return findAkelaInLogHelper(arr, l, mid + 1);
				} else {
					return arr[mid];
				}
			}
		}
		return -1;
	}

	int findAkelaInLogN(int arr[]) {
		return findAkelaInLogHelper(arr, 0, arr.length - 1);
	}

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

		int[] arr = { 1, 11, 12, 13, 23, 34, 44 };
		FindAkela akla = new FindAkela();
		System.out.println(akla.sortedInsertPosition(arr, 22));
//		System.out.println(akla.findAkelaInLogN(arr));
	}
}
