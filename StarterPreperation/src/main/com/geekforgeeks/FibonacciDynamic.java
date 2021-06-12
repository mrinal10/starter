package com.geekforgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciDynamic {
	private static HashMap<Integer, Integer> map = null;
	private static void printFibo(int n){		
		map = new HashMap<Integer, Integer>();
		fibo(n, map);
	}
	
	private static int fibo(int n, Map map){
		int fibValue = 0;
		if (map.get(n)!=null) {
			fibValue = (int) map.get(n);
		} else {
			if (n==0 || n==1) {
				fibValue = 1;
				System.out.print(fibValue+", ");
			} else {
				fibValue = fibo(n-1, map)+fibo(n-2, map);
				System.out.print(fibValue+", ");
			}	
			map.put(n, fibValue);
		}
		return fibValue;
	}
	
	public static void main(String[] args) {
		System.out.print("Insert value :: ");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		FibonacciDynamic.printFibo(N);
	}
}
