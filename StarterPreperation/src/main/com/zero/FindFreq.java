package com.zero;

public class FindFreq {

	int findFreq(int a[], int k) {

		int sIndex = findFirstIndex(a, 0, a.length - 1, k);
		int lIndex = findLastIndex(a, 0, a.length - 1, k);
		System.out.println(sIndex+" << sIndex :: lIndex >> "+lIndex);
		if(sIndex == -1 || lIndex == -1){
			return 0;
		}
		return lIndex - sIndex + 1;
	}

	int findFirstIndex(int a[], int l, int h, int k) {
		int mid = (l + h) / 2;
		if (l <= h) {
			if ((a[mid] == k && mid == 0) || (a[mid] == k && a[mid - 1] < k) ){
				return mid;
			}else if (a[mid] < k) {
				return findFirstIndex(a, mid + 1, h, k);
			} else {
				return findFirstIndex(a, l, mid - 1, k);
			}
		}
		return -1;
	}
	int findLastIndex(int a[], int l, int h, int k) {
		int mid = (l + h) / 2;
		
		if (l <= h) {
			if (mid == a.length - 1 || (a[mid] == k && a[mid + 1] > k)) {
				return mid;
			}else if (a[mid] <= k) {
				return findLastIndex(a, mid + 1, h, k);
			} else {
				return findLastIndex(a, l, mid - 1, k);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2};//, 2, 2, 8, 9, 9, 9, 9 };
		FindFreq czrs = new FindFreq();
		System.out.println(czrs.findFreq(arr, 19));
	}
}