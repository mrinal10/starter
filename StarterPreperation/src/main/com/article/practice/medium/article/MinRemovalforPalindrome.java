package com.article.practice.medium.article;

import java.util.HashMap;
import java.util.Map.Entry;

public class MinRemovalforPalindrome {

	
	private static void getCount(String s) {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for (int i = 0; i < s.length(); i++) {
			String temp = String.valueOf(s.charAt(i));
			int currentV = 0;
			if (hashMap.containsKey(temp)) {
				currentV = 1 + hashMap.get(temp);
			} else {
				currentV += 1;
			}
//			System.out.println(temp +" :::: "+ currentV);
			hashMap.put(temp, currentV);
		}
		int countOfDeletion = 0;
		int numberOfOdds = 0;
		for (Entry<String, Integer> entry : hashMap.entrySet()) {
          if (entry.getValue()%2!=0) {
			countOfDeletion++;
			numberOfOdds++;
          }
	    }
		if (numberOfOdds>0) {
			countOfDeletion -= 1;
		}
		System.out.println(countOfDeletion);
		
	}
	
	public static void main(String[] args) {
		getCount("hdkoklnfkgnkdh");
	}
}
