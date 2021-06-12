package com.zero.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Prob24 {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		Character[] arr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		
		HashMap<Character, Integer> charMap = new HashMap<>();
		charMap.put('a', 1);
		charMap.put('b', 2);
		charMap.put('c', 3);
		charMap.put('d', 4);
		charMap.put('e', 5);
		charMap.put('f', 6);
		charMap.put('g', 7);
		charMap.put('h', 8);
		charMap.put('i', 9);
		charMap.put('j', 10);
		charMap.put('k', 11);
		charMap.put('l', 12);
		charMap.put('m', 13);
		charMap.put('n', 14);
		charMap.put('o', 15);
		charMap.put('p', 16);
		charMap.put('q', 17);
		charMap.put('r', 18);
		charMap.put('s', 19);
		charMap.put('t', 20);
		charMap.put('u', 21);
		charMap.put('v', 22);
		charMap.put('w', 23);
		charMap.put('x', 24);
		charMap.put('y', 25);
		charMap.put('z', 26);
		
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			Set<Character> set = new HashSet<>(Arrays.asList(arr));
	      String s = sc.nextLine();
	      String s1 = sc.nextLine();
	      for (int j = 0; j < s1.length(); j++) {
			Character c = s1.charAt(j);
			set.remove(c);
		  }
	      Iterator<Character> it1 = set.iterator();
	      int cnt = 0;
	      while (it1.hasNext()) {
			cnt = cnt + charMap.get(it1.next());
		  }
	      System.out.println(cnt);
		}


	}
}
