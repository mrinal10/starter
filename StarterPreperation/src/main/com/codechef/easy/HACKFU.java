package com.codechef.easy;

import java.util.*;
import java.io.*;
import java.text.*;

public class HACKFU {
	// SOLUTION BEGIN
	void solve(int TC) throws Exception {
		int n = ni();
		long s = nl();
		int k = ni();
		long min = nl(), max = nl();
		long[] a = new long[n], b = new long[n - 2];
		int off = 2;
		long[] ans = new long[n];
		Arrays.fill(ans, IINF);
		for (int p = Math.max(0, n / 2 - off); p <= Math.min(n - 1, n / 2 + off); p++) {
			if (!fill(a, s, min, max, p))
				continue;
			if (valid(a, b, k))
				smaller(ans, a);
		}
		if (ans[0] == IINF)
			pn(-1);
		else
			for (int i = 0; i < n; i++)
				if (i == n - 1)
					pn(ans[i]);
				else
					p(ans[i] + " ");
	}

	void smaller(long[] ans, long[] a) {
		boolean rep = false;
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] != a[i]) {
				if (ans[i] > a[i])
					rep = true;
				break;
			}
		}
		if (rep)
			for (int i = 0; i < ans.length; i++)
				ans[i] = a[i];
	}

	boolean fill(long[] a, long s, long min, long max, int p) {
		if (min == max)
			return false;
		for (int i = 0; i < a.length; i++) {
			if (i >= p)
				a[i] = min + 1;
			else
				a[i] = min;
			s -= a[i];
		}
		if (s < 0)
			return false;
		long md = max - min - 1;
		for (int i = a.length - 1; i >= 0; i--) {
			a[i] += Math.min(md, s);
			s -= Math.min(md, s);
		}
		return s == 0;
	}

	boolean valid(long[] a, long[] b, int k) {
		int l = a.length % k, r = k, n = a.length;
		for (int i = 0, j = 0; i < n; i++) {
			if (i == l || i == r)
				continue;
			b[j++] = a[i];
		}
		long wrong = b[(n - 2) / 2] * 2;
		long correct = 0;
		if (n % 2 == 1)
			correct = a[n / 2] * 2;
		else
			correct = a[n / 2] + a[(n / 2) - 1];
		return correct != wrong;
	}

	// SOLUTION ENDS
	long gcd(long a, long b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	int bit(long n) {
		return (n == 0) ? 0 : (1 + bit(n & (n - 1)));
	}

	void p(Object o) {
		out.print(o);
	}

	void pn(Object o) {
		out.println(o);
	}

	void pni(Object o) {
		out.println(o);
		out.flush();
	}

	String n() {
		return in.next();
	}

	String nln() {
		return in.nextLine();
	}

	int ni() {
		return Integer.parseInt(in.next());
	}

	long nl() {
		return Long.parseLong(in.next());
	}

	double nd() {
		return Double.parseDouble(in.next());
	}

	class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws Exception {
			br = new BufferedReader(new FileReader(s));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	long mod = (int) 1e9 + 7, IINF = (long) 1e18;
	final int MAX = (int) 1e4 + 1, INF = (int) 1e9, root = 3;
	DecimalFormat df = new DecimalFormat("0.00000000");
	double PI = 3.141592653589793238462643383279502884197169399375105820974944;
	static boolean multipleTC = true, memory = true;
	FastReader in;
	PrintWriter out;

	public static void main(String[] args) throws Exception {
		if (memory)
			new Thread(null, new Runnable() {
				public void run() {
					try {
						new HACKFU().run();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, "1", 1 << 28).start();
		else
			new HACKFU().run();
	}

	void run() throws Exception {
		in = new FastReader();
		out = new PrintWriter(System.out);
		for (int i = 1, T = (multipleTC) ? ni() : 1; i <= T; i++)
			solve(i);
		out.flush();
		out.close();
	}
}
