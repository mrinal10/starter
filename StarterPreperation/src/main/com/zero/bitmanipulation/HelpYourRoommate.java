package com.zero.bitmanipulation;

import java.util.Scanner;

public class HelpYourRoommate {

	private static int countSetBits(int v) {
		int cnt = 0;
		while (v > 0) {
			if (v % 2 != 0) {
				cnt++;
			}
			v = v >> 1;
		}
		return cnt;
	}

	private static int findingLeftMostBitValue(int v) {
		int countBitLoc = 0;
		while (v != 0) {
			v = v >> 1;
			countBitLoc++;
		}
		countBitLoc = (int) Math.pow(2, (countBitLoc - 1));
		return countBitLoc;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int testCaes = sc.nextInt();
		while (testCaes-- > 0) {
			int bitDiff = 0;
			int inp = sc.nextInt();
			while (inp>0) {
				if((inp&1) == 1){
					bitDiff++;
				}
				inp = inp>>1;
			}
//			int matcher = findingLeftMostBitValue(inp);
//			int setBitsCount = countSetBits(inp);
//			int currentSetBits = setBitsCount;
//			int difference = inp - matcher;
//			int minDiff = difference;
//			while (setBitsCount == currentSetBits) {
//				difference = inp - matcher;
//				if (difference < minDiff) {
//					minDiff = difference;
//				}
//				inp = inp >> 1;
//				matcher = matcher >> 1;
//				currentSetBits = countSetBits(inp);
//			}
			System.out.println(bitDiff);
		}
		sc.close();
	}
}
