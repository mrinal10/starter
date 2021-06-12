package com.practice.spoj;

import java.util.Scanner;

class IITWPC4A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			String s = sc.next();
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			int maxLength = s.length();
			int minLength = s.length();
			
			for(int j=0; j<s.length()-m+1; j++) {
				String subStr = s.substring(j, j+m);
//				System.out.println("subStr >> "+subStr);
				if (isAlla(subStr)) {
					if (m>n) {
						minLength = minLength-(m-n); 
					} else {
						maxLength = maxLength+(n-m);
					}
					j = j+m-1;
				}
			}
			System.out.println(minLength+" "+maxLength);
		}
		
		sc.close();
	}
	
	public static boolean isAlla(String asTring) {
		for(int i=0;i<asTring.length(); i++) {
			if (asTring.charAt(i)!='a') {
				return false;
			}
		}
		return true;
	}
}
