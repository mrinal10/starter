package com.practice.walmartlabs;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfPlatforms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while (testCases-->0) {
			int numberOfTrains = sc.nextInt();
			int[] arrival = new int[numberOfTrains];
			int[] departure = new int[numberOfTrains];
			for (int i = 0; i < departure.length; i++) {
				arrival[i] = sc.nextInt();
			}
			
			for (int i = 0; i < departure.length; i++) {
				departure[i] = sc.nextInt();
			}
			Arrays.sort(arrival);
			Arrays.sort(departure);
			
			int i = 1;
			int j = 0;
            int platform = 1, minPlatform = 1;

			while (i<numberOfTrains && j<numberOfTrains) {
				if (arrival[i]<departure[j]) {
					i++;
					platform++;
					if (minPlatform<platform) {
						minPlatform = platform;
					}
				} else {
					platform--;
					j++;
				}
			}
			System.out.println(minPlatform);
		}
		sc.close();
	}
}
