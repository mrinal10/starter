package com.hackerearth.greedy;

import java.util.Scanner;

public class Ruins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sBuild = new StringBuilder(s);
		for(int i =0; i<s.length(); i++){
			
			if (s.charAt(i)=='?') {
				if (s.length()==1) {
					sBuild.setCharAt(i, 'a');
				} else if (i!=0 && i!=s.length()-1) {
					if (s.charAt(i+1)=='a' || s.charAt(i-1)=='a') {
						sBuild.setCharAt(i, 'b');
					} else {
						sBuild.setCharAt(i, 'a');
					}
				} else if (i==0) {
					if (s.charAt(i+1)=='a') {
						sBuild.setCharAt(i, 'b');
					} else {
						sBuild.setCharAt(i, 'a');
					}
				} else{
					if (s.charAt(i-1)=='a') {
						sBuild.setCharAt(i, 'b');
					} else {
						sBuild.setCharAt(i, 'a');
					}
				}
			}
			s = sBuild.toString();
		}
		System.out.println(sBuild.toString());
		sc.close();
	}
}
