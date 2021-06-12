package com.hiring.wissen;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Wissen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int [] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int [] res = new int[n];
		for (int i = 0; i < res.length; i++) {
			res[i] = getValues(arr[i]);
		}
		Arrays.sort(res);
		int otpt = 0;
		for(int i=0; i<k; i++){
			otpt += res[i];
		}
		System.out.println(otpt);
		sc.close();
	}
	
	private static int getValues(int v){
		if (isPrime(v)) {
			return 0;
		}
		int nxtPrime = (int) nextPrime(v);
		return nxtPrime-v;
	}
	
	private static boolean isPrime(long n) 
    { 
        BigInteger b = new BigInteger(String.valueOf(n)); 
  
        return b.isProbablePrime(1); 
    } 
	
	private static long nextPrime(long n) 
    { 
        BigInteger b = new BigInteger(String.valueOf(n)); 
        return Long.parseLong(b.nextProbablePrime().toString()); 
    } 
  
}
