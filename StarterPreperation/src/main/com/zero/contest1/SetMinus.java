package com.zero.contest1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SetMinus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCaess = sc.nextInt();
		while (testCaess-->0) {
			Set<Integer> setA = new HashSet<>();
			Set<Integer> setB = new HashSet<>();
			
			int setAcnt = sc.nextInt();
			while (setAcnt-->0) {
				setA.add(sc.nextInt());
			}
			
			int setBcnt = sc.nextInt();
			while (setBcnt-->0) {
				setB.add(sc.nextInt());
			}
			
			for (Iterator<Integer> iterator = setB.iterator(); iterator.hasNext();) {
				Integer intofB = iterator.next();
				if (setA.contains(intofB)) {
					setA.remove(intofB);
				}
			}
			
			for (Iterator<Integer> iteratorA = setA.iterator(); iteratorA.hasNext();) {
				System.out.println(iteratorA.next());
			}
		}
		sc.close();
	}

}
