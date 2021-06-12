package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryWatchEfficient {

	static int totalNumberOfBitsInWatch;
	static List<String> allTimes;

	private static void convertToTime(String arr) {
		char[] arrr = arr.toCharArray();
		int hr = 0;
		for (int i = 0; i < 4; i++) {
			hr += Integer.parseInt(String.valueOf(arrr[i])) * Math.pow(2, (3 - i));
		}
		int min = 0;
		for (int i = 4; i < 10; i++) {
			min += Integer.parseInt(String.valueOf(arrr[i])) * Math.pow(2, (9 - i));
		}
		String minInStr = "";
		if (min < 10) {
			minInStr = 0 + "" + min;
		} else {
			minInStr = String.valueOf(min);
		}
		if (hr < 12 && min<60) {
			allTimes.add(hr + ":" + minInStr);
		}
	}

	private static void createNewCombintion(int remainingBitsToSet, int curIndx, String s) {
		if (remainingBitsToSet == 0 && curIndx == totalNumberOfBitsInWatch) {
			// System.out.println(s);
			convertToTime(s);
		}
		if (curIndx > totalNumberOfBitsInWatch) {
			return;
		}
		createNewCombintion(remainingBitsToSet, curIndx + 1, s + "0");
		createNewCombintion(remainingBitsToSet - 1, curIndx + 1, s + "1");
	}

	public static List<String> readBinaryWatch(int num) {
		totalNumberOfBitsInWatch = 10;
		allTimes = new ArrayList<>();
		createNewCombintion(num, 0, "");
		return allTimes;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfSetBits = sc.nextInt();
		readBinaryWatch(numberOfSetBits);
		for (int i = 0; i < allTimes.size(); i++) {
			System.out.print(allTimes.get(i) + " ");
		}
		sc.close();
	}

}
