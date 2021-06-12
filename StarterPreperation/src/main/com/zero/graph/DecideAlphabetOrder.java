package com.zero.graph;

import java.util.*;

public class DecideAlphabetOrder {
	static Set<Character> alreadyVisited;
	static Stack<Character> allNode;
	static HashMap<Character, ArrayList<Character>> map;
	
	static void topSortUtil(char node){
		alreadyVisited.add(node);
		List<Character> adjacentNodelist = map.get(node);
		if (adjacentNodelist==null) {
			allNode.add(node);
			return;
		}
		for (Iterator<Character> iterator = adjacentNodelist.iterator(); iterator.hasNext();) {
			char integer = iterator.next();
			if (!alreadyVisited.contains(integer)) {
				topSortUtil(integer);
			}
		}
		allNode.add(node);
	}
	
	static void topSort(){ 
		alreadyVisited = new HashSet<>();
		allNode = new Stack<Character>();
		Set<Character> set = map.keySet();
		for (Iterator<Character> iterator = set.iterator(); iterator.hasNext();) {
			char integer = (Character) iterator.next();
			if (!alreadyVisited.contains(integer)) {
				topSortUtil(integer);
			}
		}
		while (allNode.empty()==false)
            System.out.print(allNode.pop() + " ");
	}
	private static void createMap(String[] arr){
		map = new HashMap<>();
		for (int i = 0; i < arr.length-1; i++) {
			String f = arr[i];
			String s = arr[i+1];
			int flen = f.length();
			int slen = s.length();
			if (flen>slen) {
				flen = slen;
			}
			int indx=0;
			while(indx<=flen){
				if (f.charAt(indx)!=s.charAt(indx)) {
					break;
				}
				flen--;
				slen--;
				indx++;
			}
			ArrayList<Character> charList = new ArrayList<>();
			if (map.containsKey(f.charAt(indx))) {
				charList = map.get(f.charAt(indx));
			}
			if (!charList.contains(s.charAt(indx))) {
				charList.add(s.charAt(indx));
			}
			map.put(f.charAt(indx), charList);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-->0){
			int n = sc.nextInt();
			String[] arr = new String[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.next();
			}
			createMap(arr);
			topSort();
		}
		sc.close();
	}

}
