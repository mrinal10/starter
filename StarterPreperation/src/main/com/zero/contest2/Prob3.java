package com.zero.contest2;

import java.util.Scanner;

public class Prob3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {

			while (true) {
				long t = sc.nextLong();
				if (t != 0) {

					long total = (t * (t + 1) * (2 * t + 1)) / 6;
					System.out.println(total);
				} else {
					break;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		sc.close();
	}
}
