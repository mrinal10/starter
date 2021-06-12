package com.article.practice.medium.article;

import java.util.Scanner;

public class LongestCommonCharacter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			String s = sc.next();
			getMaxCommonCharacter(s);
		}
		sc.close();
	}
	
	private static void getMaxCommonCharacter(String s){
		char currentCharacter, maxCharacter, prevCharacter;
		int currentCount = 0, maxCount = 0;
		currentCharacter = s.charAt(0);
		maxCharacter = currentCharacter;
		currentCount = 1;
		maxCount = 1;
		for (int i = 1; i < s.length(); i++) {
			prevCharacter = currentCharacter;
			currentCharacter = s.charAt(i);
			if (currentCharacter == prevCharacter) {
				currentCount++;
				if (maxCount<currentCount) {
					maxCount = currentCount;
					maxCharacter = currentCharacter;
				}
			} else {
				currentCount = 1;
			}
		}
		
		System.err.println(maxCharacter+" ::: "+maxCount);
	}

}
