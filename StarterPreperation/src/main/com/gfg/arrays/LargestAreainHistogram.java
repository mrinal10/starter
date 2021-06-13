package com.gfg.arrays;

import java.util.Stack;

public class LargestAreainHistogram {

	private static int getMaxArea(int[] hist, int n) {
		Stack<Integer> s = new Stack<>();

		int max_area = 0, top, area_with_top;
		int i = 0;
		for (i = 0; i < n; i++) {
			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);
			else {
				top = s.peek();
				s.pop();
				area_with_top = hist[top] * (s.empty() ? i : i - s.peek() - 1);
				if (max_area < area_with_top)
					max_area = area_with_top;
			}
		}

		while (!s.empty()) {
			top = s.peek();
			s.pop();
			area_with_top = hist[top] * (s.empty() ? i : i - s.peek() - 1);

			if (max_area < area_with_top)
				max_area = area_with_top;
		}
		return max_area;
	}

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
	}
}
