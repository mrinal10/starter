package com.leetcode;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length==0) {
			return "";
		}
		String s1 = strs[0];
		for (int i = 1; i < strs.length; i++) {
			s1 = longestCommonPrefixUtil(s1, strs[i]);
		}
		return s1;
	}

	public String longestCommonPrefixUtil(String str1, String str2) {
		StringBuilder stringBuilder = new StringBuilder();
		
		int maxLen = Math.min(str1.length(), str2.length());
		for (int i = 0; i < maxLen; i++) {
			if (str1.charAt(i)==str2.charAt(i)) {
				stringBuilder.append(String.valueOf(str1.charAt(i)));
			}else{
                break;
            }
		}
		return String.valueOf(stringBuilder);

	}
}
