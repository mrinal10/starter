package com.hackerearth.practice;

import java.util.Scanner;

public class ClimbingStairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long up, down, totalSteps;
		up = sc.nextLong();
		down = sc.nextLong();
		totalSteps = sc.nextLong();
		
		long reqSteps = totalSteps-up;
		long daysReq = reqSteps/(up-down);
		long remainingSteps = reqSteps-(daysReq*(up-down));
		if (remainingSteps>0) {
			daysReq += 2;
		}else
			daysReq += 1;
		
		System.out.println(daysReq);
		sc.close();
	}

}
