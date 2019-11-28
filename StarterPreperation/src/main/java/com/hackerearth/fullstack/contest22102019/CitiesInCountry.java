package com.hackerearth.fullstack.contest22102019;

import java.math.BigInteger;
import java.util.Scanner;

public class CitiesInCountry {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int testCase = sc.nextInt();
		while(testCase-->0) {
			int numberOfCities = sc.nextInt();
			System.out.println(getArea(numberOfCities));
		}
		sc.close();
	}
	
	private static BigInteger getArea(int numberOfCities) {
		BigInteger minX = BigInteger.ZERO;
		BigInteger maxX = BigInteger.ZERO;
		
		BigInteger minY = BigInteger.ZERO;
		BigInteger maxY = BigInteger.ZERO;
		while(numberOfCities-->0) {
			BigInteger x = sc.nextBigInteger();
			BigInteger y = sc.nextBigInteger();
			
			if(x.compareTo(minX) == -1) {
				minX = x;
			}
			if(x.compareTo(maxX) == 1) {
				maxX = x;
			}
			
			if(y.compareTo(minY) == -1) {
				minY = y;
			}
			if(y.compareTo(maxY) == 1) {
				maxY = y;
			}
		}
		BigInteger lenX = maxX.subtract(minX);
		BigInteger lenY = maxY.subtract(minY);
		BigInteger area = lenX.multiply(lenY);
		return area;
	}
}
