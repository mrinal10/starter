package com.apostek.hiring24082018;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		int bestSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int curSum=0;
			int indx = 0;

			for (int j = 1; i+j<arr.length ; j++) {
				int tempSum = 0;
				int ij = 0;
				if(indx+j<=arr.length){
					for (ij = indx; ij < indx+j; ij++) {
						tempSum = tempSum+arr[ij];
					}
				}
				indx = ij;
				curSum += tempSum;
			}
			if(bestSum<curSum){
				bestSum = curSum;
			}
		}
		System.out.println(bestSum);
		sc.close();
	}
}
