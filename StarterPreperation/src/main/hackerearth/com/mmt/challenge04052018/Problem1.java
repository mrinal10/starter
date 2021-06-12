package com.mmt.challenge04052018;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		for(int i =0; i<t; i++) {
			int n = sc.nextInt();
			int[] ar = new int[n];
			int total = 0;
			for(int j=0; j<n; j++) {
				ar[j] = sc.nextInt();
				if (ar[j]>0) {
					total += ar[j];
				}
			}
			if (isPowerOf2(total)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			
		}
		sc.close();
	}
	
	private static boolean isPowerOf2(int n) {
		if (n == 0)
            return false;
         
        while (n != 1)
        {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
	}
}
