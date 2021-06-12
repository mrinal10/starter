package com.geekforgeeks;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MaximumSubArrayUniqueValuesSum {
	static Set<Long> uniqueSums = new HashSet<>();

	static int[] ar;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		System.out.println(getAllUniqueValuesSums());
		sc.close();
	}

	static long getAllUniqueValuesSums() {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				long sumValue = maxSubArraySum(i, j);
				
				if(sumValue!=Integer.MIN_VALUE)
				    uniqueSums.add(sumValue);
			}
		}
		long sumValue = 0;
		Iterator<Long> itr = uniqueSums.iterator();
		while (itr.hasNext()) {
			sumValue += itr.next();
		}
		return sumValue;

	}

	static long maxSubArraySum(int startingIndx, int endingIndx) {
		long maxSoFar = Integer.MIN_VALUE;
		long maxEndingHere = 0;

		for (int i = startingIndx; i <= endingIndx; i++) {
			maxEndingHere = maxEndingHere + ar[i];

			if (maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
			if (maxEndingHere < 0)
				maxEndingHere = 0;
		}
		return maxSoFar;
	}
}