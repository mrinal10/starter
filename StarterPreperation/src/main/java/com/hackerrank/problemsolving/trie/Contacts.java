package com.hackerrank.problemsolving.trie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Contacts {

	private static String ADD = "add";
	private static String FIND = "find";

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEndOfWord;

		TrieNode() {
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
			cur = cur.children[index];
		}
		cur.isEndOfWord = true;
	}

	static boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode cur = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (cur.children[index] == null)
				return false;
			cur = cur.children[index];
		}
		return (cur != null && cur.isEndOfWord);
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
				n[c] = search(queries[i][1]) ? 1 : 0;
				c++;
			}
		}
		return n;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int queriesRows = Integer.parseInt(scanner.nextLine().trim());

		String[][] queries = new String[queriesRows][2];

		for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");

			for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
				String queriesItem = queriesRowItems[queriesColumnItr];
				queries[queriesRowItr][queriesColumnItr] = queriesItem;
			}
		}

		int[] result = contacts(queries);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bufferedWriter.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
