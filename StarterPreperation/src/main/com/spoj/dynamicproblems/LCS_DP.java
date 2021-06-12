package com.spoj.dynamicproblems;

import java.util.Arrays;
import java.util.Scanner;

public class LCS_DP {
	char[] gA;
	char[] gB;
	int[][] gArr;
	
	int lcsLenH(int indxA, int indxB){
		if(indxA<0 || indxB<0){
			return 0;
		}
		if(gArr[indxA][indxB]!=-1){
			return gArr[indxA][indxB];
		}
		
		if(gA[indxA]==gB[indxB]){
			gArr[indxA][indxB] = 1+lcsLenH(indxA-1, indxB-1);
		}else{
			gArr[indxA][indxB] = Math.max(lcsLenH(indxA-1, indxB), lcsLenH(indxA,indxB-1));
		}
		return gArr[indxA][indxB];
	}
	
	int lcsLen(char[] a, char[] b){
		gArr = new int[1000][1000];
		gA = a;
		gB = b;
		for (int i = 0; i < 1000; i++) {
			Arrays.fill(gArr[i], -1);
		}
		return lcsLenH(a.length-1, b.length-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		LCS_DP lcs = new LCS_DP();
		System.out.println(lcs.lcsLen(s1.toCharArray(), s2.toCharArray()));
		sc.close();
	}
}
