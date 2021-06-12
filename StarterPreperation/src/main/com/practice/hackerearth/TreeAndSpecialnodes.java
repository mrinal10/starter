package com.practice.hackerearth;

import java.util.*;

public class TreeAndSpecialnodes {
	static int[] allNodesArray;
	static Map<Integer, ArrayList<Integer>> tree;
	static int specialNodeCnt = 0;
	static Set<Integer> alredayVisited;
	
	private static boolean containsChar(String str, int c) {
//		System.out.println(str);
		String[] stringArray = str.split(":");
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i].equals(String.valueOf(c))) {
				return true;
			}
		}
		return false;
	}

	private static void traverseTree(int rootIndex, String mileStones) {
		specialNodeCnt++;
		if (!tree.containsKey(rootIndex)) {
			return;
		}
		ArrayList<Integer> allChild = tree.get(rootIndex);
		for (int i = 0; i < allChild.size(); i++) {
			int childIndex = allChild.get(i);
			if (!containsChar(mileStones, allNodesArray[childIndex-1]) && !alredayVisited.contains(childIndex)) {
				alredayVisited.add(childIndex);
				traverseTree(childIndex, mileStones+":"+allNodesArray[childIndex-1]);
			}
		}
	}

	public static void main(String[] args) {
		alredayVisited = new HashSet();
		Scanner sc = new Scanner(System.in);
		int numberOfNodes = sc.nextInt();
		allNodesArray = new int[numberOfNodes];
		for (int i = 0; i < numberOfNodes; i++) {
			allNodesArray[i] = sc.nextInt();
		}
		tree = new HashMap<>();
		int numberOfEdges = numberOfNodes - 1;
		while (numberOfEdges-- > 0) {
			int src = sc.nextInt();
			int destn = sc.nextInt();
			ArrayList<Integer> allchildNodes = null;
			if (tree.containsKey(src)) {
				allchildNodes = tree.get(src);
				allchildNodes.add(destn);
			} else {
				allchildNodes = new ArrayList<>();
				allchildNodes.add(destn);
			}
			tree.put(src, allchildNodes);
			
			allchildNodes = null;
			if (tree.containsKey(destn)) {
				allchildNodes = tree.get(destn);
				allchildNodes.add(src);
			} else {
				allchildNodes = new ArrayList<>();
				allchildNodes.add(src);
			}
			tree.put(destn, allchildNodes);
		}
		alredayVisited.add(1);
		traverseTree(1, ""+allNodesArray[0]);
		System.out.println(specialNodeCnt);
		sc.close();
	}
}