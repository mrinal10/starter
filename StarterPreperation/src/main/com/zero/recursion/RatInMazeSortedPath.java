package com.zero.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class RatInMazeSortedPath {
	boolean isSafe(int[][] a, int r, int c, int rlim, int clim) {
		if (r >= 0 && c >= 0 && r <= rlim && c <= clim) {
			return true;
		}
		return false;
	}

	void printAllPathsHelper(int[][] a, int r, int c, int rlim, int clim, String s, ArrayList<String> sList, String m,
			ArrayList<String> loopChk) {
		if (!isSafe(a, r, c, rlim, clim)) {
			return;
		}
		if (a[r][c] == 0) {
			return;
		}
		if (!loopChk.contains(r + "" + c)) {
			s = s + m;
			loopChk.add(r + "" + c);
		} else {
			return;
		}
		if (r == rlim && c == clim) {
			sList.add(s);
			loopChk.remove(r + "" + c);
			return;
		}

		printAllPathsHelper(a, r + 1, c, rlim, clim, s, sList, "D", loopChk);
		printAllPathsHelper(a, r - 1, c, rlim, clim, s, sList, "U", loopChk);
		printAllPathsHelper(a, r, c + 1, rlim, clim, s, sList, "R", loopChk);
		printAllPathsHelper(a, r, c - 1, rlim, clim, s, sList, "L", loopChk);
		if(loopChk.contains(r+""+c)){
			loopChk.remove(r+""+c);
		}
	}

	void printAllPaths(int[][] m) {
		ArrayList<String> sList = new ArrayList<>();
		ArrayList<String> loopChk = new ArrayList<>();
		printAllPathsHelper(m, 0, 0, m.length - 1, m[0].length - 1, "", sList, "", loopChk);
		Collections.sort(sList);
		for (int i = 0; i < sList.size(); i++) {
			System.out.print(sList.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };// {
																							// {
																							// 1,
																							// 0,
																							// 0,
																							// 0,
																							// 0
																							// },
																							// {
																							// 1,
																							// 0,
																							// 1,
																							// 1,
																							// 1
																							// },
																							// {
																							// 1,
																							// 1,
																							// 1,
																							// 0,
																							// 1
																							// },
																							// {
																							// 0,
																							// 0,0,
																							// 0,
																							// 1
																							// }
																							// };
		RatInMazeSortedPath paths = new RatInMazeSortedPath();
		paths.printAllPaths(maze);

	}

}
