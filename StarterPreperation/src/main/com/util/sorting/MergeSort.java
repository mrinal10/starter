package com.util.sorting;

//import java.util.Scanner;

public class MergeSort {
	
	private static void merge(int[] ar, int s, int m, int l) {
		int in1 = m-s+1;
		int in2 = l-m;
		int[] tempArray1 = new int[in1];
		int[] tempArray2 = new int[in2];
		
		int j = 0;
		for (int i = s; i < in1; i++) {
			System.out.println("i :: "+i);
			tempArray1[j] = ar[i];
			j++;
		}
		System.out.println("tempArray1");
		ArrayUtil.printAll(tempArray1);
		
		j = 0;
		for (int i = 0; i < in2; i++) {
			tempArray2[j] = ar[i];
			j++;
		}
		System.out.println("tempArray2");
		ArrayUtil.printAll(tempArray2);
		int indx1 = 0;
		int indx2 = 0;

		while(indx1<(in1) && indx2<(in2)) {
			if (tempArray1[indx1]<tempArray2[indx2]) {
				ar[s] = tempArray1[indx1];
				indx1++;
			}else {
				ar[s] = tempArray2[indx2];
				indx2++;
			}
			s++;
		}
		
		while(indx1<in1) {
			ar[s] = tempArray1[indx1];
			indx1++;
			s++;
		}
		
		while(indx2<in2) {
			ar[s] = tempArray2[indx2];
			indx2++;
			s++;
		}
		ArrayUtil.printAll(ar);
	}
	
	private static void getItSortedMergedWay(int[] arr, int start, int end) {
		
		if (start<end) {
			int midPointIndex = (start+end)/2;
			
			getItSortedMergedWay(arr, start, midPointIndex);
			getItSortedMergedWay(arr, midPointIndex+1, end);
			
			merge(arr,start,midPointIndex,end);
		}
	}
	
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.err.println("Insert the length of array : ");
//		int n = sc.nextInt();
//		int[] ar = ArrayUtil.inserttoArray(n);
		int[] ar = {11, 25, 10, 256, 91, 45, 6, 85};
		getItSortedMergedWay(ar,0,ar.length-1);
		ArrayUtil.printAll(ar);
	}
}
