package com.hiring.casaone25012020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewBalancedBracket {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s = sc.next();
			System.out.println(getMinInsertionCount(s));
		}
		sc.close();
	}

	private static int getMinInsertionCount(String s) {
		int balanced = 0;
		int insertionCount = 0;
		List<Character> charList = new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{') {
				charList.add('{');
				charList.add('{');
			} else {
				charList.add('}');
			}
		}
        
        for (int i = 0; i < charList.size(); ++i) {          
            balanced += charList.get(i) == '{' ? 1 : -1;         
            if (balanced == -1) {  
                insertionCount += 1;  
                balanced += 1;  
            }  
        }  
        
        return balanced +  insertionCount;
	}

}
