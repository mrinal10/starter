package com.prep.tree;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CutTree {
	public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
		Map<Integer, List<Integer>> tree = getTree(edges);
		int treeTotal = getTotal(data);
		int minDiff = Integer.MAX_VALUE;
		
		for (Entry<Integer, List<Integer>> entry : tree.entrySet()) {
			List<Integer> values = entry.getValue();
			for (int i : values) {
				Set<Integer> set = new HashSet<Integer>();
				set.add(entry.getKey());
				int subtreeTotal = calculateDFS(tree, data, i, set);
				int otherSUbtreeValue = treeTotal - subtreeTotal;
				int difference = Math.abs(subtreeTotal - otherSUbtreeValue);
				if (difference < minDiff) {
					minDiff = difference;
				}
			}
		}
		return minDiff;
	}

	private static int calculateDFS(Map<Integer, List<Integer>> tree, 
			List<Integer> data, int index, Set<Integer> visited) {
		if (!tree.containsKey(index)) {
			return data.get(index - 1);
		}
		int tot = 0;
		List<Integer> list = tree.get(index);
		for (int i : list) {
			if (!visited.contains(i)) {
				visited.add(i);
				tot += calculateDFS(tree, data, i, visited);
			}
		}
		return tot+data.get(index-1);
	}

	private static int getTotal(List<Integer> data) {
		int total = 0;
		for (int val : data) {
			total += val;
		}
		return total;
	}

	private static Map<Integer, List<Integer>> getTree(List<List<Integer>> edges) {
		Map<Integer, List<Integer>> tree = new HashMap<Integer, List<Integer>>();
		for (List<Integer> list : edges) {
			int fromNode = list.get(0);
			int toNode = list.get(1);
			List<Integer> toNodeList = new ArrayList<Integer>();
			if (tree.containsKey(fromNode)) {
				toNodeList = tree.get(fromNode);
			}
			toNodeList.add(toNode);
			tree.put(fromNode, toNodeList);
			
			
			toNodeList = new ArrayList<Integer>();
			if (tree.containsKey(toNode)) {
				toNodeList = tree.get(toNode);
			}
			toNodeList.add(fromNode);
			tree.put(toNode, toNodeList);
		}
		return tree;
	}



}

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<List<Integer>> edges = new ArrayList<>();

		IntStream.range(0, n - 1).forEach(i -> {
			try {
				edges.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = CutTree.cutTheTree(data, edges);

		System.out.println(String.valueOf(result));

		bufferedReader.close();
	}
}
