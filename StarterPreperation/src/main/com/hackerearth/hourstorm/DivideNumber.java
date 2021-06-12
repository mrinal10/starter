package com.hackerearth.hourstorm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DivideNumber {
	private static ArrayList<Integer> allDivisors;
	static int maxValue = 0;
	static int n;
	private static void getMaxValue(int cnt, ArrayList<Integer> allValues){
		if(cnt==4){
			int sum = 0;
			int mul = 1;
			for (int i = 0; i < allValues.size(); i++) {
				sum+=allValues.get(i);
				mul=mul*allValues.get(i);
			}
			if(sum == n && mul>maxValue){
				maxValue = mul;
			}
			return;
		}
		for (int i = 0; i < allDivisors.size(); i++) {
			int indx = allValues.size();
			allValues.add(allDivisors.get(i));
			getMaxValue(cnt+1, allValues);
			allValues.remove(indx);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			maxValue = 0;
			n = s.nextInt();
			allDivisors = new ArrayList<>();
			allDivisors = printDivisors(n);
			getMaxValue(0, new ArrayList<>());
			System.out.println(maxValue);
		}
		s.close();
	}

	static ArrayList<Integer> printDivisors(int n) {
		// Vector to store half of the divisors
		ArrayList<Integer> v = new ArrayList<>();
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i) {
					
				} else {
					v.add(i);
					v.add(n / i);
				}
			}
		}
		Collections.sort(v);
		return v;
	}
}
