package com.byju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Problem1 {
	static Set<String> visited;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		Scanner sc = new Scanner(System.in);
		for (int t_i = 0; t_i < T; t_i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] A = new int[N][M];
			for (int i_A = 0; i_A < N; i_A++) {
				for (int j_A = 0; j_A < M; j_A++) {
					A[i_A][j_A] = sc.nextInt();
				}
			}

			int sx = Integer.parseInt(br.readLine().trim());
			int sy = Integer.parseInt(br.readLine().trim());
			int Q = Integer.parseInt(br.readLine().trim());
			String[] arr_x = br.readLine().split(" ");
			int[] x = new int[Q];
			String[] arr_y = br.readLine().split(" ");
			int[] y = new int[Q];

			for (int i = 0; i < arr_x.length; i++) {
				x[i] = Integer.parseInt(arr_x[i]);
				y[i] = Integer.parseInt(arr_y[i]);
			}

			int[] out_ = solve(A, x, sy, sx, y);

			for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {
				System.out.print(out_[i_out_] + "\n");
			}
		}
		sc.close();
		wr.close();
		br.close();
	}

	static int[] solve(int[][] A, int[] x, int sy, int sx, int[] y) {
		int numOfQueries = x.length;
		int[] res = new int[numOfQueries];
		visited = new HashSet<String>();
		count = 0;
		for (int j = 0; j < res.length; j++) {
			count = 0;
			reqVisit(A, sx, sy, x[j], y[j], 0);
			if (count == 0) {
				count = -1;
			}
			res[j] = count;
		}
		return res;
	}

	static boolean reqVisit(int[][] A, int x, int y, int trgtx, int trgty, int cnt) {
		if (x == trgtx && y == trgty) {
			if (count > cnt) {
				count = cnt;
			}
			return true;
		}
		if (visited.contains(x + "," + y)) {
			return false;
		}
		visited.add(x + "," + y);
		String[] cells = getCellsReachable(x, y, A[x - 1][y - 1]);
		for (int i = 0; i < cells.length; i++) {
			int xx = Integer.parseInt(cells[i].split(",")[0]);
			int yy = Integer.parseInt(cells[i].split(",")[1]);
			reqVisit(A, xx, yy, trgtx, trgty, cnt + 1);
		}
		return false;
	}

	static String[] getCellsReachable(int x, int y, int manhattandistance) {
		List<String> s = new ArrayList<String>();
		for (int i = 0; i <= manhattandistance; i++) {
			s.add((x + i) + "," + (y + (manhattandistance - i)));
		}
		return (String[]) s.toArray();
	}
}
