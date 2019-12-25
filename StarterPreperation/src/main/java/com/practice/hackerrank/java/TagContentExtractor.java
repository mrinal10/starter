package com.practice.hackerrank.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TagContentExtractor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String line = in.nextLine();
			List<String> list = getContentList(line);
			for (String s : list) {
				System.out.println(s);
			}
			testCases--;
		}
		in.close();
	}

	private static List<String> getContentList(String s) {
		List<String> ss = new ArrayList<String>();
		
		return ss;
	}

}
