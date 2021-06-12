package com.hiring.gehealthcare;
/**
 * Palindromic Cuts
Given a string S of length N . Now, you need to cut the string S into N+1 non-empty substrings by performing cuts. There are lots of ways of performing the cuts in the string . For every way of performing the cuts, you need to count how many substrings will be a palindrome in that way of cut. You need to sum this count over all possible ways of cutting the string .

Input Format

The first line contains two integers  and  as input.
The second line contains the string  as input.

Output Format
 */
import java.util.Scanner;

public class Problem2 {

	private static boolean[][] dp;
	private static String s;
	private static int cnt = 0;

	public static void main(String[] args) {
		int n, k;
		Scanner sc = new Scanner(System.in);
		n = 5;//sc.nextInt();
		k = 2;//sc.nextInt();
		s = "aabbc";// sc.next();
		dp = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i==j) {
					dp[i][i] = true;
				}else{
					dp[i][j] = isPalinDrome(i, j);
				}
			}
		}
		cnt = 0;
		countPalinDromes(k+1, 0);
		System.out.println(cnt);
		sc.close();
	}

	private static void countPalinDromes(int remainingCuts, int startingIndx) {
		if (s.length() - startingIndx < remainingCuts) {
			return;
		}
		if (remainingCuts == 1) {
			if (dp[startingIndx][s.length() - 1]) {
				cnt++;
			}
			return;
		}
		for (int i = startingIndx+1; i < s.length(); i++) {
			if (dp[startingIndx][i-startingIndx]) {
				cnt++;
			}
			countPalinDromes(remainingCuts - 1, i);
		}

	}

	private static boolean isPalinDrome(int indxA, int indxB) {
		if (indxA>indxB) {
			return false;
		}
		int j = indxB;
		for (int i = indxA; i <= ((indxB + indxA) / 2); i++) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			j--;
		}
		return true;
	}
}
