package com.util.sorting;

/*
i ← 1
while i < length(A)
    x ← A[i]
    j ← i - 1
    while j >= 0 and A[j] > x
        A[j+1] ← A[j]
        j ← j - 1
    end while
    A[j+1] ← x[4]
    i ← i + 1
end while
*/

public class InsertionSort {
	private static int[] getSortedByInsertion(int[] array) {
		for(int i=1; i<array.length; i++) {
			int key = array[i];
			int j = i-1;
			
			while (j>=0 && array[j]>key) {
				array[j+1] = array[j];
				System.out.println("j >>"+j);
				j--;
			}
			array[j+1]=key;
			printAll(array);
		}
		return array;
	}
	
	private static void printAll(int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	public static void main(String[] args) {
		int[] ar = {11, 25, 10, 256, 45, 6, 85};
		ar = getSortedByInsertion(ar);
		ArrayUtil.printAll(ar);
	}
}
