package com.practice.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestCommonSubsequenc {
	
	private static int max(int n, int m){
		if (n>m) {
			return n;
		}
		return m;
	}

	private static int LcS(String s1, String s2){
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] ni = new int[l1+1][l2+1];
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i==0 || j==0) {
					ni[i][j] = 0;
				}else if (s1.charAt(i-1) == s2.charAt(j-1)) {
					ni[i][j] = ni[i-1][j-1]+1;

				}else if(s1.charAt(i-1)!=s2.charAt(j-1)){
					ni[i][j] = max(ni[i-1][j], ni[i][j-1]);
				}
//				System.out.print(ni[i][j]+" ");
			}
//			System.out.println();
		}
//		printString(ni, s1, s2);
		return ni[l1][l2];
	}
	
	private static int LrepeatingSubsequence(String s1){
		int l1 = s1.length();

		int[][] ni = new int[l1+1][l1+1];
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l1; j++) {
				if (i==0 || j==0) {
					ni[i][j] = 0;
				}else if ((s1.charAt(i-1) == s1.charAt(j-1)) && i!=j) {
					ni[i][j] = ni[i-1][j-1]+1;
				}else{
					ni[i][j] = max(ni[i-1][j], ni[i][j-1]);
				}
				System.out.print(ni[i][j]+" ");
			}
			System.out.println();
		}
		return ni[l1][l1];
	}
	
	private static void printString(int[][] arr, String s1, String s2){
		int i=1;
		int j=1;
		StringBuilder s= new StringBuilder();
		
		while (i<=s1.length() && j<=s2.length()) {
			System.out.println(i+" :: "+j);
			if (s1.charAt(i-1) == s2.charAt(j-1)) {
				s.append(s1.charAt(i-1));
				System.out.println(" >>>>> "+s1.charAt(i-1));
				i++;
				j++;
			} else if(arr[i-1][j] > arr[i][j-1]) {
				i++;
			} else{
				j++;
			}
		}
		System.out.println(" >>>>> "+s.toString());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(LcS(s1, s2));
//		 System.out.println(LrepeatingSubsequence(s1));
		sc.close();
	}
}
