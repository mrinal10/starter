package com.problems.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {

	}

	public int longestPalindromeSubseq(String s) {
		Map<String, Integer> map = new HashMap<>();
		return longestPalindromeSubseqImpl(s, 0, s.length() - 1, map);
	}

	

	public int longestPalindromeSubseqImpl(String s, int indxA, int indxB, Map<String, Integer> map) {
		if (indxA > indxB) {
			return 0;
		}

		if (indxA == indxB) {
			return 1;
		}

		String key = indxA + "|" + indxB;

		if (!map.containsKey(key)) {
			if (s.charAt(indxA) == s.charAt(indxB)) {
				map.put(key, longestPalindromeSubseqImpl(s, indxA + 1, indxB - 1, map) + 2);
			} else {
				map.put(key, Integer.max(longestPalindromeSubseqImpl(s, indxA, indxB - 1, map),
						longestPalindromeSubseqImpl(s, indxA + 1, indxB, map)));
			}
		}
		return map.get(key);
	}
}
