package com.leetcode.hard.bfs;

import java.util.ArrayList;
import java.util.List;

public class Leetcode126 {
	public static void main(String[] args) {
		List<String> set = new ArrayList<String>();
		set.add("DAMP");
		set.add("CAME");
		set.add("LAMP");
		set.add("LIMP");
		set.add("TAME");
		set.add("LIME");
		set.add("LIKE");

		String src = "DAMP";
		String target = "LIKE";
		List<String> li = new ArrayList<String>();
		li.add(src);
		Leetcode126 l = new Leetcode126();
		l.findLadders(src, target, set);
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		return null;
	}
}
