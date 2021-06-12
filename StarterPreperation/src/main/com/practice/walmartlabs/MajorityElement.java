package com.practice.walmartlabs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MajorityElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-->0){
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = sc.nextInt();
			}
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < ar.length; i++) {
				int k = ar[i];
				int freq = 0;
				if (map.containsKey(k)) 
					freq = map.get(k);
				map.put(k, freq+1);
			}
			int v = -1;
			for(Entry<Integer, Integer> entry : map.entrySet()){
				if (entry.getValue()>=n/2) {
					v = entry.getKey();
					break;
				}
			}
			System.out.println(v);
		}
		sc.close();
	}
}
