package com.zero.strings;

public class LongestPalindromeSubstringII {

	public static void main(String[] args) {
		LongestPalindromeSubstringII lps = new LongestPalindromeSubstringII();
        System.out.println(lps.longestPalindromeSubstringEasy("wertbabbabc"));
	}
	
	public String longestPalindromeSubstringEasy(String s) {
    	char[] arr = s.toCharArray();
        int longestSubstring = 1;
        String palindromicSubstring = "";
        for (int i = 0; i < arr.length; i++) {
            int x = i;
            int y = i + 1;
            int palindrome = 0;
            while (x >= 0 && y < arr.length && arr[x] == arr[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            longestSubstring = Math.max(longestSubstring, palindrome);
            if (palindrome==longestSubstring) {
            	palindromicSubstring = s.substring(x+1, y);
			}
            x = i - 1;
            y = i + 1;
            palindrome = 1;
            while (x >= 0 && y < arr.length && arr[x] == arr[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            longestSubstring = Math.max(longestSubstring, palindrome);
            if (palindrome==longestSubstring) {
            	palindromicSubstring = s.substring(x+1, y);
			}
        }
        return palindromicSubstring;
    }


}
