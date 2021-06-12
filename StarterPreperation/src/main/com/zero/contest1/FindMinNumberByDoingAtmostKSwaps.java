package com.zero.contest1;

import java.util.Scanner;

public class FindMinNumberByDoingAtmostKSwaps {

	private static void swap(int[] c, int i, int j) {
		int ch = c[i];
		c[i] = c[j];
		c[j] = ch;
	}
	
	private static int customComapare(int[] c, int[] d){
		for (int i = 0; i < d.length; i++) {
			if (c[i]<d[i]) {
				return -1;
			}else if(c[i]>d[i]){
				return 1;
			}
		}
		return 0;
	}

	public static int[] findMinimum(int[] c, int n, int k, int[] minArrSofar) {
		
		if(k<0){
			return minArrSofar;
		}
		if (k < 1) {
			if (customComapare(c, minArrSofar) < 0) {
				for(int i=0; i<c.length; i++){
					minArrSofar[i] = c[i];
				}
			}
			
			return minArrSofar;
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j <=i+1; j++) {
				if (c[i] > c[j]) {
					swap(c, i, j);
					minArrSofar = findMinimum(c, n, k - 1, minArrSofar);
					swap(c, i, j);
				}
			}
		}
		return minArrSofar;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			int n = sc.nextInt();
			int kswaps = sc.nextInt();
			int[] ch = new int[n];
			int[] minArrSofar = new int[n];
			for (int i = 0; i < n; i++) {
				ch[i] = sc.nextInt();
				minArrSofar[i] = ch[i];
			}
			
			int[] minimum = findMinimum(ch, ch.length, kswaps, minArrSofar);
			for(int i=0; i<minimum.length; i++){
				System.out.print(minimum[i]+" ");
			}
		}
		sc.close();
	}
}