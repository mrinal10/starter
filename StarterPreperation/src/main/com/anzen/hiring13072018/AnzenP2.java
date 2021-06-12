package com.anzen.hiring13072018;

import java.util.ArrayList;
import java.util.Scanner;

public class AnzenP2 {
	public static void main(String arr[]) {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	int t = sc.nextInt();
    	char[] charArr = s.toCharArray();
    	ArrayList<Character> charList = new ArrayList<>();
    	for (int i = 0; i < charArr.length; i++) {
			charList.add(charArr[i]);
		}
    	StringBuilder X = new StringBuilder("");
    	for (int i = 0; i < charArr.length; i++) {
    		int leastIndx = getLeastCharIndex(charList,t);
			X = X.append(String.valueOf(charList.get(leastIndx)));
			charList.remove(leastIndx);
		}
    	System.out.println(X);
    	sc.close();
    }
	
	private static int getLeastCharIndex(ArrayList<Character> list, int t){
		int indx = 0;
		Character cc = list.get(0);
		for (int i = 0; i < t && i<list.size(); i++) {
			Character tmp = list.get(i);
			if (i==0) {
				System.out.println("<<<<<< "+tmp);
			}
			if (tmp<cc) {
				indx = i;
				cc = tmp;
			}
			System.out.println(tmp+" >>>>> "+indx);
		}
		System.out.println(">>>>>>>");
		return indx;
	}
}
