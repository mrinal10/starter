package com.zero;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ExistanceinSortedArray {

	private static int binarysearch(int[] arr, int qry){
		int l = 0;
		int r = arr.length-1;
		int mid=0;
		while (l<=r) {
			mid = (l+r)/2;
			if (arr[mid] == qry) {
				return mid;
			}else if(arr[mid]<qry){
				l = mid+1;
			}else{
				r = mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int q = sc.nextInt();
		HashSet<Integer> intSet = new HashSet<>();
		int[] arr = new int[l];
		for(int i=0; i<l; i++){
			intSet.add(sc.nextInt());
		}
		for(int i=0; i<q; i++){
			int qry = sc.nextInt();
			if (intSet.contains(qry)) {
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}

		sc.close();
	}

}
