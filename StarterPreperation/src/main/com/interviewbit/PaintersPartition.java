package com.interviewbit;

import java.util.ArrayList;

public class PaintersPartition {

	static int sum(ArrayList<Integer> arr, int from, int to) {
		int total = 0;
		for (int i = from; i <= to; i++)
			total += arr.get(i);
		return total;
	}

	public static int paint(int numberOfPartitions, 
				int timeTakenForToPaintUnitLengthBoard, ArrayList<Integer> arr) {
		int noBoards = arr.size();
		if (numberOfPartitions == 1) // one partition
			return sum(arr, 0, numberOfPartitions - 1);
		if (noBoards == 1) // one board
			return arr.get(0);

		int best = Integer.MAX_VALUE;
		for (int i = 0; i <= noBoards; i++) {
			best = Math.min(best, Math.max(paint(numberOfPartitions-1, timeTakenForToPaintUnitLengthBoard
					, arr), sum(arr, i, noBoards-1)) );
		}
		return best*timeTakenForToPaintUnitLengthBoard;
	}

	// Driver code
	public static void main(String args[]) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(10);
		int timeTakenForToPaintUnitLengthBoard = 5;
		int numberOfPartitions = 2;
		System.out.println(paint(numberOfPartitions, timeTakenForToPaintUnitLengthBoard, arr));
	}
}
