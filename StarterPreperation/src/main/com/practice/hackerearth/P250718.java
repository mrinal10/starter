package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P250718 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		List<Integer> alist = new ArrayList<>();
		for (int i = 0; i < n1; i++) {
			alist.add(sc.nextInt());
		}
		int n2 = sc.nextInt();
		List<Integer> clist = new ArrayList<>();
		for (int i = 0; i < n2; i++) {
			clist.add(sc.nextInt());
		}
		
		Collections.sort(alist);
		Collections.sort(clist);
		int sLimit = -alist.get(alist.size())+clist.get(clist.size());
		
		
		int limit = -alist.get(alist.size())+clist.get(clist.size());
		if (limit<0) {
			limit = (-1)*limit;
		}
	}
	
	
}
