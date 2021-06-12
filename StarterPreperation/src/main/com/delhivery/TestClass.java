package com.delhivery;

import java.util.Scanner;

public class TestClass {
	public static void main(String args[] ) throws Exception {
		Scanner s = null;
		try {
	        s = new Scanner(System.in);
	        int N = s.nextInt();
	
	        for (int i = 0; i < N; i++) {
	           
	            int lim = s.nextInt();
	            int k = s.nextInt();
	            int[] ar = new int[lim];
	            for (int i1=0; i1<lim; i1++) {
					ar[i]=s.nextInt();					
				}
	            
	            swaparrayformin(ar,k);
//	            int totalPerm = getNumberOfPermutations(n, lim);
//	            System.out.println(totalPerm);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			s.close();
		}
    }
	
	public static int swaparrayformin(int[] ar, int lim){
		int k = 0;
		int index = findsmallest(ar,0,ar.length);
		while (k<lim) {
			//int indx = findsmallestformIndex(ar,index,ar.length);
			swap(ar, 0, index);
			k++;
		}
		return 0;
	}
	
	public static void swap(int[] ar, int t, int fr){
		
	}
	
	public static int findsmallest(int[] a,int f, int l) {
		int small = a[f];
		int index = f;
	    for (int i = f; i < l - 1; i++) {
	        if (small >= a[i + 1]) {
	           small = a[i + 1];
	           index = i + 1;
	        }
	    }
	    System.out.println("index of smallest element : "+index);
	    return index;
	}
	
	public static int findsmallestformIndex(int[] a,int f, int l) {
		int small = a[0];
		int index = 0;
	    for (int i = 0; i < l - 1; i++) {
	        if (small >= a[i + 1] && i!=f) {
	           small = a[i + 1];
	           index = i + 1;
	        }
	    }
	    System.out.println("index of smallest element by index : "+index);
	    return index;
	}
//	public static int getNumberOfPermutations(int numb, int limit){
//		
//		
//		return 0;		
//	}
}
