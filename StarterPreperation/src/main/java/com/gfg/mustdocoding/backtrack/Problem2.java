package com.gfg.mustdocoding.backtrack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Problem2 {
	private static int alphabetCount = 26;
	
	private static boolean only2Distinct(int[] count) {
		int totalUniquesPresent = 0;
		for(int i=0; i<alphabetCount; i++) {
			if(count[i]>0) {
				totalUniquesPresent++;
			}
			
		}
		if (totalUniquesPresent>2) {
			return false;
		}
		return true;
	}
	
	private static int getMxSbstr2DisUnqStr(String s) {
		int stringLen = s.length();
		
		//edge case -- if number of unique characters less than 2
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < stringLen; i++) {
			set.add(s.charAt(i));
		}
		if (set.size()<2) {
			return -1;
		}		
		
		int[] count = new int[alphabetCount];
		int curStart = 0;
		int maxLenStart = 0;
		int maxLenEnd = 1;
		int curEnd = 0;
		int maxWindowSize = 0;
		
		for(int i=0; i<stringLen; i++) {
			count[s.charAt(i)-'a']++;
			curEnd++;
			
			while (!only2Distinct(count)) {
				count[s.charAt(curStart)-'a']--;
				curStart++;
			}
			
			int length = curEnd - curStart;
			if (length > maxWindowSize) {
				maxWindowSize = length;
				maxLenStart = curStart;
				maxLenEnd = curEnd;
			}
		}
		System.out.println(s.substring(maxLenStart, maxLenEnd));
		return maxWindowSize;
		
		
	}
	
	enum Name {
		Alice, Smith, Bob, Jones
	}
	
	public static void main(String[] args) {
		
		//System.out.println("length :: "+getMxSbstr2DisUnqStr("abcbbbbcccbdddadacb"));
		//start();
		
//		LinkedList<String> list = new LinkedList<String>();
//		list.add("Val 1");
//		list.add("Val 2");
//		list.add("Val 3");
//		list.add("Random");
//		
//		Iterator<String> itr = list.descendingIterator();
//		while (itr.hasNext()) {
//			System.out.print(itr.next());			
//		}
		
		Set<Name> obj = new TreeSet<Problem2.Name>();
		obj.add(Name.Alice);
		obj.add(Name.Smith);
		obj.add(Name.Bob);
		obj.add(Name.Smith);
		
		for (Name d: obj) {
			System.out.println(d);			
		}
	}
	
	static void start() {
		boolean b1 = false;
		boolean b2 = fix(b1);
		System.out.println(b1+"  "+b2);
	}
	
	static boolean fix(boolean b1) {
		b1 = true;
		return b1;
	}
}
