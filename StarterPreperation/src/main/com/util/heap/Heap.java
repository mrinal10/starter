package com.util.heap;

public class Heap {
	public static void main(String[] args) {
		int ar[] = {7, 10, 14, 3, 8, 2, 16, 4, 9, 1};//{10,56,34,5,32,66,23,4,55,80,955,345,32,45,748,35,2,11};
		
		buildMaxHeap(ar);
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		System.out.println("********************");
		buildMinHeap(ar);
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}
	
	private static void buildMinHeap(int[] ar){
		for (int i = ar.length/2-1; i >=0 ; i--) {
			minHeapify(ar, i);
		}
	}
	
	private static void buildMaxHeap(int[] ar){
		for (int i = ar.length/2-1; i >=0 ; i--) {
			maxHeapify(ar, i);
		}
	}
	private static void maxHeapify(int[] ar, int index){
		int left = getleftIndex(index);
		int right = getrightIndex(index);
		int largest=index;
		if (left<ar.length-1 && ar[left]>ar[index]) {
			largest = left;
		}
		if (right<ar.length-1 && ar[right]>ar[index] ) {
			largest = right;
		}		
		if (largest!=index) {
			swapValues(ar, index, largest);
			maxHeapify(ar, largest);
		}
	}
	
	private static void minHeapify(int[] ar, int index){
		int left = getleftIndex(index);
		int right = getrightIndex(index);
		int smallest = index;
		if (left<ar.length-1 && ar[left]<ar[index]) {
			smallest = left;
		}
		if (right<ar.length-1 && ar[right]<ar[index] ) {
			smallest = right;
		}		
		if (smallest!=index) {
			swapValues(ar, index, smallest);
			minHeapify(ar, smallest);
		}
	}
	
	private static int getleftIndex(int i){
		return 2*i+1;
	}
	
	private static int getrightIndex(int i){
		return 2*i+2;
	}
	
	private static void swapValues(int[] ar, int index1, int index2){
		int temp = ar[index1];
		ar[index1] = ar[index2];
		ar[index2] = temp;
	}
}
