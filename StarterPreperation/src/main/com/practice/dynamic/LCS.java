package com.practice.dynamic;

import java.util.Scanner;

public class LCS {
	
	private static int max(int n, int m){
		if (n>m) {
			return n;
		}
		return m;
	}

	private static int lcsLen(char[] s1, char[] s2){
		int l1 = s1.length;
		int l2 = s2.length;
		int[][] mem = new int[l1+1][l2+1];
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i==0 || j==0) {
					mem[i][j] = 0;
				}else if (s1[i-1] == s2[j-1]) {
					mem[i][j] = mem[i-1][j-1]+1;
				}else if(s1[i-1]!=s2[j-1]){
					mem[i][j] = max(mem[i-1][j], mem[i][j-1]);
				}
			}
		}
		return mem[l1][l2];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(lcsLen(s1.toCharArray(), s2.toCharArray()));
		sc.close();
	}
}