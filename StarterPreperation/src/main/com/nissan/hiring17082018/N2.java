package com.nissan.hiring17082018;

import java.math.BigInteger;
import java.util.Scanner;

public class N2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		BigInteger[] arr = new BigInteger[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextBigInteger();
		}
		 
		BigInteger maxValue = BigInteger.ZERO; 
		
		for (int i = 0; i < k; i++) {
			int j = arr.length-k-i;
			BigInteger sum = BigInteger.ZERO;
			for (int ll = 0; ll < i; ll++) {
				sum = sum.add(arr[ll]);
			}
			for (int j2 = arr.length-j; j2 < arr.length; j2++) {
				
				sum = sum.add(arr[j2]);
			}
			if (sum.compareTo(maxValue)>0) {
				maxValue = sum;
			}
		}
		System.out.println(maxValue);
		sc.close();
	}
}
