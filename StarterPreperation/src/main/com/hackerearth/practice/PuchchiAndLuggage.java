package com.hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PuchchiAndLuggage {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			int[] ar = new int[t];
			for (int j = 0; j < t; j++) {
				ar[j] = Integer.parseInt(br.readLine());
			}
			
			for (int j = 0; j < t; j++) {
				int count = 0;
				for (int k = j + 1; k < t; k++) {
					if (k == t)
						break;
					if (ar[j] > ar[k]) {
						count++;
					}
				}
				System.out.print(count+" ");
			}
			System.out.println();
		}
	}

}
