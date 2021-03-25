package com.practice.opt.um;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem5 {

	public static void main(String[] args) {
		int[] projectId = { 2, 0, 1, 2 };
		int[] bid = { 8, 7, 6, 9 };

		System.out.println(getMinExpenditure(projectId, bid));
	}

	private static int getMinExpenditure(int[] project, int[] prices) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < project.length; i++) {
			int projectId = project[i];
			int quotedPrice = prices[i];

			if (map.containsKey(projectId)) {
				int prevPrice = map.get(projectId);
				if (prevPrice > quotedPrice) {
					map.put(projectId, quotedPrice);
				}
			} else {
				map.put(projectId, quotedPrice);
			}
		}
		int totalPrice = map.entrySet().stream().mapToInt(Map.Entry<Integer, Integer>::getValue).sum();
		return totalPrice;
	}
}
