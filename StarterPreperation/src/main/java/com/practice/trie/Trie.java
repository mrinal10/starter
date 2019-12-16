package com.practice.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

public class Trie {
	static List<String> allMatchedStrings;
	static TrieNode rootOfTree;

	Trie(TrieNode root) {
		rootOfTree = root;
	}

	private void insert(String key) {
		int level;
		int length = key.length();
		TrieNode pCrawl = rootOfTree;

		for (level = 0; level < length; level++) {
			int index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode(26);
			}
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isEnd = true;
	}

	private List<String> getMatchingWords(String prefix) {
		int level;
		int length = prefix.length();
		int index;
		TrieNode pCrawl = rootOfTree;

		for (level = 0; level < length; level++) {
			index = prefix.charAt(level) - 'a';
			if (pCrawl.children[index] == null)
				return null;
			pCrawl = pCrawl.children[index];
		}
		getStrings(pCrawl, prefix);
		Collections.sort(allMatchedStrings);
		int totalMatchedStrings = allMatchedStrings.size();
		int minLength = totalMatchedStrings < 3 ? totalMatchedStrings : 3;
		return allMatchedStrings.subList(0, minLength);
	}

	private void getStrings(TrieNode root, String prefix) {
		if (root.isEnd) {
			allMatchedStrings.add(prefix);
		}
		for (int i = 0; i < root.numberOfChildren; i++) {
			TrieNode temp = root.children[i];
			if (temp != null) {
				char c = (char) (97 + i);
				String s = prefix + String.valueOf(c);
				getStrings(temp, s);
			}
		}
	}

	public static void main(String[] args) {
		String keys[] = { "the", "ant", "there", "answer", "any", "by", "bye", "their" };
		TrieNode root = new TrieNode(26);
		Trie t = new Trie(root);

		for (int i = 0; i < keys.length; i++) {
			t.insert(keys[i]);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("What u wanna search : ");
		String prefix = sc.next();

		for (int i = 1; i < prefix.length(); i++) {
			System.out.println("for search String : " + prefix.substring(0, i + 1));
			allMatchedStrings = new ArrayList<String>();
			List<String> stringList = t.getMatchingWords(prefix);
			if (stringList == null) {
				System.out.println("OOPs none found");
				continue;
			}
			System.out.print("Matched Strings are : ");
			for (int j = 0; j < stringList.size(); j++) {
				System.out.print(stringList.get(j) + ", ");
			}
			System.out.println();
		}
		sc.close();
	}
}
