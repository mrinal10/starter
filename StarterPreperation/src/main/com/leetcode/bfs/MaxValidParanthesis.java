package com.leetcode.bfs;

import java.util.*;

public class MaxValidParanthesis {
	static List<String> validParanthesis;

	private static boolean isParenthesis(char c) {
		return ((c == '(') || (c == ')'));
	}

	private static boolean isValidParanthesis(String str) {
		if (str.length() == 0) {
			return true;
		}
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				cnt++;
			else if (str.charAt(i) == ')')
				cnt--;
			if (cnt < 0)
				return false;
		}
		return (cnt == 0);
	}

	// method to remove invalid parenthesis
	private static void removeInvalidParenthesis(String str) {
		Set<String> visited = new HashSet<String>();
		// queue to maintain BFS
		Queue<String> q = new LinkedList<>();
		String temp;
		boolean level = false;

		q.add(str);
		visited.add(str);
		while (!q.isEmpty()) {
			str = q.poll();
			if (isValidParanthesis(str)) {
				System.out.println(str);
				validParanthesis.add(str);
				level = true;
			}
			if (level)
				continue;
			for (int i = 0; i < str.length(); i++) {
				if (!isParenthesis(str.charAt(i)))
					continue;

				temp = str.substring(0, i) + str.substring(i + 1);
				if (!visited.contains(temp)) {
					q.add(temp);
					visited.add(temp);
				}
			}
		}
	}

	public static List<String> removeInvalidParentheses(String s) {
		validParanthesis = new ArrayList<>();
		removeInvalidParenthesis(s);
		return validParanthesis;
	}

	public static void main(String[] args) {
		String expression =  "()())()";
		removeInvalidParentheses(expression);
		expression = "";//"()v)";
		removeInvalidParentheses(expression);
	}
}
