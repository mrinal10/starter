package com.leetcode.trie;

public class Problem1804 {
	TrieNode root;

	Problem1804() {
		root = new TrieNode();
	}

	public void insert(String s) {
		s = s.toLowerCase();
		TrieNode cur = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int indx = ((int) c) - ((int) 'a');
			if (cur.children[indx] == null) {
				TrieNode temp = new TrieNode();
				cur.children[indx] = temp;
			}
			cur = cur.children[indx];
			cur.prefixCount += 1;
		}
		cur.isEndOfWord = true;		
		cur.wordCount += 1;
	}
	
	public int countWordsEqualTo(String s) {
		s = s.toLowerCase();
		TrieNode cur = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int indx = ((int) c) - ((int) 'a');
			if (cur.children[indx] == null) {
				return 0;
			} else {
				cur = cur.children[indx];
			}
		}
		if (cur.isEndOfWord)
			return cur.wordCount;
		else
			return 0;
	}
	
	public int countWordsStartingWith(String s) {
		s = s.toLowerCase();
		TrieNode cur = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int indx = ((int) c) - ((int) 'a');
			if (cur.children[indx] == null) {
				return 0;
			} else {
				cur = cur.children[indx];
			}
		}
		return cur.prefixCount;
	}

	public boolean findWord(String s) {
		s = s.toLowerCase();
		TrieNode cur = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int indx = ((int) c) - ((int) 'a');
			if (cur.children[indx] == null) {
				return false;
			} else {
				cur = cur.children[indx];
			}
		}
		if (cur.isEndOfWord)
			return true;
		else
			return false;
	}
	
	public void erase(String s) {
		s = s.toLowerCase();
		TrieNode cur = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int indx = ((int) c) - ((int) 'a');
			if (cur.children[indx] == null) {
				return;
			} else {
				cur = cur.children[indx];
			}
		}
		if (cur.isEndOfWord) {
			cur.wordCount -= 1;
		}
	}
}

class TrieDriver{
	public static void main(String[] args) {
		String s1 = "test";
		String s2 = "test";
		String s3 = "testtty";
		Problem1804 trie = new Problem1804();
		trie.insert(s1);
		trie.insert(s2);
		System.out.println(trie.countWordsEqualTo("test"));
		trie.erase("test");
		System.out.println(trie.countWordsEqualTo("test"));
		trie.insert(s3);
		System.out.println(trie.findWord("test"));		
		System.out.println(trie.countWordsStartingWith("tes"));
	}
}