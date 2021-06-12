package com.practice;

import java.io.IOException;
import java.util.Scanner;

public class CanyousolveIT {

	public static void main(String[] args) throws IOException {
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
					// TODO: handle exception
				}
			}
			
			getMaximum(ar);
		}

	}
	
	private static void getMaximum(int[] ar){
		int length = ar.length;
		int[][] array = new int[length][length];
		int maxVal = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = getmodVal(ar[i], ar[j]) + getmodVal(i, j);
				//System.out.println(i+"  :::::  "+j+" :::array[i][j] :: "+array[i][j]);
				if (maxVal<array[i][j]) {
					maxVal = array[i][j];
				}
			}
		}
		System.out.println(maxVal);
	}
	
	private static int getmodVal(int n, int m){
		if ((n-m)<0) {
			return (m-n);
		} else {
			return n-m;
		}
	}

}