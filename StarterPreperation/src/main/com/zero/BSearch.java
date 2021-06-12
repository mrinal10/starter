package com.zero;

import java.util.Arrays;

public class BSearch {

	static int firstOccuranceIdx(int arr[], int k) {
		Arrays.sort(arr);
	    return firstOcc(arr, k, 0, arr.length-1);
	}

	static int firstOcc(int arr[], int k, int l, int h){
	  int mid = 0;
		if(l<=h){
	    	mid = (l+h)/2;
	    	int v=arr[mid]; 
	      if( v==k &&(mid == 0 || arr[mid-1]<k )){
	        return mid;
	      }else if(v>=k){
	        return firstOcc(arr, k, l, mid-1);
	      }else{
	    	  return firstOcc(arr, k, mid+1, h);
	      }
	    }
	  return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 2, 9, 9, 9, 9, 15};
		System.out.println(firstOccuranceIdx(arr, 0 ));

	}

}
