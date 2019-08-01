package com.prep.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParanthesis {
	
	//to check if the char is parenthesis
	private static boolean isParenthesis(char c) {
		return ((c == '(') || (c == ')'));
	}

	//if the string is a valid parenthesis combination
	private static boolean isValidParanthesis(String str) {
		if (str.isEmpty())
			return true;

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
		Set<String> visited = new HashSet<>();
		// queue to maintain BFS
		Queue<String> q = new LinkedList<>();
		String temp;
		boolean level = false;

		q.add(str);
		visited.add(str);
		while (!q.isEmpty()) {
			str = q.poll();
			if (isValidParanthesis(str)) {
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

	static List<String> validParanthesis;

	public static void main(String[] args) {
		validParanthesis = new ArrayList<>();
		removeInvalidParenthesis("(())()))");

		for(String s : validParanthesis) {
			System.out.println(s);
		}

	}

}
