package com.interviewbit;

import java.util.Stack;
import java.util.StringTokenizer;

public class testClass {
	public static synchronized void main(String[] args) {
		double a = 290.05;
		int b = 5;
		byte c = (byte) a;
		System.out.println(c);
		Stack<String> str = new Stack<>();
		str.push("abcd");
		str.push("efgh");
		System.out.println(str);
		str.search("ab");
	}
}
