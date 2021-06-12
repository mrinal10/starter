package com.barclays.hiring24082018;

import java.util.ArrayList;
import java.util.Scanner;

public class FindingTheWord {
	private static int startingIndex = 0;
	private static int minDiff = Integer.MAX_VALUE;
	private static ArrayList<Integer> listOfIndexess = new ArrayList<>();
	private static void findChars(String toFind, int startingIndx){
		String s = "barclays";
		int cnt = 0;
		ArrayList<Integer> listOfIndexes = new ArrayList<>();
		for (int i = 0; i < toFind.length(); i++) {
			if(s.charAt(i)!=toFind.charAt(i)){
				cnt++;
				listOfIndexes.add(i+startingIndx);
			}
		}
		if(cnt<minDiff){
			minDiff = cnt;
			listOfIndexess = listOfIndexes;
			startingIndex = startingIndx;
		}
	}
	
	private static void findCharsAll(String toFind){
		for(int i=0; i<=toFind.length()-8; i++){
			findChars(toFind.substring(i, i+8), i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		findCharsAll(str);
		sc.close();
		System.out.println(minDiff);
		for (int i = 0; i < listOfIndexess.size(); i++) {
			System.out.print(listOfIndexess.get(i)+" ");
		}
	}

}
