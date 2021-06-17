package com.lenskart.Hiring03022018;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Problem2 {
	private static HashMap<Character,Integer> createDictionary(String S){
		HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();
		char ar[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for (int i = 0; i < ar.length; i++) {
			if (S.indexOf(ar[i])!=-1) {
				dictionary.put(ar[i], 1);
			}
		}		
		return dictionary;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t>0) {
			t--;
			String s = sc.next();
			HashMap<Character, Integer> map = createDictionary(s);
			
			Set<Character> keys = map.keySet();
			
			if (keys.size()%2==0) {
				System.out.println("Player2");
			} else {
				System.out.println("Player1");
			}
		}
		sc.close();
	}
}
