package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		int longestTillNow = 0;
		for (int i = 0; i < s.length() - longestTillNow; i++) {
			int count = 0;
			Set<Character> charSet = new HashSet<>();
			for (int j = i; j < s.length(); j++) {
				if ( charSet.contains(s.charAt(j)) ) {
					break;
				}else{
					charSet.add(s.charAt(j));
					count++;
				}
			}
			if (count>longestTillNow) {
				longestTillNow = count;
			}
		}
		return longestTillNow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
