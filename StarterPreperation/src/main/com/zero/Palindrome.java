package com.zero;

public class Palindrome {
	static boolean isPaliDrome(String s, int l, int r){
		while(l<r){
			System.out.println(s.substring(l, l+1));
			if(s.substring(l, l+1).equalsIgnoreCase(s.substring(r, r+1)) ){
				l++;
				r--;
			}else{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "RACEcar";
		System.out.println(isPaliDrome(s, 0, s.length()-1));

	}

}
