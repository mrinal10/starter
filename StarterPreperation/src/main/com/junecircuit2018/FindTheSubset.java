package com.junecircuit2018;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Pair {
	private int value1, value2;

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}
}

public class FindTheSubset {
	public static void main(String[] args) {
		 int n,m,d;
		 Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 m = sc.nextInt();
		 d = sc.nextInt();
		 
		 Set<Integer> set = new HashSet<Integer>();
		 for (int i = 0; i < n; i++) {
			set.add(sc.nextInt());
		 }
		 HashMap<Pair, Integer> map = new HashMap<Pair, Integer>();
		 for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			for (Iterator iterator1 = set.iterator(); iterator.hasNext();) {
				Integer integer2 = (Integer) iterator.next();
				
				if (integer+integer2>d) {
					Pair pair = new Pair();
					pair.setValue1(integer);
					pair.setValue2(integer2);
					map.put(pair, 1);
				}
			}
			
		}
		 sc.close();
	}
}
