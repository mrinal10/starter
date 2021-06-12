package com.keltontech.hiring30062018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromicGrid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int row,column;
			row = sc.nextInt();
			column = sc.nextInt();
			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; j < row; j++) {
				String c = sc.next();
				for (int j2 = 0; j2 < column; j2++) {
					if ( map.get(String.valueOf(c.charAt(j2)) )!=null) {
						int t=map.get(String.valueOf(c.charAt(j2)));
						map.put(String.valueOf(c.charAt(j2)), t+1);
					}else{
						map.put(String.valueOf(c.charAt(j2)),1);
					}
				}
			}
			
			if ((row*column%2)==0) {
				checkallcountEven(map);
			}else{
				checkallcountEvenExceptOne(map);
			}
		}
		sc.close();
	}
	
	private static void checkallcountEven(HashMap<String, Integer> map){
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			if (entry.getValue()%2!=0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	private static void checkallcountEvenExceptOne(HashMap<String, Integer> map){
		int count=0;
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			if (entry.getValue()%2!=0) {
				count++;
				if (count>1) {
					System.out.println("NO");
					return;	
				}
			}
		}
		System.out.println("YES");
	}
}
