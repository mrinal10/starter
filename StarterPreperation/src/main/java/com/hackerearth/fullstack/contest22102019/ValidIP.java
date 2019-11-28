package com.hackerearth.fullstack.contest22102019;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ValidIP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		StringTokenizer st = new StringTokenizer(s, ".");
		if(isValid(st)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		sc.close();
	}
	
	private static boolean isValid(StringTokenizer st) {
		if(!isCountFour(st) || !isPrimeValidated(st)) {
			return false;
		}
		return true;
	}
	
	private static boolean isPrimeValidated(StringTokenizer st) {
		int cnt = 1;
		int starting = 0;
		while(st.hasMoreTokens()) {
			if(cnt == 1 || cnt == 4) {
				starting = 1;
			}else {
				starting = 0;
			}
			String token = st.nextToken();
			int individualNode = 0;
			try {
				individualNode = Integer.parseInt(token);
			} catch (Exception e) {
				return false;
			}
			if(individualNode<starting || individualNode>255 ) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isCountFour(StringTokenizer st) {
		if(st.countTokens()!=4)
			return false;
		return true;
	}
}
