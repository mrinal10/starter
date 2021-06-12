package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergeIntervals {
	public static List<Interval> mergeIntervals(Interval arr[]) {
		List<Interval> listIntervals = new ArrayList<>();
		if (arr.length != 0) {
			Stack<Interval> stack = new Stack<>();
			Arrays.sort(arr, new Comparator<Interval>() {
				public int compare(Interval i1, Interval i2) {
					return i1.start - i2.start;
				}
			});

			stack.push(arr[0]);

			for (int i = 1; i < arr.length; i++) {
				Interval top = stack.peek();

				if (top.end < arr[i].start)
					stack.push(arr[i]);

				else if (top.end < arr[i].end) {
					top.end = arr[i].end;
					stack.pop();
					stack.push(top);
				}
			}

			System.out.print("The Merged Intervals are: ");
			while (!stack.isEmpty()) {
				Interval t = stack.pop();
				listIntervals.add(t);
			}
		}
		Collections.reverse(listIntervals);
		return listIntervals;
	}
}
