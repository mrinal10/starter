package com.hackerearth.hourstorm;

import java.util.Scanner;

public class ComplexGCD {

	private static int findGCD(int number1, int number2){
		int gcd = 1;
		if(number2 == 0){ 
			return number1; 
		} 
		return findGCD(number2, number1%number2); 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		
		for (int i = 0; i < b.length; i++) {
			a[i] = sc.nextInt();
		}
		
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		int noOfOccur=0;
		int maxGcd = 0;
		for (int i = 0; i < b.length; i++) {
			for (int j = i+1; j < b.length; j++) {
				if (i!=j) {
					int gcdSum = findGCD(a[i],a[j])+findGCD(b[i],b[j]);
					//System.out.println(">>>>>"+gcdSum);
					if (gcdSum>maxGcd) {
						maxGcd = gcdSum;
						noOfOccur = 1;
					}else if(gcdSum==maxGcd) {
						noOfOccur = noOfOccur+1;
					}
				}
			}
		}
		System.out.println(maxGcd+" "+noOfOccur);
	}
}
