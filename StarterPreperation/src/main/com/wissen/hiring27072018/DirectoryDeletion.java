package com.wissen.hiring27072018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DirectoryDeletion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		Map<Integer, List<Integer>> tree = generateTree(ar);

		int totDeleteCnt = sc.nextInt();
		int[] arDel = new int[totDeleteCnt];
		for (int i = 0; i < totDeleteCnt; i++) {
			arDel[i] = sc.nextInt();
		}
		Arrays.sort(arDel);

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arDel.length; i++) {
			set.add(arDel[i]);
		}

		for (int i = 0; i < arDel.length; i++) {
			int a = arDel[i];
			List<Integer> list = getListOfChilds(a, tree);
			for (int j = 0; j < list.size(); j++) {
				if (set.contains(list.get(j)) && a != list.get(j)) {
					set.remove(list.get(j));
				}
			}
//			System.out.println(list.toString());
		}
		System.out.println(set.size());
		sc.close();
	}

	private static List<Integer> getListOfChilds(int root, Map<Integer, List<Integer>> tree) {
		List<Integer> list = new ArrayList<Integer>();

		if (!tree.containsKey(root)) {
			list.add(root);
			return list;
		}
		List<Integer> masterList = new ArrayList<Integer>();
		list = tree.get(root);
		ListIterator<Integer> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			try {
				List<Integer> list1 = getListOfChilds(listIterator.next(), tree);
				masterList.addAll(list1);
			} catch (Exception e) {
				System.err.print(e);
			}
		}
		masterList.add(root);
		return masterList;
	}

	private static Map<Integer, List<Integer>> generateTree(int[] ar) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < ar.length; i++) {
			List<Integer> valueList = new ArrayList<Integer>();
			if (map.containsKey(ar[i])) {
				valueList = map.get(ar[i]);
			}
			valueList.add(i + 1);
			map.put(ar[i], valueList);
		}
		return map;
	}
}