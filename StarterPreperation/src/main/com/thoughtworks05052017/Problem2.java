package com.thoughtworks05052017;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		try {
			
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int Q = sc.nextInt();
			
			String A = sc.next();
			String B = sc.next();
			StringBuilder A1 = new StringBuilder(A);
			StringBuilder B1 = new StringBuilder(B);
			for (int i = 0; i < Q; i++) {
				int n = sc.nextInt();
				B1.setCharAt(n-1, '1');
				compareNumbers(A1, B1, N);
			}

		} catch (Exception e) {
		}
	}
	
	private static void compareNumbers(StringBuilder A, StringBuilder B, int n){
		for (int i = 0; i < n; i++) {
			if(A.charAt(i)=='0' && B.charAt(i)=='1'){
				System.out.println("YES");
				return;
			}else if(A.charAt(i)=='1' && B.charAt(i)=='0'){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
