package com.expedia.hiring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class ChocolateDistribution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String[] temp = br.readLine().split(" ");
			int N = Integer.parseInt(temp[0]);
			int M = Integer.parseInt(temp[1]);
			String[] arrChocolates = br.readLine().split(" ");
			int[] chocolates = new int[N];
			for (int i_chocolates = 0; i_chocolates < arrChocolates.length; i_chocolates++) {
				chocolates[i_chocolates] = Integer.parseInt(arrChocolates[i_chocolates]);
			}

			int out_ = solution(chocolates, M, N);
			System.out.println(out_);
		}

		wr.close();
		br.close();
	}

	static int solution(int[] arr, int m, int n) {
		HashMap<Integer, Integer> um = new HashMap<Integer, Integer>();
		int[] sum = new int[n];
		int currRem;
		int maxSum = 0;

		sum[0] = arr[0];
		for (int i = 1; i < n; i++)
			sum[i] = sum[i - 1] + arr[i];

		for (int i = 0; i < n; i++) {
			currRem = sum[i] % m;
			if (currRem == 0) {
				if (maxSum < sum[i])
					maxSum = sum[i];
			}
			else if (!um.containsKey(currRem))
				um.put(currRem, i);

			else if (maxSum < (sum[i] - sum[um.get(currRem)]))
				maxSum = sum[i] - sum[um.get(currRem)];
		}
		return (maxSum / m);
	}

}
