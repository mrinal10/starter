package com.zero;

import java.util.ArrayList;
import java.util.Scanner;

public class MajorityElementOptimized2 {
	
	int findElement(int[] ar){
		int maxIndx = 0;
		int count = 1;
		for (int i = 0; i < ar.length; i++) {
			if(ar[maxIndx] == ar[i]){
				count++;
			}else{
				count--;
			}
			if(count==0){
				maxIndx = i;
				count = 1;
			}
		}
		return ar[maxIndx];
	}
	
	boolean isReallyMajority(int valu, int[] arr, int trgt){
		
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if(valu==arr[i]){
				cnt++;
			}
		}
		if (cnt>trgt) {
			return true;
		}
		return false;
	}
	
	int[] processArr(int[] ar){
		ArrayList<Integer> aList = new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]!=0){
				aList.add(ar[i]);
			}
		}
		int[] newAr = new int[aList.size()];
		for (int i = 0; i < newAr.length; i++) {
			newAr[i] = aList.get(i);
		}
		return newAr;
	}
	
	void printMajority(int b[]){
		
		int a[] = processArr(b);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		int trgt = a.length/2;
		int value = findElement(a);
		if(isReallyMajority(value, a, trgt)){
			System.out.println(value);
		}else{
		System.out.print("NONE");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 1, 6, 2, 3, 6,6,6,7,6,1,6,6}; 
		MajorityElementOptimized2 majElemnt = new MajorityElementOptimized2();
		System.out.println(majElemnt.findElement(arr));
	}
}
