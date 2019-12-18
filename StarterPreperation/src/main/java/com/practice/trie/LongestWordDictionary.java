package com.practice.trie;

//https://leetcode.com/problems/longest-word-in-dictionary/

class TrieDictionary {
	static TrieNode rootOfTrie;

	TrieDictionary(TrieNode root) {
		rootOfTrie = root;
	}

	public void insert(String value) {
		char[] ar = value.toCharArray();
		TrieNode cur = rootOfTrie;
		for (int i = 0; i < ar.length; i++) {
			int index = value.charAt(i) - 'a';
			if(cur.children[index]==null) {
				cur.children[index] = new TrieNode(26);
			}
			cur = cur.children[index];
		}
		cur.isEnd = true;
	}

	public boolean search(String value) {
		char[] ar = value.toCharArray();
		TrieNode cur = rootOfTrie;
		for (int i = 0; i < ar.length; i++) {
			int index = value.charAt(i) - 'a';
			cur = cur.children[index];
			if (cur.isEnd != true) {
				return false;
			}
		}
		return true;
	}
}

public class LongestWordDictionary {
	public static String longestWord(String[] words) {
		TrieNode root = new TrieNode(26);
		TrieDictionary trieDictionary = new TrieDictionary(root);
		for (int i = 0; i < words.length; i++) {
			trieDictionary.insert(words[i]);
		}

		int length = 0;
		String name = "";
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > length && trieDictionary.search(words[i])) {
				length = words[i].length();
				name = words[i];
			}
		}
		return name;
	}
	
	public static void main(String[] args) {
		String[] names = {"w","wo","wor","worl","world"};
		System.out.println(longestWord(names));
	}
}
