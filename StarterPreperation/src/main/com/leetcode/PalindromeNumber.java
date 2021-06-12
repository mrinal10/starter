package com.leetcode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length/2; i++) {
			if (arr[i]!=arr[arr.length-1-i]) {
				return false;
			}
		}
		return true;
	}
}
