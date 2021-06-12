package com.codechef;

import java.util.Scanner;

public class BITOBYT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-->0){
			int n = sc.nextInt();
			int bitCnt = 0;
			int nibbleCnt = 0;
			int byteCnt = 0;
			
			int transitionCnt = n/26;
			transitionCnt = (int) Math.pow(2,transitionCnt);
			int remainder = n%26;
			if (remainder>10) {
				byteCnt = 1;
				nibbleCnt = 0;
				bitCnt = 0;
			}else if(remainder>2){
				bitCnt = 0;
				byteCnt = 0;
				nibbleCnt = 1;
			}else{
				bitCnt = 1;
				byteCnt = 0;
				nibbleCnt = 0;
			}
			System.out.println(bitCnt*transitionCnt+" "+nibbleCnt*transitionCnt+" "+byteCnt*transitionCnt);
		}
		sc.close();
	}
}
