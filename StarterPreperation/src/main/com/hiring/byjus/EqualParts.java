package com.hiring.byjus;

import java.util.Scanner;

public class EqualParts {

	static int[] users;
	static int[] fund;
	static int modificationsCount = 0;
	
	private static void modifyFunds(int n){
		modificationsCount += n;
		for (int i = 0; i < fund.length; i++) {
			fund[i] += n;
		}
	}
	
	private static void doModifications(){
		for (int i = fund.length-1; i >=0 ; i--) {
			int fnd = fund[i];
			int userCnt = users[i];
			
			int rem = fnd%userCnt;
			if (rem!=0) {
				rem = userCnt - rem;
				modifyFunds(rem);	
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		users = new int[n];
		fund = new int[n];
		for (int i = 0; i < n; i++) {
			users[i] = sc.nextInt();
			fund[i] = sc.nextInt();
		}
		doModifications();
		System.out.println(modificationsCount);
		sc.close();
	}

}
