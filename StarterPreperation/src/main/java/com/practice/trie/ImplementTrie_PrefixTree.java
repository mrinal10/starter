package com.practice.trie;

public class ImplementTrie_PrefixTree {
	public static void main(String[] args) {
		Trie obj = new Trie();
		obj.insert("word");
//		boolean param_2 = obj.search("word");
//		boolean param_3 = obj.startsWith("wo");
	}
}

class Trie {
	TrieNode rootOfTrie = null;

	public Trie() {
		rootOfTrie = new TrieNode(26);
	}


	public void insert(String word) {
		TrieNode cur = rootOfTrie;
		char[] charArr = word.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			char c = charArr[i];
			int index = c - 97;
			if (cur.children[index] == null) {
				cur.children[index] = new TrieNode(26);
			}
			cur = cur.children[index];
		}
	}

	/** Returns if the word is in the trie. */
//	public boolean search(String word) {
//
//	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
//	public boolean startsWith(String prefix) {
//
//	}
}
