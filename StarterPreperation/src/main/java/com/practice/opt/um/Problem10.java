package com.practice.opt.um;

public class Problem10 {
	
	public static void main(String[] args) {
		System.out.println(getCombinationCount(3, 2));
	}

	private static long getCombinationCount(int m, int w) {
		if (m == 0 || w == 0) {
			return 0;
		}		
		return (combinations(m, 1)*combinations(w, 1)*combinations(m+w-2, 1)) /2;
	}

	private static long combinations(int m, int n) {
		long comb = factorial(m) / (factorial(n) * factorial(m - n));
		return comb;
	}

	private static long factorial(int n) {
		long fact = 1;
		long i = 1;
		while (i <= n) {
			fact *= i;
			i++;
		}
		return fact;
	}
}
