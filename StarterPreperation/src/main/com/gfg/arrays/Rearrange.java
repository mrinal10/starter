package com.gfg.arrays;

public class Rearrange {
	static void arrange(int[] arr, int n) {
		for(int i=0; i<n; i++) {
			System.out.println("Before >>"+arr[i]);
			arr[i] += (arr[arr[i]]%n)*n;
			System.out.println("After >>"+arr[i]);
		}
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
		for(int i=0; i<n; i++) {
			arr[i] = arr[i]/n;
			System.out.println(" >>"+arr[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3,1,4,2,0};
		arrange(arr, arr.length);
	}
}
