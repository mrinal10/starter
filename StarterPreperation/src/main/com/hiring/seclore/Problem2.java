package com.hiring.seclore;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
	private static int gcd(int a, int b) {
		if (a == 0 || b == 0)
			return 0;
		if (a == b)
			return a;

		if (a > b)
			return gcd(a - b, b);

		return gcd(a, b - a);
	}

	private static boolean isCoprime(int a, int b) {
		if (gcd(a, b) == 1)
			return true;
		else
			return false;
	}

	private static int findAnswer(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);

		for (int i = b.length - 1; i >= 0; i--) {
			for (int j = a.length - 1; j >= 0; j--) {
				if (isCoprime(a[j], b[i])) {
					return a[j] + b[i];
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}

		sc.close();
		System.out.println(findAnswer(a, b));

	}

}
