package com.practice.spoj;

import java.util.Scanner;

public class IITKWPCN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int W = sc.nextInt();
			int B = sc.nextInt();
			double ans=0;
		    if(B%2==1)
		       ans=1;
		    System.out.printf("%.6f",ans);
		    System.out.println();
		}
		sc.close();
	}
}
