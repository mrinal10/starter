package com.interviewbit;

import java.util.Scanner;

public class EncodeIt {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		String str = sc.next();
		String p = sc.next();
		char[] cArr = p.toCharArray();
		int i = 0;
		StringBuilder builder = new StringBuilder("");
		while(i<str.length()){
			int oldPosition = getIndx(cArr, str.charAt(i));
			int newPosition = (int) (Math.pow(2, oldPosition)%26);
			builder.append(cArr[newPosition]);
			i++;
		}
		sc.close();
		System.out.println(builder.toString());
	}
	
	private static int getIndx(char[] cArr, char c){
		for(int i=0; i<cArr.length; i++){
			if(c==cArr[i]){
				return i;
			}
		}
		return -1;
	}
}
