package com.codechef;

import java.util.Scanner;

public class CHSERVE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-->0){
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			
			int k = sc.nextInt();
			
			int addValue = p1+p2;
			int dividedValue = addValue/k;
			if((dividedValue&1)==0){
				System.out.println("CHEF");
			}else
				System.out.println("COOK");
		}
		sc.close();
	}

}
