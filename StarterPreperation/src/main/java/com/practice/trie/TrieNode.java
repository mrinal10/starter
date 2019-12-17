package com.practice.trie;

class TrieNode {
	boolean isEnd;
	int numberOfChildren;
	TrieNode[] children;

	TrieNode(int childCnt) {
		isEnd = false;
		numberOfChildren = childCnt;
		children = new TrieNode[26];
		for (int i = 0; i < childCnt; i++) {
			children[i] = null;
		}
	}
}