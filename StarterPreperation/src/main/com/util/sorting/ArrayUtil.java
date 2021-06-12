package com.util.sorting;

import java.util.Scanner;

public class ArrayUtil {

	public static void printAll(int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+" ");
		}
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	public static int[] inserttoArray(int n) {
		int[] r = new int[n];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<r.length; i++) {
			r[i] = sc.nextInt();
		}
		sc.close();
		return r;
	}
	
	public static int[] swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
		return ar;
	}
	
}
