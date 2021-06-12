package com.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MajorityElement {

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
	int[] processArr(int[] ar){
		ArrayList<Integer> aList = new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]!=0){
				aList.add(ar[i]);
			}
		}
		int[] newAr = new int[aList.size()];
		for (int i = 0; i < newAr.length; i++) {
			newAr[i] = aList.get(i);
		}
		return newAr;
	}
	
	void printMajority(int b[]){
		
		int a[] = processArr(b);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+" ");
		}
		System.out.println();
		int size = a.length;
		int trgtSize = size/2;
		
		Arrays.sort(a);
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		for (Integer intValue : set) {
			int countFreq = findLastIndex(a, 0, a.length-1, intValue) - findFirstIndex(a, 0, a.length, intValue)+1;
			if (countFreq>trgtSize) {
				System.out.println(intValue);
				return;
			}
		}
		System.out.println("NONE");
	}
	
	public static void main(String[] args) {
		int[] arr =  {1, 6, 7, 6, 6, 6, 8, 6};
		MajorityElement ele = new MajorityElement();
		ele.printMajority(arr);
	}

}
