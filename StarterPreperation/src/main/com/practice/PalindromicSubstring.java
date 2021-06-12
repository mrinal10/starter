package com.practice;

import java.util.*;

public class PalindromicSubstring {
	public static void main(String args[] ) throws Exception {
		/*
	     * Read input from stdin and provide input before running
	     * Use either of these methods for input
	
	    //BufferedReader
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String line = br.readLine();
	    int N = Integer.parseInt(line);
	*/
	    //Scanner
	    Scanner s = new Scanner(System.in);
	    String N = s.next();
	    if (isPalindrome(N)) {
			System.out.println("YES");
		} else{
			System.out.println("NO");
		}
	}
	
	private static boolean isPalindrome(String N){
		boolean flag = false;
		for(int i=0;i<N.length()/2;i++){
			if (N.charAt(i)==N.charAt(N.length()-1-i)) {
				flag = true;
			} else{
				return false;
			}
		}
		return flag;
	}
}
