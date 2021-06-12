package com.practice.walmartlabs;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {
	private static Stack<Character> stack = new Stack<>();

	private static boolean isBalanced(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			}

			if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				if (isMatching( stack.peek(), s.charAt(i))) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	private static boolean isMatching(char a, char b) {
		if (a == '(' && b == ')') {
			return true;
		} else if (a == '{' && b == '}') {
			return true;
		} else if (a == '[' && b == ']') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			stack = new Stack<>();
			String inp = sc.next();
			if (isBalanced(inp)) {
				System.out.println("balanced");
			} else
				System.out.println("not balanced");
		}
		sc.close();
	}
}
