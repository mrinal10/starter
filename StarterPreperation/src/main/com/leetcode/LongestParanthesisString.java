package com.leetcode;


public class LongestParanthesisString {
	public static int longestValidParentheses(String s) {
        int balancer = 0;
		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='(' ) {
				balancer++;
				count++;
			}else if (s.charAt(i)==')' ) {
				balancer--;
				if (balancer >= 0) {
					count++;
				}
				
			}
			if (balancer<0) {
				count = 0;
				maxCount = 0;
			}
			if (maxCount<count && balancer==0) {
				maxCount = count;
			}
		}
		return maxCount;
    }

	public static void main(String[] args) {
		String s = "))))(()()()()((((())))))";
		System.out.println(longestValidParentheses(s));

	}

}
