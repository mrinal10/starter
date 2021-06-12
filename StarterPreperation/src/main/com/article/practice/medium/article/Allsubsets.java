package com.article.practice.medium.article;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Allsubsets {
	private static List<List<Integer>> list1 = new ArrayList<List<Integer>>();
	private static void allSubsets(int[] list){
		int len = list.length;
		for(int i = 0; i<(1 << len); i++){
			List<Integer> li = new ArrayList<Integer>();
			for (int j = 0; j < list.length; j++) {
				int v = 1<<j;
				if ((i&v)>0 && list[j]!=0) {
					li.add(list[j]);
				}
			}
			list1.add(li);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] set = new int[n];
		for (int i = 0; i < set.length; i++) {
			int t = sc.nextInt();
			set[i] = t;
			allSubsets(set);
		}
		System.out.println(list1.size());
		for (Iterator<List<Integer>> iterator = list1.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			for (Iterator<Integer> iterator2 = list.iterator(); iterator2.hasNext();) {
				Integer integer = (Integer) iterator2.next();
//				System.out.println(">>>>"+integer);
			}
//			System.out.println(">>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<");
		}
		sc.close();
	}
}
