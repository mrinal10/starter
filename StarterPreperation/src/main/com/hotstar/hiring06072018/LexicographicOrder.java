package com.hotstar.hiring06072018;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LexicographicOrder {
	
	private static void calculate(String s, int noOfOp){
		int len = s.length();
		int ct = 0;
		Set<Character> charSet = new HashSet<>();
		
		charSet.add('a');
		charSet.add('e');
		charSet.add('i');
		charSet.add('o');
		charSet.add('u');
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < len && ct<noOfOp; i++) {
			if (charSet.contains(s.charAt(i))) {
				list.add(i);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			int indx = list.get(i);
			if (indx == 0) {
				s = getNext(String.valueOf(s.charAt(indx)))+s.substring(indx+1, s.length());
			}else if(indx==s.length()-1){
				s = s.substring(0, indx)+getNext(String.valueOf(s.charAt(indx)));
			}else{
				s = s.substring(0, indx)+getNext(String.valueOf(s.charAt(indx)))+s.substring(indx+1, s.length());
			}
		}
		System.out.println(s);
	}
	
	private static String getNext(String s){
		if (s.equals("a")) {
			return "b";
		}else if (s.equals("e")) {
			return "f";
		}else if (s.equals("i")) {
			return "j";
		}else if (s.equals("o")) {
			return "p";
		}else if (s.equals("u")) {
			return "s";
		}
		return "";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for (int i = 0; i < t; i++) {
			String s = sc.next();
			int noOfOp = sc.nextInt();
			calculate(s, noOfOp);
		}
		sc.close();
	}
}
