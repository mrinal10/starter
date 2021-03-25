package com.practice.opt.um;

import java.util.HashMap;
import java.util.Map;


public class Problem9 {
	public static void main(String[] args) {
		int[] stocksProfit = { 5, 7, 9, 13, 11, 6, 6, 3, 3 };
		System.out.println(getDistinctPairCount(stocksProfit, 12));

	}

	private static int getDistinctPairCount(int[] pairs, int target) {
		int count = 0;
		Map<Integer, Integer> distinctElementMap = new HashMap<>();
		for (int i = 0; i < pairs.length; i++) {
			int cnt = 0;
			if (distinctElementMap.containsKey(pairs[i])) {
				cnt = distinctElementMap.get(pairs[i]);
			}
			cnt++;
			distinctElementMap.put(pairs[i], cnt);
		}

		for (Map.Entry<Integer, Integer> entry : distinctElementMap.entrySet()) {
			int k = entry.getKey();
			int rem = target - k;
			if(rem!=k) {
				if (distinctElementMap.containsKey(rem)) {
					count++;
				}
			}else {
				int freq = entry.getValue();
				if(freq>=2) {
					count++;
				}
			}
			//System.out.println(k+" :: cnt :: "+count);
		}
		return count / 2;
	}
}
