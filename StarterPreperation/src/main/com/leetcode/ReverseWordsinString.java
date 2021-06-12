package com.leetcode;

public class ReverseWordsinString {
	public String reverseWords(String s1) {
        String[] ar = s1.trim().split(" ");
        StringBuilder s = new StringBuilder();
        for(int i= ar.length-1; i>=0; i--){
            
            if (ar[i].length()>0) {
                s.append(ar[i]);
                s.append(" ");
			}
        }
        return String.valueOf(s).trim();
    }
	
	public static void main(String[] args) {
		String s = " a  b ";
		ReverseWordsinString rev = new ReverseWordsinString();
		System.out.println(rev.reverseWords(s));
	}
}
