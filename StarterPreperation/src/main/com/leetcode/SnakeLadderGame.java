package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class QItem{
	private int jey; 
	private List<Integer> listOfVa;
	public QItem(int key, List<Integer> ll) {
		jey = key;
		listOfVa = ll;
	}
	public int getJey() {
		return jey;
	}
	public void setJey(int jey) {
		this.jey = jey;
	}
	public List<Integer> getListOfVa() {
		return listOfVa;
	}
	public void setListOfVa(List<Integer> listOfVa) {
		this.listOfVa = listOfVa;
	}
}

public class SnakeLadderGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] ar = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ar[i][j] = sc.nextInt();
			}
		}
		SnakeLadderGame snakeLadderGame = new SnakeLadderGame();
		System.out.println(snakeLadderGame.snakesAndLadders(ar));
		sc.close();
	}

	public int snakesAndLadders(int[][] board) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int limit = board.length*board.length;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				List<Integer> valueList =  new ArrayList<>();
				int key = ((i-1)*board.length)+j;
				int val = board[i][j];
				if (val!=-1) {
					valueList.add(val);
				}else{
					for(int indx = key+1; indx<=limit && indx<key+7; indx++){
						valueList.add(indx);
					}
				}
				graph.put(key, valueList);
			}
		}
		Queue<QItem> queue = new LinkedList<>();
		queue.add(new QItem(1, graph.get(1)));
		Set<Integer> visited = new HashSet<>();
		
		int hopCount = -1;
		while (!queue.isEmpty()) {
			QItem cur = queue.poll();
			int key = cur.getJey();
			if (!visited.contains(key)) {
				visited.add(key);
				List<Integer> allDestn = cur.getListOfVa();
				if (key==limit) {
					queue.clear();
				}else{
					for (int i = 0; i < allDestn.size(); i++) {
						queue.add(new QItem(allDestn.get(i), graph.get(allDestn.get(i))));
					}
				}
			}
		}
		return hopCount;
	}
}
