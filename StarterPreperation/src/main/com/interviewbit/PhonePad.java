package com.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;


public class PhonePad {

	public static void main(String[] args) {
		PhonePad pp = new PhonePad();
		ArrayList<String> list = pp.letterCombinations("23");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	HashMap<String, String> phonePadMap;
	ArrayList<String> aList;
	String typedValue;
	public ArrayList<String> letterCombinations(String A) {
		aList = new ArrayList<>();
		typedValue = A;
		phonePadMap = new HashMap<String, String>();
		phonePadMap.put("1", "");
		phonePadMap.put("2", "abc");
		phonePadMap.put("3", "def");
		phonePadMap.put("4", "ghi");
		phonePadMap.put("5", "jkl");
		phonePadMap.put("6", "mno");
		phonePadMap.put("7", "pqrs");
		phonePadMap.put("8", "tuv");
		phonePadMap.put("9", "wxyz");
		phonePadMap.put("0", "");
		letterCombinationsUtil(0, "");
		return aList;
    }
	
	private void letterCombinationsUtil(int index, String s){
		if (index==typedValue.length()) {
			aList.add(s);
			return;
		}
		String curV = String.valueOf(typedValue.charAt(index));
		String curKey = phonePadMap.get(curV);
		
		for (int i = 0; i < curKey.length(); i++) {
			letterCombinationsUtil(index+1, s+String.valueOf(curKey.charAt(i)));
		}
	}
	
}
