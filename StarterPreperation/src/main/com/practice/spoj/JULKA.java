package com.practice.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class JULKA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			BigInteger TOT=sc.nextBigInteger();
			BigInteger MORE=sc.nextBigInteger(); 
			BigInteger natalia=(TOT.subtract(MORE)).divide(new BigInteger("2")); 
			BigInteger klaudia=natalia.add(MORE);
    		
    		System.out.println (klaudia);
    		System.out.println (natalia);

		}
		sc.close();
	}

}
