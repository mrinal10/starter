package com.hiring.ninjacart;

import java.util.Scanner;

public class SimilarityMeasurement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = sc.nextInt();
		}
		
		int queries = sc.nextInt();
		while(queries-->0){
			String s = sc.nextLine();
			String[] a = s.split(" ");
			int pos = 0;
			int val = 0;
			if (a.length==2) {
				pos = Integer.parseInt(a[1]);
				int i=pos-1;
				int matchV = ar[pos-1];
				int j=i;
				for(j=i; j>0; j--){
					if(matchV!=ar[j-1]){
						break;
					}
				}
				System.out.println(j+1);
			}else{
				pos = Integer.parseInt(a[1]);
				val = Integer.parseInt(a[1]);
				ar[pos-1] = val;
			}
		}
		sc.close();
	}
}
