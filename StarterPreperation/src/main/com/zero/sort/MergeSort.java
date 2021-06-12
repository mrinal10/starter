package com.zero.sort;

public class MergeSort {

	void merge(int[] arr, int l, int m ,int r){
		int lenA = m-l+1;
		int lenB = r-m;
		
		int[] A = new int[lenA];
		int[] B = new int[lenB];
		
		for (int i = 0; i < lenA; i++) {
			A[i] = arr[l+i];
		}
		
		for (int i = 0; i < lenB; i++) {
			B[i] = arr[m+1+i];
		}
		int i = 0;
		int j = 0;
		int k = l;
		
		while (i<lenA && j<lenB) {
			if(A[i]<B[j]){
				arr[k] = A[i];
				i++;
			}else{
				arr[k] = B[j];
				j++;
			}
			k++;
		}
		
		while (i<lenA){
			arr[k] = A[i];
			k++;
			i++;
		}
		
		while (j<lenB){
			arr[k] = B[j];
			k++;
			j++;
		}
	}
	
	void sort(int[] arr, int l, int r){
		if(l<r){
			int mid = (l+r)/2;	
			sort(arr, l , mid);
			sort(arr, mid+1 , r);
			
			merge(arr, l, mid ,r);
		}
	}
	
	void mergesortArray(int arr[]) {
		sort(arr,0,arr.length-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
