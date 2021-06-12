package com.zero;

public class QuickSort {

	int partition(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low-1;
		for (int j = low; j < high; j++) {
			if(arr[j]<=pivot){
				i++;
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}
	
	void qsort(int[] arr, int low, int high){
		if(low<high){
			int mid = partition(arr, low, high);
			qsort(arr,low,mid-1);
			qsort(arr,mid+1,high);
		}
	}

	void quicksortArray(int arr[]) {
		qsort(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		
	}

}
