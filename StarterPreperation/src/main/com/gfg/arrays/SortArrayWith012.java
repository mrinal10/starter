package com.gfg.arrays;

public class SortArrayWith012 {
	void sort012(int[] ar) {
		int len = ar.length;
		int lo = 0;
		int mid = 0;
		int hi = len-1;
		
		while(mid<hi) {
			switch(ar[mid]) {
			case 0:
				swapEl(ar, mid, lo);
				lo++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2: 
				swapEl(ar, hi, mid);
				hi--;
				mid++;
				break;			
			}
		}
	}
	
	void swapEl(int[] ar, int idx1, int idx2) {
		int temp = ar[idx1];
		ar[idx1] = ar[idx2];
		ar[idx2] = temp;
	}
}
