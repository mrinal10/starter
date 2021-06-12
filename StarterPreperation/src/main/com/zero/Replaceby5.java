package com.zero;

public class Replaceby5 {
	public static void main(String[] args) {
		int n = 40904804;
		System.out.println(replaceZerosWithFives(n));
	}
	
	static int replaceZerosWithFives(int n) 
	{ 
	    String s = String.valueOf(n);
	  	StringBuilder sb = new StringBuilder(s);
	  	for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '0' ) {
				sb.setCharAt(i, '5');
			}
		}
	  	
	  	return Integer.parseInt(sb.toString());
	}
}
