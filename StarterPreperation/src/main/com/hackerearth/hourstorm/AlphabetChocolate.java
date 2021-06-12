package com.hackerearth.hourstorm;

import java.util.HashSet;
import java.util.Scanner;

public class AlphabetChocolate {

	static String v;
	static HashSet<Integer> sett;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			sett = new HashSet<Integer>();
			v = sc.next();
			v.toLowerCase();
			char[] ar = v.toCharArray();
			for (int i = 0; i < ar.length; i++) {
				if (ar[i] == 'a' || ar[i] == 'e' || ar[i] == 'i' || ar[i] == 'o' || ar[i] == 'u') {
					sett.add(i);
				}
			}
			
			System.out.println(sett.size()*v.length());
		}
		sc.close();
	}

}
