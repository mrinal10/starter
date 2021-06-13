package com.practice.binarysearch;

public class SquareRoot {
	public static int sqrt(int number) {
		int start = 0, end = number;
		int mid;
		int ans = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			System.out.println(mid);
			if (mid * mid == number) {
				ans = mid;
				break;
			}

			if (mid * mid < number) {
				start = mid + 1;
				ans = mid;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(sqrt(2147483647));
	}
}
