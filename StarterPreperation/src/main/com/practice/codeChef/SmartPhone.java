package com.practice.codeChef;

import java.util.Scanner;

class SmartPhone {
	private static int partition ( int A[],int start ,int end) {
	    int i = start + 1;
	    int piv = A[start] ;            //make the first element as pivot element.
	    for(int j =start + 1; j <= end ; j++ )  {
	    	if ( A[ j ] > piv) {
			  swap (A, i, j );
			  i += 1;
	        }
	    }
	    swap(A, start, i-1 ) ;  //put the pivot element in its proper place.
	    return i-1;                      //return the position of the pivot
	}
	
	public static int[] swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
		return ar;
	}
	
	private static void QSort(int[] ar, int start , int end ) {
	   if( start < end ) {
	        //stores the position of pivot element
	         int piv_pos = partition (ar,start , end ) ;     
	         QSort (ar,start , piv_pos -1);    //sorts the left side of pivot.
	         QSort ( ar,piv_pos +1 , end) ; //sorts the right side of pivot.
	   }

	}
	
	private static int getMaxRev(int[] arr) {
		int maxRev = 0;
		int setPrice = 0;
		for (int i = 0; i < arr.length; i++) {
			setPrice = arr[i];
			if (maxRev < (setPrice*(i+1))) {
				maxRev = setPrice * (i+1);
			} else {
				break;
			}
			
		}
		return maxRev;
	}
	
	public static void main(String[] args) {
		try {
			
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			int arr[] = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			QSort(arr, 0, n-1);
			sc.close();
			System.out.println(getMaxRev(arr));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
