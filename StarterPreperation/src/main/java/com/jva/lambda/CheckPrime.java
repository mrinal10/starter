package com.jva.lambda;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class CheckPrime {
	private static boolean isPrime(int number) {
		IntPredicate isDivisible = index -> number % index == 0;
		
		return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
	}

	public static void main(String[] args) {
		isPrime(9);
	}
}
