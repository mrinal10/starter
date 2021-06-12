package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Breakup_App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalLines = sc.nextInt();
		boolean dateFixed = getDetails(totalLines);
		if (dateFixed) {
			System.out.println("Date");
		} else {
			System.out.println("No Date");
		}
		sc.close();
	}
	
	private static ArrayList<Integer> getNumbers(String chatLine) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		chatLine = chatLine.replaceAll("[^0-9]+", " ");
		System.out.println(chatLine);
		String[] ar = chatLine.trim().split(" ");
		for (int i = 0; i < ar.length && ar[i]!=" " && ar[i]!=""; i++) {
			try {
				aList.add(Integer.valueOf(ar[i]) );
				System.out.println("ar[i] :: "+ar[i]);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} 
		return aList;
	}
	
	private static boolean getDetails(int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			int weightage = 1;
			if (line.startsWith("G")) {
				weightage = 2;
			}
			ArrayList<Integer> res = getNumbers(line);
			for (int j = 0; j < res.size(); j++) {
				int v = res.get(i);
				if(map.get(v)!=null) {
					int temp = map.get(v);
					temp+=temp+weightage;
					map.put(v, temp);
				} else {
					map.put(v, weightage);
				}
			}
		}
		sc.close();
		Set<Integer> set = map.keySet();
//		Iterator<Integer> it = set.iterator();
		int max = -1;
		int maxDate = 0;
		boolean isDate = true;
		for (Integer integer : set) {
			int count = map.get(integer);
			if (count>max) {
				max = count;
				maxDate = integer;
			} else if(count==max) {
				isDate = false;
			}
		}
		if (maxDate == 19 || maxDate == 20) {
			isDate = true;
		}
		return isDate;
	}
}
