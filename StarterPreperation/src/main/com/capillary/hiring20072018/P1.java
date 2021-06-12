package com.capillary.hiring20072018;

import java.util.HashMap;
import java.util.Scanner;

public class P1 {
	public static void main(String[] args) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int numInt = sc.nextInt();
			int[] ar = new int[numInt];
			for (int j = 0; j < numInt; j++) {
				ar[j] = sc.nextInt();
				if ((ar[j]&1)==0) {
					map.put(j, true);
				} else{
					map.put(j, false);
				}
			}
			int q = sc.nextInt();
			for (int j = 0; j < q; j++) {
				int sIndex = sc.nextInt();
				int eIndex = sc.nextInt();
				int cntOld = 0;
				int cntCold = 0;
				for (int k = sIndex-1; k < eIndex; k++) {
					if (map.get(k)) {
						cntOld++;
					}else{
						cntCold++;
					}
				}
				if (cntOld<cntCold) {
					if ((cntCold-cntOld)%2 == 0) {
						System.out.println((cntCold-cntOld)/2);
					} else {
						System.out.println( ((cntCold-cntOld)/2)+1 );
					}
					
				}else{
					System.out.println(0);
				}
			}
		}
		sc.close();
	}
}