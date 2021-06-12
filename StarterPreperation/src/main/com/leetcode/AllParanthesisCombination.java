package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllParanthesisCombination {
	static List<String> allPossibleStrings;
	static int lengthOfParam;
	private static void createValidParanthesis(int paranThesisBalance, int remainingLength, String s){
		if(remainingLength == 0 && paranThesisBalance == 0){
			allPossibleStrings.add(s);
			return;
		}
		if(s.length()>lengthOfParam || paranThesisBalance<0){
			return;
		}
		createValidParanthesis(paranThesisBalance+1, remainingLength-1, s+"(");
		createValidParanthesis(paranThesisBalance-1, remainingLength-1, s+")");
	}
	public static List<String> generateParenthesis(int n) {
		lengthOfParam = 2*n;
        allPossibleStrings = new ArrayList<>();
        if (n!=0) {
			createValidParanthesis(0, 2*n, "");
		}
        return allPossibleStrings;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> llist = generateParenthesis(n);
		for (int i = 0; i < llist.size(); i++) {
			System.out.println(allPossibleStrings.get(i));
		}
		sc.close();
	}

}
