package com.zero.contest1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;

public class DiagonlaMatrixPrint2 {
	static HashMap<Integer, List<Integer>> map = new HashMap<>();

	private static void diagonalPrint(int[][] ar) {
		int index = 0;
		for (int j = 0; j < ar.length; j++) {
			index = j;
			for (int k = 0; k < ar[0].length; k++) {
				List<Integer> list = new ArrayList<>();
				if (map.containsKey(index)) {
					list = map.get(index);
				}
				list.add(ar[j][k]);
				map.put(index, list);
				index++;
			}
		}
	}

	public static void main(String[] args) {
		int[][] ar = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, 
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
		
		diagonalPrint(ar);
		for(Entry<Integer, List<Integer>> entry : map.entrySet()){
			List<Integer> list = entry.getValue();
			for (Integer values : list) {
				System.out.print(values+" ");
			}
		}
		System.out.println();
		for(Entry<Integer, List<Integer>> entry : map.entrySet()){
			List<Integer> list = entry.getValue();
			Collections.reverse(list);
			ListIterator<Integer> itr =  list.listIterator(list.size());
			while (itr.hasNext()) {
				System.out.print(itr.next()+" ");
			}
		}
	}

}
