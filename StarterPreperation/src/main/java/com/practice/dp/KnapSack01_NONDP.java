package com.practice.dp;

public class KnapSack01_NONDP {
	static int val[] = new int[] { 60, 100, 120 };
	static int wt[] = new int[] { 10, 20, 30 };

	public static void main(String args[]) {
		int W = 55;
		System.out.println(knapSack(W, 0));
	}

	private static int knapSack(int w, int n) {
		if (w == 0 || n >= val.length) {
			return 0;
		}
		if (wt[n] > w) {
			return knapSack(w, n + 1);
		}
		return Math.max(val[n] + knapSack(w - wt[n], n + 1), knapSack(w, n + 1));
	}

}
