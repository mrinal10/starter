package com.barclays.hiring24082018;

import java.util.Scanner;

public class EatingChocolate {

	private static final String ALICE = "A";
	private static final String BOB = "B";

	private static float findRoot(float sumGiven) {
		float firstRoot = (float) (((-1)+(Math.sqrt(((8)*sumGiven)+1)))/2.0);
		return firstRoot;
	}

	private static String eatChocolate(long lengthOfBar) {
		float rootValue = findRoot(lengthOfBar);
		rootValue = (float) Math.floor(rootValue);
		if (rootValue % 2 != 0) {
			return ALICE;
		}
		return BOB;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		while (testCase-- > 0) {
			long lenOfBar = s.nextLong();
			System.out.println(eatChocolate(lenOfBar));
		}
		s.close();
	}

}
