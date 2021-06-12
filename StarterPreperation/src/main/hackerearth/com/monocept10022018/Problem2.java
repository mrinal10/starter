package com.monocept10022018;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getprimefactorsCount(n));
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int q = sc.nextInt();
//		
//		int[] ar = new int[n];
//		int[] ar1 = new int[n];
//		
//		for (int i = 0; i < ar.length; i++) {
//			ar[i] = sc.nextInt();
//			ar1[i] = getprimefactorsCount(ar[i]);
//			
//		}
//		Arrays.sort(ar1);
//		for (int i = 0; i < q; i++) {
//			int inPut = sc.nextInt();
//			int count = 0;
//			int j=0;
//			while (inPut>0 && j<n) {
//				inPut = inPut - ar1[j];
//				if (inPut>=0) {
//					count++;
//				}
//				j++;
//			}
//			System.out.println(count);
//		}
		
	}
	
	private static int getprimefactorsCount(int n) {
		int count = 0;
		if (isPrime(n)) {
			count++;
		} else {
			int temp = n;
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (isPrime(i)) {
					temp = n;
					while (temp%i == 0) {
//						System.out.println("Factors : "+i);
						count++;
						if (isPrime(temp)) {
							break;
						}
						temp = temp/i;
					}
				}
			}
		}
		return count;
	}
	
	private static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n%i ==0) {
				return false;
			}
		}
		return true;
	}

}
