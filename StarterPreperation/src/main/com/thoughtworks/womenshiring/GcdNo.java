package com.thoughtworks.womenshiring;

import java.util.Scanner;

public class GcdNo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases;
		try {
			testCases = sc.nextInt();
			for (int i = 0; i < testCases; i++) {
				int k = sc.nextInt();
				int n = sc.nextInt();
				
				int[] arr = new int[n];
				for (int j = 0; j < arr.length; j++) {
					arr[j] = sc.nextInt();
				}
				int opCount = 0;
				
				for (int j = 0; j < arr.length; j++) {
					int tmp = arr[j];
					//System.out.println("tmp  ::: "+tmp);
					
					int rem = 0;
					if(tmp<k){
						rem = k-tmp;
					}else{
						rem = tmp%k;
						int remAlternate = k-rem;
						if (rem>remAlternate) {
							rem = remAlternate;
						}
					}
					
					System.out.println(" ii :: "+j+" :::  "+rem);
					opCount += rem;
				}
				System.out.println(opCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
