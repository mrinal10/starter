package com.cognizant;

import java.util.Scanner;

public class String_In_Operation {
	
	private static String revString(String s, 
			int startingIndex, int endingIndex){
		String subST = s.substring(startingIndex, endingIndex);
		StringBuilder sBuild = new StringBuilder(subST);
		sBuild.reverse();
		try {
    		subST = s.substring(0,startingIndex)+sBuild.toString()+s.substring(endingIndex);
		} catch (Exception e) {
			e.printStackTrace();
		}					
		return subST;
	}
	
	private static String replaceCharacter(String s, int index, char ch){
		String newString = s.substring(0,index)+ch+s.substring(index+1);
		return newString;
	}
	
	private static int countSameCharacter(String s1, String s2){
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i)==s2.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);
		String input1 = SC.next(); 
		String input = ""; 
		int Q = SC.nextInt();
		int M = 0;
		try {
			
			for(int i=0; i<Q; i++){
				int ind = SC.nextInt();
				char ch = SC.next().charAt(0);
				
				input1 = replaceCharacter(input1, ind-1, ch);
			}
			System.out.println(input1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		M = SC.nextInt();
		try {
			input = input1;
			for(int i=0; i<M; i++){
				int a = SC.nextInt();
				int b = SC.nextInt();
				
				input = revString(input, a-1, b);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(input);
		System.out.println(countSameCharacter(input, input1));
	}

}