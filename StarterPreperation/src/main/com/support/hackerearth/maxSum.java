package com.support.hackerearth;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class maxSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Set<BigInteger> set = new HashSet<>();
		for (int i = 0; i < num; i++) {
			BigInteger n1 = sc.nextBigInteger();
			
			if (n1.compareTo(new BigInteger("0"))==1) {
				set.add(n1);
			}
		}
		BigInteger cnt = new BigInteger("0");
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			BigInteger integer = (BigInteger) iterator.next();
//			System.out.println("intgere >>> "+integer);
			cnt = cnt.add(integer);
//			System.out.println("><><><"+cnt);
		}
		System.out.println(cnt);
		System.out.print(" "+set.size());
		sc.close();
	}
}
