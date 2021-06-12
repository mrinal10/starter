package com.codechef;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


class LAPIN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			try {
				String s = sc.next();
				String s1;
				String s2;
				if (s.length()%2!=0) {
					s1 = s.substring(0, s.length()/2);
					s2 = s.substring(s.length()/2+1,s.length());
				} else {
					s1 = s.substring(0, s.length()/2);
					s2 = s.substring( (s.length()+1)/2,s.length());
				}
				
				HashMap<Character, Integer>  fMap = getHashedData(s1);
				HashMap<Character, Integer>  sMap = getHashedData(s2);
				
				Set<Character> set1 = fMap.keySet();
				Set<Character> set2 = sMap.keySet();
				String gflag = "YES";
				if (set1.equals(set2)) {
					for (Iterator<Character> iterator = set2.iterator(); iterator.hasNext();) {
						Character character = (Character) iterator.next();
						if (fMap.get(character) != sMap.get(character)) {
							gflag = "NO";
							break;
						}
					}
				}else{
					gflag = "NO";
				}
				System.out.println(gflag);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sc.close();
	}
	
	private static HashMap<Character, Integer> getHashedData(String s){
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.get(c)!=null) {
				int count = map.get(c);
				map.put(c, count+1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}
}
