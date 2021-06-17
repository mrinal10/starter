package com.practice;

import java.util.Scanner;

public class CanyousolveIT_2 {
	
	public static void main(String[] args) {
		int t, n;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			int[] ar = new int[n];
			
			for (int j = 0; j < ar.length; j++) {
				try {
					ar[j] = sc.nextInt();
				} catch (Exception e) {
				}
			}
			getMaximum(ar);
		}
		sc.close();
	}
	
	private static void getMaximum(int[] ar){
		int length = ar.length;
		int minofMinusVal, maxofPlusVal, maxofMinusVal;
		int minofPlusVal = minofMinusVal = maxofPlusVal = maxofMinusVal = ar[0];
		
		for (int i = 0; i < length; i++) {
			if (minofMinusVal>(ar[i]-i)) {
				minofMinusVal=(ar[i]-i);
			}
			if (maxofMinusVal<(ar[i]-i)) {
				maxofMinusVal=(ar[i]-i);
			}
			if (minofMinusVal>(ar[i]+i)) {
				minofMinusVal=(ar[i]+i);
			}
			if (maxofPlusVal<(ar[i]+i)) {
				maxofPlusVal=(ar[i]+i);
			}
		}
		
		maxofMinusVal = maxofMinusVal - minofMinusVal;
		maxofPlusVal = maxofPlusVal - minofPlusVal;
		
		if (maxofPlusVal > maxofMinusVal) {
			System.out.println(maxofPlusVal);
		} else {
			System.out.println(maxofMinusVal);
		}
		
	}
}
