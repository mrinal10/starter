package com.prep.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	class QItemC {
		String word;
		int len;

		public QItemC(String w, int l) {
			word = w;
			len = l;
		}
	};

	private boolean isadjacent(String s, String comaprred) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != comaprred.charAt(i)) {
				cnt++;
			}
		}
		return (cnt <= 1);
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>();
		for (String words : wordList) {
			wordSet.add(words);
		}

		Queue<QItemC> queue = new LinkedList<>();
		QItemC item = new QItemC(beginWord, 1);
		queue.add(item);

		while (!queue.isEmpty()) {
			QItemC curr = queue.poll();
			Set<String> visited = new HashSet<>();
			for (String s : wordSet) {
				String temp = s;
				if (isadjacent(curr.word, temp)) {
					item.word = temp;
					item.len = curr.len + 1;
					queue.add(item);

					visited.add(temp);
					if (temp.equals(endWord))
						return item.len;
				}
			}
			for(String s : visited) {
				wordSet.remove(s);
			}
		}
		return 0;
	}

}
