package com.hackerearth.hiring;

import java.util.ArrayList;
import java.util.Scanner;


class Hiring1 {

	private static boolean isVowel(char c){
		if(c=='a' ||c=='e' ||c=='i' ||c=='o' ||c=='u'){
			return true;
		}
		return false;
	}
	
	private static boolean isPresentMoreThanTwo(String s){
		char[] cc = s.toCharArray();
		char c = cc[0];
		for(int i=1; i<s.length(); i++){
			if (c!=cc[i]) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isPresent(String s, int indxS, int indxE){
		
		String sub = s.substring(indxS, indxE+1);
		return isPresentMoreThanTwo(sub);
	}
	
	private static void getV(String s){
		ArrayList<Integer> list = new ArrayList<>();
		char[] arr = s.toCharArray();
		for(int i=0; i<s.length(); i++){
			if(isVowel(arr[i])){
				list.add(i);
			}
		}
		if (list.size()==0) {
			System.out.println("No");
			return;
		}
		int starting = list.get(0);
		int ending = list.get(0);
		int curLength = 1;
		for(int i=1; i<list.size(); i++){
			int t = list.get(i);
			if (t==ending+1) {
				ending = t;
				curLength++;
				if (curLength>1) {
					if(isPresent(s, starting, ending)){
						System.out.println("Yes");
						return;
					}
				}
			}else{
				starting = t; 
				ending = t;
				curLength = 1;
			}
		}
		System.out.println("No");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			String s = sc.next();
			getV(s);
		}
		sc.close();
	}

}
