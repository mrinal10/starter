package com.practice.greedy;

import java.util.Scanner;

public class MinimumNumberofCoins {
	static int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int length = coins.length;
		int deenom = n;
		int coinCount = 0;
			while (n!=0 && length>0) {
				coinCount += deenom/coins[length-1];
				deenom = deenom%coins[length-1];
				length--;
			}
		System.out.println(coinCount);
		sc.close();
	}
}
