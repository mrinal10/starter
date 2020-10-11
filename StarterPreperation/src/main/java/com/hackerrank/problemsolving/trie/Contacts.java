package com.hackerrank.problemsolving.trie;

public class Contacts {

	private static String ADD = "add";
	private static String FIND = "find";

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEndOfWord;
		int wordsReached;
		TrieNode() {
			wordsReached = 0;
			isEndOfWord = false;
			for (int i = 0; i < 26; i++)
				children[i] = null;
		}
	};

	static TrieNode root;

	static void insert(String key) {
		int level;
		int length = key.length();
		int index;

		TrieNode cur = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (cur.children[index] == null)
				cur.children[index] = new TrieNode();
			cur.wordsReached = cur.wordsReached+1;
			cur = cur.children[index];
		}
		cur.wordsReached = cur.wordsReached+1;
		cur.isEndOfWord = true;
	}

	static int search(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode cur = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (cur.children[index] == null)
				return 0;
			cur = cur.children[index];
		}
		if (cur != null){
			return cur.wordsReached;
		}
		return 0;
	}

	static int[] contacts(String[][] queries) {
		root = new TrieNode();
		int answerLen = 0;
		for (int i = 0; i < queries.length; i++) {
			if (queries[i][0].contains(FIND)) {
				answerLen++;
			}
		}
		int[] n = new int[answerLen];
		int c = 0;
		for (int i = 0; i < queries.length; i++) {
			if (queries[i][0].contains(ADD)) {
				insert(queries[i][1]);
			} else if (queries[i][0].contains(FIND)) {
				n[c] = search(queries[i][1]);
				c++;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		String[][] arr = {{"add", "s"}, {"find", "s"}};
		
		int[] a = contacts(arr);
		for(int i=0; i<a.length; i++){
			System.out.println(a[i]);
		} 
	}
}
