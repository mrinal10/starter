package com.hackerearth.hourstorm;

import java.util.Scanner;

public class AlphabetChocolateHH {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- != 0) {
			String s = sc.next();
			int[] arr = new int[s.length() + 1];

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'o' || s.charAt(i) == 'i'
						|| s.charAt(i) == 'u') {
					arr[i] = 1;
				} else if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'O' || s.charAt(i) == 'I'
						|| s.charAt(i) == 'U') {
					arr[i] = 1;
				}
			}
			long sum = 0;
			for (int i = 0; i < s.length(); i++) {
				if (arr[i] == 1) {
					sum += ((s.length() - i) * (i + 1));
				}
			}
			System.out.println(sum);
		}

	}
}
