package com.zero.contest3;

import java.util.Scanner;

public class P1 {
	private int getLen(int v){
		int cnt=0;
		while (v!=0) {
			cnt++;
			v=v/10;
		}
		return cnt;
	}
	private static boolean findvalue(int len, char[] s){
		if (len>s.length/2) {
			return false;
		}
		String s1 = "";
		int i = 0;
		for (i = 0; i < len; i++) {
			s1 = s1+s[i];
		}
		String s2 = "";
		for (int j = i; j < len; j++) {
			s2 = s2+s[j];
		}
		int next = Integer.parseInt(s1)+Integer.parseInt(s2);
		
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			String s = sc.next();
			if (findvalue(1, s.toCharArray())) {
				System.out.println("Valid");
			}else{
				System.out.println("Invalid");
			}
		}
		sc.close();
	}
	
}
