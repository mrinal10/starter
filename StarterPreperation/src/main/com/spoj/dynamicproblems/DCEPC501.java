package com.spoj.dynamicproblems;

import java.util.Arrays;
import java.util.Scanner;

public class DCEPC501 {
	static int pilesOfCoins[];
	static int sizeOfArray;
	static int sp[];
	static int maxCoins(int index){
		if(index>=sizeOfArray){
			return 0;
		}
		if(sp[index]>=0){
			return sp[index];
		}
		int retValue = 0;
		retValue = Math.max(retValue, pilesOfCoins[index]+maxCoins(index+2));
		retValue = Math.max(retValue, pilesOfCoins[index]+pilesOfCoins[index+1]+maxCoins(index+4));
		retValue = Math.max(retValue, pilesOfCoins[index]+pilesOfCoins[index+1]+pilesOfCoins[index+2]+maxCoins(index+6));
		
		sp[index] = retValue;
		return sp[index];
	}
	
	
	public static void main(String[] args) {
		pilesOfCoins = new int[1000005];
		sp = new int[1000005];
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while ( t-->0) {
			sizeOfArray = sc.nextInt();
			Arrays.fill(sp, 0, sizeOfArray, -1);
			for (int i = 0; i < sizeOfArray; i++) {
				pilesOfCoins[i] = sc.nextInt();
			}
			System.out.println(maxCoins(0));
		}
		sc.close();
	}
}
