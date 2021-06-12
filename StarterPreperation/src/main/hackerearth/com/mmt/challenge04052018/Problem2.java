package com.mmt.challenge04052018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		String s;
		Scanner sc = new Scanner(System.in);
		
		s = sc.next();
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int length_of_candies = sc.nextInt();
//			System.out.println("length_of_candies :: "+length_of_candies);
			int min = Integer.MAX_VALUE;
			for(int j=0; j<s.length()-length_of_candies; j++) {
//				System.out.println("j :: "+ j );
				for(int k=length_of_candies; k<s.length()-j; k++) {
					
//					System.out.println("j+k :: "+ (j+k) );
					if (getPalindrome(s.substring(j, j+k), length_of_candies)) {
						if(min > k) {
							min = k;
						}
						if (min == length_of_candies) {
							break;
						}
					}
				}
			}
			System.out.println(min);
		}
		sc.close();
	}
	
	public static boolean getPalindrome(String s, int length) {
//		System.out.println("getPalindrome : "+s);
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (map.get(c)!=null) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		int ct = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet())
		{
		    if(entry.getValue()%2==0) {
		    	ct += entry.getValue();
		    } else {
		    	ct += entry.getValue()-1;
		    	map.put(entry.getKey(), 1);
		    }
		}
		if (length%2==0) {
			if (ct>=length) {
				return true;
			}
		} else {
			for (Map.Entry<Character, Integer> entry : map.entrySet())
			{
			    if(entry.getValue()%2!=0) {
			    	ct += entry.getValue();
			    	break;
			    }
			}
			if (ct>=length) {
				return true;
			}
		}
		return false;
	}
}
