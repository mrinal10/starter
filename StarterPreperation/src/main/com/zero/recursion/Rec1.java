package com.zero.recursion;

import java.util.Arrays;

public class Rec1 {

	public static void printNToOne(int N)
	{
		if (N<1) {
			return;
		}
	    System.out.print(N+" ");
	    printNToOne(N-1);
	}
	
	public static int getSumOfDigits(int N)
	{
	    int sum = 0; 
		if(N==0){
	    	 return 0;
	    }
		sum = sum+getSumOfDigits(N/10)+(N%10);
		return sum;
	}
	
	private static boolean isPalindromic(int[] a){
		boolean res = false;
		if (a.length==0) {
			return true;
		}
		if (a.length==1){ 
			return  true;
		}else if(a.length==2) {
			return a[0]==a[1];
		}
		
		if(a[0]==a[a.length-1]){
			res = isPalindromic(Arrays.copyOfRange(a, 1, a.length-1));
		}
	    return res;
	}
	
	long getFactorial(int N)
	{
	     if(N==1 || N==0){
	       return 1;
	     }
	  	 return N*getFactorial(N-1);
	}
	
	
	int findingIdx(int a[], int k) {
	    return helperSrch(a, 0, k);
	}

	int helperSrch(int a[], int sIndex, int k){
	  int indx = 0;
	  if( sIndex == a.length){
	    return -1;
	  }
	  if(a[sIndex]==k){
	    indx = sIndex;
	  }else{
	  indx = 	helperSrch(a, sIndex+1, k);
	  }
	  return indx;
	}
	
	
	public static void main(String[] args) {
		int n =  123;
		//printNToOne(n);
//		System.out.println(getSumOfDigits(n));
		int[] n1 = {10,39,3539,10};
		System.out.println(isPalindromic(n1));
	}

}
