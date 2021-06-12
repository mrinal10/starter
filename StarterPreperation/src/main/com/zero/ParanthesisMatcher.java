package com.zero;

import java.util.Stack;

public class ParanthesisMatcher {

	boolean validateParenthesis(char exp[]) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
				st.push(exp[i]);
			else if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
				if (st.isEmpty()) {
					return false;
				} else if (!isMatchingPair(st.pop(), exp[i])) {
					return false;
				}
			}
		}

		if (st.isEmpty())
			return true;
		else {
			return false;
		}
	}

	static boolean isMatchingPair(char character1, char character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String v = "{A man (a plan) a canal (Panama)}";
		// "()()()()((([]{})())";//"if((a%2==0) || (a%5!=0 && isPrime(a))){}";
		ParanthesisMatcher pmatcher = new ParanthesisMatcher();
		System.out.println(pmatcher.validateParenthesis(v.toCharArray()));
	}
}
