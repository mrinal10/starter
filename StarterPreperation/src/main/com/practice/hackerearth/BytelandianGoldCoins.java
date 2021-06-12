package com.practice.hackerearth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BytelandianGoldCoins {
	private static Map<Integer, Integer> goldToDollarMap = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int t = sc.nextInt();
			System.out.println(countDollar(t));
		}
		sc.close();
	}
	
	private static int countDollar(int n){
		if (n==1) {
			return n;
		}
		int dollarValue = 0;
		int n2 = n/2;
		int n3 = n/3;
		int n4 = n/4;
		dollarValue = n2+n3+n4;
		if (dollarValue>=n) {
			return dollarValue;
		}
		n2 = tru(n2);
		n3 = tru(n3);
		n4 = tru(n4);
		
		dollarValue = n2+n3+n4;
		if (dollarValue<n) {
			dollarValue = 2*countDollar(n/2);
		}
		return dollarValue;
	}
	
	private static int tru(int n){
		
		if (goldToDollarMap.containsKey(n) && goldToDollarMap.get(n)>=countDollar(n)) {
			n = goldToDollarMap.get(n);
		}else{
			goldToDollarMap.put(n, countDollar(n));
		}
		System.out.println(">>>>>>>>>"+n);
		return n;
	}

}
