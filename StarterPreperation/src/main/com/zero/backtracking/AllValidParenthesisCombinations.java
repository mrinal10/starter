package com.zero.backtracking;

import java.util.*;

public class AllValidParenthesisCombinations {

	static void genAllValidParenthesisHlpr(int n, int paranthesisTillNow, int paranThesisBalancer,
			List<String> allvalidParanthesis, String pathVar) {
		if (paranThesisBalancer < 0) {
			return;
		}
		if (paranthesisTillNow == n && paranThesisBalancer==0) {
			allvalidParanthesis.add(pathVar);
			return;
		}

		if (paranThesisBalancer >= 0 && paranthesisTillNow < n) {
			genAllValidParenthesisHlpr(n, paranthesisTillNow + 1, paranThesisBalancer - 1, allvalidParanthesis,
					pathVar + ")");
			genAllValidParenthesisHlpr(n, paranthesisTillNow + 1, paranThesisBalancer + 1, allvalidParanthesis,
					pathVar + "(");
		}
	}

	static List<String> genAllValidParenthesis(int n) {
		n = n*2;
		List<String> allParanthesisCombinations = new ArrayList<String>();
		genAllValidParenthesisHlpr(n, 0, 0, allParanthesisCombinations, "");
		return allParanthesisCombinations;
	}

	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int n = s.nextInt();
		List<String> paranthesisStr = genAllValidParenthesis(n);
		for (int i = 0; i < paranthesisStr.size(); i++) {
			System.out.print(paranthesisStr.get(i));
			if(i!=paranthesisStr.size()-1){
				System.out.print(", ");
			}
		}
		s.close();
	}

}
