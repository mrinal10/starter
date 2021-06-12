package com.zero.contest3;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class P2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-->0){
			ConcurrentHashMap<Character, Integer> map1 = new ConcurrentHashMap<>();
			ConcurrentHashMap<Character, Integer> map2 = new ConcurrentHashMap<>();
			
			String name1 = sc.next();
			String name2 = sc.next();
			
			for (int i = 0; i < name1.length(); i++) {
				Character temp = name1.charAt(i);
				if (map1.containsKey(temp)) {
					map1.put(temp, map1.get(temp)+1);
				}else{
					map1.put(temp, 1);
				}
			}
			
			for (int i = 0; i < name2.length(); i++) {
				Character temp = name2.charAt(i);
				if (map2.containsKey(temp)) {
					map2.put(temp, map2.get(temp)+1);
				}else{
					map2.put(temp, 1);
				}
			}
			
			for (Entry<Character, Integer> entry : map1.entrySet()) {
				Character c = entry.getKey();
				if (map2.containsKey(c)) {
					map1.remove(c);
					map2.remove(c);
				}
			}
			
			int remainingLen = map1.entrySet().size()+map2.entrySet().size();
			remainingLen = remainingLen%5;
			char[] a = {'F','L','A','M','E'};
			if (remainingLen<0) {
				
			}else if (remainingLen>0) {
				char cc = a[remainingLen-1];
				a[remainingLen-1] = 'L';
				a[1]=cc;
			}
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
			}
			
		}
		sc.close();
	}
}
