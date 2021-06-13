package com.leetcode.trie;

public class TrieNode {
	private int ALPHABET_SIZE = 26;
	TrieNode[] children = new TrieNode[ALPHABET_SIZE];
	boolean isEndOfWord;
	int wordCount;
	int prefixCount = 0;
	
	
	TrieNode() {
		isEndOfWord = false;
		int wordCount = 0;
		prefixCount = 0;
		for (int i = 0; i < ALPHABET_SIZE; i++)
			children[i] = null;
	}
}
