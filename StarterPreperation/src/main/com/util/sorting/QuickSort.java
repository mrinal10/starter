package com.util.sorting;

import java.util.Scanner;

public class QuickSort {
	private static int partition ( int A[],int start ,int end) {
	    int i = start + 1;
	    int piv = A[start] ;            //make the first element as pivot element.
	    for(int j =start + 1; j <= end ; j++ )  {
	    	if ( A[ j ] < piv) {
			  ArrayUtil.swap (A, i, j );
			  i += 1;
	        }
	    }
	    ArrayUtil.swap(A, start, i-1 ) ;  //put the pivot element in its proper place.
	    return i-1;                      //return the position of the pivot
	}
	
	private static void QSort(int[] ar, int start , int end ) {
	   if( start < end ) {
	        //stores the position of pivot element
	         int piv_pos = partition (ar,start , end ) ;     
	         QSort (ar,start , piv_pos -1);    //sorts the left side of pivot.
	         QSort ( ar,piv_pos +1 , end) ; //sorts the right side of pivot.
	   }
	}
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.err.println("Insert the length of array : ");
//		int n = sc.nextInt();
//		int[] ar = ArrayUtil.inserttoArray(n);
		int[] ar = {11, 25, 10, 256, 91, 45, 6, 85};
		QSort(ar,0,ar.length-1);
		ArrayUtil.printAll(ar);
	}
}
