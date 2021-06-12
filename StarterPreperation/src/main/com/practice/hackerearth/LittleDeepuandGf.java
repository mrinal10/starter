package com.practice.hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class LittleDeepuandGf {


	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- != 0) {
			int m = in.nextInt();
			int n = in.nextInt();
			int s[] = new int[n];
			int dp[] = new int[m + 1];
			dp[0] = 0;
			for (int i = 0; i < n; i++) {
				s[i] = in.nextInt();
				dp[s[i]] = 1;
			}
			Arrays.sort(s);
			for (int i = 1; i <= m; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j] <= i) {
						if (dp[i - s[j]] == 0) {
							dp[i] = 1;
							break;
						}
					} else
						break;
				}
			}

			if (dp[m] == 1)
				System.out.println("Little Deepu");
			else
				System.out.println("Kate");

		}
		in.close();
	}

}








