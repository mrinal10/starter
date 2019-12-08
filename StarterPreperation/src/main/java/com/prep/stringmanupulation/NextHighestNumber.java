package com.prep.stringmanupulation;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class NextHighestNumber {
	public static void main(String[] args) {
		int[] number = { 7, 3, 2, 4, 9, 7, 6 };
		// find number which is smaller than the next
		int v = number[number.length - 1];
		int indx = -1;
		for (int i = number.length - 2; i >= 0; i--) {
			if (v > number[i]) {
				indx = i;
				v = number[i];
				break;
			}
		}
		if (indx == -1) {
			System.out.println("Not Possible");
			return;
		}

		int ix2 = indx;
		int min = Integer.MAX_VALUE;
		for (int j = indx + 1; j < number.length; j++) {
			if (number[j] > v && number[j] < min) {
				ix2 = j;
				min = number[j];
			}
		}
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i]);
		}
		System.out.println();
		int temp = number[indx];
		number[indx] = number[ix2];
		number[ix2] = temp;

		Arrays.sort(number, indx + 1, number.length);
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i]);
		}
	}
}
