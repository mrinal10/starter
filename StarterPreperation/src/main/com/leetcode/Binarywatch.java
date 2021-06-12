package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Binarywatch {
	static HashSet<String> set = new HashSet<>(); 
	
	private static int[] swap(int[] arr, int i, int j){
		int tempVal = arr[i];
		arr[i] = arr[j];
		arr[j] = tempVal;
		
		return arr;
	}
	
	private static void createAllCombinations(int[] arr, int l, int h){
		if(l==h){
			set.add(Arrays.toString(arr));
			
		}else{
			for(int i=l; i<=h; i++){
				swap(arr,l,i);
				createAllCombinations(arr, l+1, h);
				swap(arr,l,i);
			}
		}
	}
	
	private static void printAlltimes(){
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String is = (String) iterator.next();
			convertToTime(is);
		}
	}
	
	private static void convertToTime(String arr){
		String[] arrr = arr.substring(1, arr.length()-1).split(",");
		int hr = 0;
		for(int i=0; i<4; i++){
			hr += Integer.parseInt(arrr[i].trim())*Math.pow(2, (3-i));
		}
		int min = 0;
		for(int i=4; i<10; i++){
			min += Integer.parseInt(arrr[i].trim())*Math.pow(2, (9-i));
		}
		String minInStr = "";
		if(min<10){
			minInStr = 0+""+min;
		}else{
			minInStr = String.valueOf(min);
		}
		System.out.print(hr+":"+minInStr+" ");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfOnes = sc.nextInt();
		int[] arrForTime = new int[10];
		int n = 10;
		for(int i=0; i<n; i++){    //initilizing array with given no of 1's
			if(numberOfOnes-->0){
				arrForTime[i] = 1;
			}else{
				arrForTime[i] = 0;
			}
		}
		createAllCombinations(arrForTime, 0, n-1);
		printAlltimes();
		sc.close();
	}

}
