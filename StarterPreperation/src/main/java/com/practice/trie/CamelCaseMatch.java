package com.practice.trie;

import java.util.List;

class TrieDictionaryMatcher {
	int ALPHABET_COUNT = 57;
	TrieNode rootOfTrie;

	TrieDictionaryMatcher(TrieNode root) {
		rootOfTrie = root;
	}

	public void insert(String s) {
		char[] cArr = s.toCharArray();
		TrieNode cur = rootOfTrie;
		for (int i = 0; i < cArr.length; i++) {
			int index = (int) (cArr[i]-'A');
			if(cur.children[index] == null) {
				cur.children[index] = new TrieNode(ALPHABET_COUNT);
			}
			cur = cur.children[index];
		}
		cur.isEnd = true;
	}
	
	public boolean matchPattern(String pattern) {
		char[] cArr = pattern.toCharArray();
		int indx = 0;
		TrieNode cur = rootOfTrie;
		for (int i = 0; i < cArr.length; i++) {
			
		}
		return false;
		
	}
}

public class CamelCaseMatch {

	public List<Boolean> camelMatch(String[] queries, String pattern) {
		TrieNode root = new TrieNode(57);
		TrieDictionaryMatcher tMatcher = new TrieDictionaryMatcher(root);
		for (int i = 0; i < queries.length; i++) {
			tMatcher.insert(queries[i]);
		} 
		return null;
	}

	public static void main(String[] args) {

	}
}
