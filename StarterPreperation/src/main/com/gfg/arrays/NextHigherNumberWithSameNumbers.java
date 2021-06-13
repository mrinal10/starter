package com.gfg.arrays;

import java.util.Arrays;


public class NextHigherNumberWithSameNumbers {
	public static String findNextHigher(String s) {
		String sret = "-1";
		char[] ar = s.toCharArray();
		int indxOfMin = -1;
		
		for(int i=ar.length-2; i>=0; i--) {
			if(ar[i]<ar[i+1]) {
				indxOfMin = i;
				break;
			}
		}
		if(indxOfMin==-1) {
			return "-1";
		}
		
		int nextMinIndx = ar.length-1;
		int nextMinV = ar[ar.length-1];
		for(int i=ar.length-2; i>indxOfMin; i--) {
			if(nextMinV > ar[i]) {
				nextMinIndx = i;
			}
		}
		
		//swap
		char temp = ar[indxOfMin];
		ar[indxOfMin] = ar[nextMinIndx];
		ar[nextMinIndx] = temp;
		
		
		int[] arr = new int [ar.length-indxOfMin-1];
		int j = 0;
		for(int i= indxOfMin+1; i<ar.length; i++) {
			arr[j] = ar[i];
			j++;
		}
		Arrays.sort(arr);
		j=0;
		for(int i= indxOfMin+1; i<ar.length; i++) {
			ar[i] = (char) arr[j];
			j++;
		}
		sret = "";
		for(int i=0; i<ar.length; i++) {
			sret += ar[i];
		}
		
		return sret;
	}
	
	public static void main(String[] args) {
		System.out.println(findNextHigher("534976"));
	}
}
