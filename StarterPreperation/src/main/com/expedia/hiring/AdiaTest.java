package com.expedia.hiring;

import java.util.ArrayList;
import java.util.Scanner;

class TreeNode {
	ArrayList<TreeNode> allNodes;
	int value;

	TreeNode(int n, int numberOfchilds) {
		allNodes = new ArrayList<>(numberOfchilds);
		value = n;
	}
}

public class AdiaTest {
	private static TreeNode root;
	private static String maxPath;
	private static int maxPartialSum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCases = sc.nextInt();
		while (testCases-- > 0) {
			int n = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				arr.add(sc.nextInt());
			}
			root = new TreeNode(0, arr.size());
			createTree(root, arr);
			findMaxpath(root);
			System.out.println(maxPartialSum);
		}
		sc.close();
	}

	private static int calculateDiff(int a, int b){
		char[] aa = String.valueOf(a).toCharArray();
		char[] bb = String.valueOf(b).toCharArray();
		int diff = 0;
		int ak = aa.length;
		int bk = bb.length;
		int minLen = Math.min(aa.length, bb.length);
		for (int i = minLen; i > 0; i--) {
			diff += Math.abs(Integer.parseInt(String.valueOf(aa[ak-1]))
						- Integer.parseInt(String.valueOf(bb[bk-1])));
			ak--;
			bk--;
		}
		return diff;
	}

	private static void findMaxpath(TreeNode root) {
		maxPath = "";
		maxPartialSum = 0;
		findMaxpathUtil(root, maxPath, 0);
	}

	
	private static void findMaxpathUtil(TreeNode rootNode, String path, int partialSum) {
		
			if (partialSum>maxPartialSum) {
				maxPartialSum = partialSum;
				maxPath = path;
			}
		
		
		if (rootNode.value!=0) {
			for (int i = 0; i < rootNode.allNodes.size(); i++) {
				TreeNode nxtNode = rootNode.allNodes.get(i); 
				findMaxpathUtil(nxtNode, path+" "+String.valueOf(nxtNode.value), 
						partialSum+calculateDiff(nxtNode.value, rootNode.value));
			}
		}else{
			for (int i = 0; i < rootNode.allNodes.size(); i++) {
				TreeNode nxtNode = rootNode.allNodes.get(i); 
				findMaxpathUtil(nxtNode, path+" "+String.valueOf(nxtNode.value), 
						partialSum);
			}
		}
	}
	private static TreeNode createTree(TreeNode root, ArrayList<Integer> arr) {
		if (arr.size()==0) {
			return null;
		}
		for (int j = 0; j < arr.size(); j++) {
			TreeNode curNode = new TreeNode(arr.get(j), arr.size()-1);
			arr.remove(j);
			root.allNodes.add(curNode);
			createTree(curNode, arr);
			arr.add(j, curNode.value);
		}
		return root;
	}

}
