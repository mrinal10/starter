package com.ae.hiring;

import java.util.ArrayList;
import java.util.Scanner;

class DiameterFind{
	private int getHeight(ArrayList<ArrayList<Integer>> adjacencyList, int index) {
		index--;
//		System.out.println(adjacencyList.size()+" <<<< getHeight >>>> "+index);
		if (adjacencyList.size()<=index) {
			return 0;
		}
//		System.out.println(adjacencyList.size()+" <<<< 11 getHeight >>>> "+index);
		if (!adjacencyList.get(index).isEmpty()) {
			if (adjacencyList.get(index).size() == 1) {
				return 1 + getHeight(adjacencyList, adjacencyList.get(index).get(0));
			}
			return 1 + Math.max(getHeight(adjacencyList, adjacencyList.get(index).get(0)), 
					getHeight(adjacencyList, adjacencyList.get(index).get(1)));
		}
		return 0;
	}

	public int findDiameter(ArrayList<ArrayList<Integer>> adjacencyList, int index) {
		index--;
		if (adjacencyList.size()<=index) {
			return 0;
		}
		if (!adjacencyList.get(index).isEmpty()) {
			int leftH = getHeight(adjacencyList, adjacencyList.get(index).get(0));
			int leftDiameter = findDiameter(adjacencyList, adjacencyList.get(index).get(0));
			int rightH = 0;
			int rightDiameter = 0;
			if (adjacencyList.get(index).size() == 2) {
				rightH = getHeight(adjacencyList, adjacencyList.get(index).get(1));
				rightDiameter = findDiameter(adjacencyList, adjacencyList.get(index).get(1));
			}
			return getMax(leftH + rightH + 1, leftDiameter, rightDiameter);
		}
		return 0;
	}
	private int getMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}
}


public class DiameterofAllSubtreesofaTree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list= new ArrayList<>();
			adjacencyList.add(list);
		}
		for(int i=0; i<n-1; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			ArrayList<Integer> list;
			if (adjacencyList.size()>=u) {
				list = adjacencyList.get(u-1);
				adjacencyList.remove(u-1);
				list.add(v);
			}else{
				list = new ArrayList<>();
				list.add(v);
			}
			adjacencyList.add(u-1, list);
		}
		for (int i = 1; i <=n; i++) {
			DiameterFind dFind = new DiameterFind();
			System.out.print(dFind.findDiameter(adjacencyList, i)+" ");
		}
		sc.close();
	}
}
