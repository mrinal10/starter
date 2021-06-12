package com.practice.capillary;

import java.math.BigInteger;
import java.util.Scanner;

public class RangeSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger int1 = sc.nextBigInteger();
		BigInteger int2 = sc.nextBigInteger();
		
		BigInteger two = new BigInteger("2");
		BigInteger res = int2.subtract(int1).multiply(int1.add(int1)).divide(two);
		System.out.println(res.add(new BigInteger("50")));
		sc.close();
	}
}
