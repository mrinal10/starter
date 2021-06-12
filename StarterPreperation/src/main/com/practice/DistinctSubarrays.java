package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class DistinctSubarrays {
	static HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
	static void createSubsets(int[] set)
    {
        int n = set.length;
        for (int i = 0; i < (1<<n); i++)
        {
            TreeSet<Integer> theSet = new TreeSet<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                	theSet .add(set[j]);
                }
            }
            System.out.println(theSet);
            if (hMap.get(theSet.size())!=null) {
				hMap.put(theSet.size(), hMap.get(theSet.size())+1);
			} else {
				hMap.put(theSet.size(), 1);
			}
        }
        
        for (Map.Entry<Integer, Integer> entry : hMap.entrySet()){
        	System.out.println(entry.getValue());
        }
        
    }
	
	private static int getsetSize(int[] array) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}
		
		return set.size();
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] ar = new int[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = sc.nextInt();
		}
		
		createSubsets(ar);
	}

}
