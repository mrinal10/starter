package com.practice.optum;

import java.util.Collections;
import java.util.List;

public class AdditionalProb {

	public static int stockPairs(List<Integer> arr, long K) {
		int cntPairs = 0;
		Collections.sort(arr);

		int i = 0;

		int N = arr.size();
		int j = N - 1;

		while (i < j) {
			if (arr.get(i) + arr.get(j) == K) {
				while (i < j && arr.get(i) == arr.get(i + 1)) {
					i++;
				}
				while (i < j && arr.get(j) == arr.get(j - 1)) {
					j--;
				}
				cntPairs += 1;
				i++;
				j--;
			} else if (arr.get(i) + arr.get(j) < K) {
				i++;
			} else {
				j--;
			}
		}
		return cntPairs;
	}
}
