package com.practice.codeChef;

import java.math.BigInteger;
import java.util.Scanner;

class PerformerViewCount{
	public BigInteger countValue;
	public String performerName;
	
	public PerformerViewCount(String count, String name) {
		countValue = new BigInteger(count);
		performerName = name;
	}
}

class GSMAR18B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			
			PerformerViewCount maxPFV = null;
			for (int j = 0; j < n; j++) {
				
				String name = sc.next();
				String count = sc.next();
				PerformerViewCount pfv = new PerformerViewCount(count, name);
				if (j==0) {
					maxPFV = pfv;
				} else {
					if (maxPFV.countValue.compareTo(pfv.countValue)!=1) {
						maxPFV = pfv;
					}
				}
			} 
			System.out.println(maxPFV.performerName);
			
			
		}
		sc.close();
	}

}
