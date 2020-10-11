package com.hackerrank.problemsolving;

import java.util.Stack;

public class BalancedBracket {
	
	static String isBalanced(String s) {
		Stack<Character> stackBrackets = new Stack<Character>();
		for(int i=0; i<s.length(); i++) {
			char currentCharacter = s.charAt(i);
			if(currentCharacter=='['||currentCharacter=='('||currentCharacter=='{') {
				stackBrackets.push(currentCharacter);
			}else {
				if(stackBrackets.isEmpty()) {
					return "NO";
				}if((currentCharacter==')' && stackBrackets.peek()=='(') 				
						|| (currentCharacter=='}' && stackBrackets.peek()=='{') ||
						(currentCharacter==']' && stackBrackets.peek()=='[') ) {
					stackBrackets.pop();
				}else {
					break;
				}
			}
		}
		if(!stackBrackets.isEmpty()) {
			return "NO";
		}
		return "YES";
    }
	
	public static void main(String[] args) {
		System.out.println(isBalanced("{{[[(()]]}}"));
	}
}
