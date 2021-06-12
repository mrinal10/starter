package com.practice.codeChef;

import java.util.Scanner;


class MartianCricket {

	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int ar[] = new int[n];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = sc.nextInt();
			}
			int adVal = 0;
			for (int i = 0; i < ar.length-1; i++) {
				for (int j = i; j < ar.length; j++) {
					adVal += Math.abs(ar[j] - ar[i]);
				}
			}
			
			System.out.println(adVal);
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
