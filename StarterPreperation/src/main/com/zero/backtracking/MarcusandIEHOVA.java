package com.zero.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarcusandIEHOVA {

	private List<Integer> getStartingPoint(char[][] inp) {
		List<Integer> startingPt = new ArrayList<>();
		for (int i = 0; i < inp.length; i++) {
			for (int j = 0; j < inp[0].length; j++) {
				if (inp[i][j] == '@') {
					startingPt.add(i);
					startingPt.add(j);
					return startingPt;
				}
			}
		}
		return startingPt;
	}

	private boolean isSafe(int r, int c, char[][] map) {
		if (r < 0 || r >= map.length) {
			return false;
		}
		if (c < 0 || c >= map[0].length) {
			return false;
		}
		return true;
	}

	private void mappingHelper(char[][] map, String match, String pathVar, char[] cArr, int indx, int r, int c,
			String path) {
		if (pathVar.equals(match)) {
			if ((isSafe(r - 1, c, map)) && (map[r - 1][c] == '#')) {
				path += "forth ";
			} else if ((isSafe(r, c + 1, map)) && (map[r][c + 1] == '#')) {
				path += "right ";
			} else if ((isSafe(r, c - 1, map)) && (map[r][c - 1] == '#')) {
				path += "left ";
			} else {
				return;
			}
			System.out.println(path);
			return;
		}
		char nextChar = cArr[indx];

		if ((isSafe(r - 1, c, map)) && (map[r - 1][c] == nextChar)) {
			mappingHelper(map, match, pathVar + nextChar, cArr, indx + 1, r - 1, c, path + "forth ");
		} else if ((isSafe(r, c + 1, map)) && (map[r][c + 1] == nextChar)) {
			mappingHelper(map, match, pathVar + nextChar, cArr, indx + 1, r, c + 1, path + "right ");
		} else if ((isSafe(r, c - 1, map)) && (map[r][c - 1] == nextChar)) {
			mappingHelper(map, match, pathVar + nextChar, cArr, indx + 1, r, c - 1, path + "left ");
		} else {
			return;
		}
	}

	private void startMapping(char[][] map) {
		List<Integer> listReslt = getStartingPoint(map);
		int r = listReslt.get(0);
		int c = listReslt.get(1);
		char[] cArr = { 'I', 'E', 'H', 'O', 'V', 'A' };
		mappingHelper(map, "IEHOVA", "", cArr, 0, r, c, "");

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			char[][] arr = new char[r][c];
			for (int i = 0; i < arr.length; i++) {
				String tmp = sc.next();
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = tmp.charAt(j);
				}
			}
			MarcusandIEHOVA miohva = new MarcusandIEHOVA();
			miohva.startMapping(arr);
			System.out.println();
		}
		sc.close();
	}

}
