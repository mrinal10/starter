package codility.rakuten;

// you can also use imports, for example:
import java.util.*;
import java.lang.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution33 {
	public static void main(String[] args) {
		int[] A = { 1, 0, 0, 1, 1, 1 };
		Solution33 sol = new Solution33();
		A = sol.solution(A);
		System.out.println(A);
	}

	public int[] solution(int[] A) {
		Double value = getValue(A);
		value = Math.ceil(value / 2);
		return tobase(value.intValue());
	}

	private int[] tobase(int A) {
		List<Integer> list = new ArrayList<>();
		while (A != 0) {
			int rem = (A % (-2));
			A = A / -2;

			if (rem < 0) {
				rem += 2;
				A += 1;
			}
			list.add(rem);
		}
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	private Double getValue(int[] A) {
		Double value = 0.0;
		for (int i = 0; i < A.length; i++) {
			int incr = 0;
			if (A[i] == 1) {
				incr = (int) Math.pow((-2), i);
			}

			value = value + incr;
		}
		return value;
	}

}
