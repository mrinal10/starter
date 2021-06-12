package com.hiring.byjus;

import java.util.Scanner;

public class VegetableMarket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfStalls = sc.nextInt();
		int[] stalls = new int[numberOfStalls];
		for (int i = 0; i < stalls.length; i++) {
			stalls[i] = sc.nextInt();
		}
		sc.close();
	}

}
