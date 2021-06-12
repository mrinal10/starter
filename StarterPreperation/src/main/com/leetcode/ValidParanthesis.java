package com.leetcode;

import java.util.Stack;

public class ValidParanthesis {
	public static boolean isValid(String s) {
		char[] charArray = s.toCharArray();
		Stack<Character> cStack = new Stack<>();
		for (int i = 0; i < charArray.length; i++) {
			
			if (charArray[i]=='(' || charArray[i]=='[' || charArray[i]=='{' ) {
				cStack.push(charArray[i]);
			}else{
				if (cStack.isEmpty()) {
					return false;
				}
				char popped = cStack.pop();
				if ((popped=='{' && charArray[i]!='}')
						||(popped=='(' && charArray[i]!=')')||(popped=='[' && charArray[i]!=']')) {
					return false;
				}
			}
		}
		if (cStack.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s = "([]{}";
		System.out.println(isValid(s));
	}
	
}
