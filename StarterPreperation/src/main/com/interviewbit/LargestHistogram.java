package com.interviewbit;

import java.util.Stack;

public class LargestHistogram {

	static int getMaxArea(int hist[], int n) {
		Stack<Integer> s = new Stack<>();

		int maxArea = 0; // Initialize max area
		int stackTop = 0; // To store top of stack
		int areaWithTop = 0; // To store area with top bar as the smallest bar

		int i = 0;
		while (i < n) {
			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);
			else {
				dotheStuff(stackTop, areaWithTop, maxArea, i, s, hist);
			}
		}

		while (!s.empty()) {
			dotheStuff(stackTop, areaWithTop, maxArea, i, s, hist);
		}
		return maxArea;
	}

	private static void dotheStuff(int stackTop, int areaWithTop, int maxArea, int i, Stack<Integer> s, int[] hist){
		stackTop = s.pop();
		areaWithTop = hist[stackTop] * (s.empty() ? i : i - s.peek() - 1);
		if (maxArea < areaWithTop)
			maxArea = areaWithTop;
	}
	
	// Driver program to test above function
	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
	}
}
