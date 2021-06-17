package com.wipro;

import java.util.Scanner;

public class MaxSum {
	public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
			 int N = s.nextInt();
			 if (N%2==0) {
				N = N-1;
			 }
			 int sum = 0;
			 for (int j = 1; j <= N; j++) {
				 sum = (int) (sum+(Math.pow(-1,j+1)*j*(j+1)));
				 //System.out.println("sum :: "+sum);
			}
			 System.out.println(">>>>> "+sum);
        }
	}
}
