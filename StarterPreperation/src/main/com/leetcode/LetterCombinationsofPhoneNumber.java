package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationsofPhoneNumber {

	static List<String> allPossibleStrings;
	static HashMap<Integer, String> integerCharacterMap;
	static int length;
	static String digits;
	public static void createLetterCombinations(int indx, String path){
		if(indx == length){
			allPossibleStrings.add(path);
			return;
		}
		char c = digits.charAt(indx);
		String listOfCharacters = integerCharacterMap.get(Integer.parseInt(String.valueOf(c)));
		for (int i = 0; i < listOfCharacters.length(); i++) {
			createLetterCombinations(indx+1, path+listOfCharacters.charAt(i));
		}
	}
	
	public static List<String> letterCombinations(String dig) {
		digits = dig;
		length = digits.length();
		allPossibleStrings = new ArrayList<>();
		if(length==0){
			return allPossibleStrings;
		}
		integerCharacterMap = new HashMap<>();
		integerCharacterMap.put(2, "abc");
		integerCharacterMap.put(3, "def");
		integerCharacterMap.put(4, "ghi");
		integerCharacterMap.put(5, "jkl");
		integerCharacterMap.put(6, "mno");
		integerCharacterMap.put(7, "pqrs");
		integerCharacterMap.put(8, "tuv");
		integerCharacterMap.put(9, "wxyz");
		createLetterCombinations(0, "");
		return allPossibleStrings;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String d = sc.next();
		letterCombinations(d);
		for (int i = 0; i < allPossibleStrings.size(); i++) {
			System.out.println(allPossibleStrings.get(i));
		}
		sc.close();
	}

}
