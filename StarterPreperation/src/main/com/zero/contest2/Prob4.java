package com.zero.contest2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Prob4 {

	static HashMap<Integer, List<Integer>> mapp = new HashMap<>();

	private static int getEqualElement(List<Integer> list) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			int v = iterator.next();
			if (map.containsKey(v)) {
				map.put(v, map.get(v) + 1);
			} else {
				map.put(v, 1);
			}
		}

		int maxV = 1;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (maxV < entry.getValue()) {
				maxV = entry.getValue();
			}
		}
		List<Integer> values = new ArrayList<>();
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (maxV == entry.getValue()) {
				values.add(entry.getKey());
			}
		}
		mapp.put(maxV, values);
		return maxV;
	}

	private static List<Integer> getList(List<Integer> list, int i) {
		List<Integer> newList = new ArrayList(list.size());
		for (int j = 0; j < list.size(); j++) {
			newList.add(j, list.get(j));
		}
		for (int j = 0; j < list.size(); j++) {
			if (i == j) {
				newList.set(j + 1, newList.get(j) + newList.get(j + 1));
			} else {
				newList.set(j, newList.get(j));
			}
		}
		return newList;
	}

	private static void hlpr(List<Integer> list, int n) {
		if(n==list.size()){
			return;
		}
		List<Integer> newList = new ArrayList<>();
		for (int i = n; i < list.size(); i++) {
			newList = getList(list, i);
			int maxV = getEqualElement(newList);
			hlpr(newList, i+1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCses = sc.nextInt();
		while (testCses-- > 0) {
			int n = sc.nextInt();
			List<Integer> arr = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				arr.add(sc.nextInt());
			}

			hlpr(arr, 1);
			for (Entry<Integer, List<Integer>> entry : mapp.entrySet()) {
				System.out.println(entry.getKey());
				List<Integer> newList = entry.getValue();
				for (int i = 0; i < newList.size(); i++) {
					System.out.print(newList.get(i) + " ");
				}
				System.out.println(">>>>>>>>>");
			}
		}
		sc.close();
	}

}
