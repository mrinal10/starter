package com.gfg.arrays;

public class StockBuySell {
	public int maxProfit(int[] prices) {
		return maxProfit(prices, 0, prices.length - 1);
	}

	public int maxProfit(int[] prices, int start, int end) {
		if (start > end) {
			return 0;
		}
		int profit = 0;
		for (int i = start; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				if (prices[j] > prices[i]) {
					int curr_profit = (prices[j] - prices[i]) 
							+ maxProfit(prices, 0, i - 1)
							+ maxProfit(prices, j + 1, end - 1);
					profit = Math.max(profit, curr_profit);
				}
			}
		}
		return profit;
	}

	int maxProfit2(int prices[], int start, int end) {
		int sum = 0;
		int n = prices.length;
		for (int i = 0; i < n - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				sum += (prices[i + 1] - prices[i]);
			}
		}
		return sum;
	}
}
