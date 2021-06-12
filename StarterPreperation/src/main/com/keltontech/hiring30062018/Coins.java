package com.keltontech.hiring30062018;

import java.util.Arrays;
import java.util.Scanner;

public class Coins {
	
	private static boolean check(int[] ar){
		int lStart = 0;
		int rStart = ar.length-1;
		int lSum = 0;
		int rSum = 0;
		lSum += ar[lStart];
		lStart++;
		while (lStart<rStart) {
			if (lSum<rSum) {
				lSum += ar[lStart];
				lStart++;
			}
			if(rSum<lSum){
				rSum += ar[rStart];
				rStart--;
			}
			if (lSum==rSum && checkIfSame(ar, lStart, rStart)) {
				return true;
			}
		}
		return false;
		
	}
	
	private static boolean checkIfSame(int[] ar, int l, int r){
		int mark = ar[l];
		for (int i = l+1; i <=r; i++) {
			if (mark!=ar[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		int ar[] = new int[testCases];
		for (int i = 0; i < testCases; i++) {
			ar[i]=sc.nextInt();
		}
		Arrays.sort(ar);
		if(check(ar)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		
		sc.close();
	}
}
