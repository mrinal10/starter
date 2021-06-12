package com.practice;

import java.util.Scanner;

public class SittingOrder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int hr = sc.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < ar.length; j++) {
				ar[j] = sc.nextInt();
			}
			for (int j1 = 0; j1 < hr; j1++) {
				
			
				int[] br = new int[n];
				for (int j = 0; j < ar.length; j++) {
					if (j==0) {
						if (ar.length>1) {
							if (ar[j+1]==1) {
								br[j]=1;
							}
						}else{
							br[j]=1;
						}
					}else if(j==ar.length-1 && ar[ar.length-2]==1){
						br[j]=1;
					}else{
						if (ar[j-1]==1 && ar[j+1]==1) {
							br[j] = 1;
						}
					}
				}
				ar = br;
			}
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[j]+" ");
			}
			
			
			
		}
		sc.close();
	}
}
