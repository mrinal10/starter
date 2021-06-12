package com.interviewbit;

public class SquareRoot {

	double findRoot(int num) {
		double start = 0;
		double end = num;
		while (end - start > 0.0001) {
			end = (end+start)/2;
			start = num/end;
		}
		return end;
	}

	public static void main(String args[]) {
		SquareRoot sr = new SquareRoot();
		System.out.println(sr.findRoot(949194368));
	}
}