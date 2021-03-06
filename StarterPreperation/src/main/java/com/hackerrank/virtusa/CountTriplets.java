package com.hackerrank.virtusa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {
	static long countTriplets(List<Long> a, Long r) {
		int lengthOfList = a.size();
		Map<Long, Integer> left = new HashMap<>(), right = new HashMap<>();
		long ans = 0;
		for (int i = 0; i < lengthOfList; i++)
			right.put(a.get(i), right.getOrDefault(a.get(i), 0) + 1);

		for (int i = 0; i < lengthOfList; i++) {
			long countOfSmallest = 0, countOfLargest = 0;
			if (a.get(i) % r == 0)
				countOfSmallest = left.getOrDefault(a.get(i) / r, 0);
			right.put(a.get(i), right.getOrDefault(a.get(i), 0) - 1);
			countOfLargest = right.getOrDefault(a.get(i) * r, 0);
			ans += countOfSmallest * countOfLargest;
			
			left.put(a.get(i), left.getOrDefault(a.get(i), 0) + 1);
		}
		return ans;
	}
	public static void main(String[] args) {
		
	}
}
