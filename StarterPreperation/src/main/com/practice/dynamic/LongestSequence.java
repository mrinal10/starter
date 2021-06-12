package com.practice.dynamic;

import java.util.Scanner;

public class LongestSequence {
	private static int max(int n, int m){
		if (n>m) {
			return n;
		}
		return m;
	}
	
	private static int LongestIncrSubseq(int[] arr){
		int n = arr.length;
		int[] t = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					t[i] = max(t[i], t[j]+1);
				}
			}
		}
		return t[n-1]+1;
	}
	
	private static int LongestdecrSubseq(int[] arr){
		int n = arr.length;
		int[] t = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					t[i] = max(t[i], t[j]+1);
				}
			}
		}
		return t[n-1]+1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(LongestIncrSubseq(arr)+" :: "+LongestdecrSubseq(arr));
		sc.close();
	}
}
