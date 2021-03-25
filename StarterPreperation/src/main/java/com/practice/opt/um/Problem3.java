package com.practice.opt.um;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int numOfLines = sc.nextInt();
		
		while(numOfLines-->0) {
			
		}
		sc.close();
	}
	
	public static String[] tableOfContents(String[] text){
		List<String> output = new ArrayList<String>();
		output = printIndex(text);
		String[] arr = new String[output.size()];
		int i = 0;
		for(String s : output) {
			arr[i] = s;
			i++;
		}
		return arr;		
	}
	
	private static List<String> printIndex(String[] lines) {
		List<String> output = new ArrayList<String>();
		int chapterNumber = 0;
		int verseNumber = 0;
		for(int i=1; i<lines.length; i++) {
			if(lines[i].startsWith("##")) { //verse
				verseNumber++;
				output.add(chapterNumber+"."+verseNumber+". "+lines[i]);
			} else if(lines[i].startsWith("#")) { //chapter
				verseNumber = 0;
				chapterNumber++;
				output.add(chapterNumber+". "+lines[i]);
			}
		}
		return output;
	}
}
