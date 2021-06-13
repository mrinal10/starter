package com.leetcode.trie;

public class Trie {	
	TrieNode root;	
	Trie(){
		root = new TrieNode();
	}
	
	public void insert(String s) {
		s = s.toLowerCase();
		TrieNode cur = root;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			int indx = ((int) c) - ((int)'a');
			if(cur.children[indx]==null) {
				TrieNode temp = new TrieNode();
				cur.children[indx] = temp;
			}
			cur = cur.children[indx];
		}
		cur.isEndOfWord = true;
	}
	
	public boolean findWord(String s) {
		s = s.toLowerCase();
		TrieNode cur = root;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			int indx = ((int) c) - ((int)'a');
			if(cur.children[indx]==null) {
				return false;
			} else {
				cur = cur.children[indx];
			}
		}
		if(cur.isEndOfWord)
			return true;
		else
			return false;
	}
}


