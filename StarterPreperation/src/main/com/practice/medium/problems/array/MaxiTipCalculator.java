/**
 * 
 */
package com.practice.medium.problems.array;

import java.util.Scanner;

/**
 * @author mailm
 *
 */
public class MaxiTipCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int len = sc.nextInt();
			int[] ar = new int[len];
			int[] br = new int[len];
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int j = 0; j < ar.length; j++) {
				ar[j] = sc.nextInt();
			}
			for (int j = 0; j < br.length; j++) {
				br[j] = sc.nextInt();
			}
			
			for (int j = 0; j < br.length-1; j++) {
				for (int j2 = 0; j2 < br.length-1-j; j2++) {
					if (br[j2] < br[j2+1]) {
						int temp = ar[j2];
	                    ar[j2] = ar[j2+1];
	                    ar[j2+1] = temp;
	                    
	                    temp = br[j2];
	                    br[j2] = br[j2+1];
	                    br[j2+1] = temp;
					}
				}
			}
			int totalTip = 0;
			for (int j = 0; j < br.length; j++) {
				if (ar[j] != br[j]) {
					if (y>0) {
						if (ar[j]<br[j] || x==0) {
							totalTip += br[j];
							y--;
						} else {
							totalTip += ar[j];
							x--;
						}
					} else {
						totalTip += ar[j];
						x--;
					}
				}
			}
			for (int j = 0; j < br.length; j++) {
				if (ar[j] == br[j]) {
					if (y>0) {
						if (ar[j]<br[j] || x==0) {
							totalTip += br[j];
							y--;
						} else {
							totalTip += ar[j];
							x--;
						}
					} else {
						totalTip += ar[j];
						x--;
					}
				}
			}
			System.out.println(totalTip);
		}
		
		sc.close();
		
	}

}
