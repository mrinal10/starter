package com.util.sorting;

public class InsertionSort1 {
	
	private static int[] arraySortInsertion(int[] ar) {
		for(int i=1; i<ar.length; i++) {
			int key = ar[i];
			int j = i-1;
			while(j>=0 && ar[j]>key) {
				ar[j+1]=ar[j];
				j--;
			}
			ar[j+1] = key;
		}
		
		return ar;
	}
	
	public static void main(String[] args) {
		int[] ar = {10,34,2,8,29,100,45};
		arraySortInsertion(ar);
		ArrayUtil.printAll(ar);
	}
}
