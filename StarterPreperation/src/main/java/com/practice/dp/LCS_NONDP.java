package com.practice.dp;

public class LCS_NONDP {
	private static int getLCS(String str, int indx, String matcher, int indy) {
		if(indx>=str.length() || indy>=matcher.length()) {
			return 0;
		}
		if(str.charAt(indx) == matcher.charAt(indy)) {
			return 1+getLCS(str, indx+1, matcher, indy+1);
		}
		return Math.max(getLCS(str, indx+1, matcher, indy), getLCS(str, indx, matcher, indy+1));
	}
	public static void main(String[] args) {
		String X = "AGGTAB"; 
        String Y = "GXTXAYB";
        System.out.println(getLCS(X, 0, Y, 0));
	}
}
