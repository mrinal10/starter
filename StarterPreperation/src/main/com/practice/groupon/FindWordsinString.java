package com.practice.groupon;

import java.util.Scanner;

class TNode {
	static final int ALPHABET_SIZE = 26;
	boolean isEOW;
	TNode[] next;

	TNode() {
		next = new TNode[ALPHABET_SIZE];
	}
}

public class FindWordsinString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sA = sc.nextLine();
		String sB = sc.nextLine();
		TNode root = new TNode();

		String[] sArr = sA.split(" ");
		for (int i = 0; i < sArr.length; i++) {
			insertWordInTrie(root, sArr[i]);
		}

		String[] sBrr = sB.split(" ");
		for (int i = 0; i < sBrr.length; i++) {
			System.out.println(sBrr[i]+" :: "+findWordInTrie(root, sBrr[i]) );
		}
		sc.close();
	}

	public static void insertWordInTrie(TNode root, String word) {
		TNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			int n = ((int) word.charAt(i)) - 97;
			if (cur.next[n] == null) {
				cur.next[n] = new TNode();
			}
			cur = cur.next[n];
		}
		cur.isEOW = true;
	}

	public static boolean findWordInTrie(TNode root, String word) {
		TNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			int n = ((int) word.charAt(i)) - 97;
			if (cur.next[n] != null) {
				cur = cur.next[n];
			} else {
				return false;
			}
		}
		if(cur.isEOW==true)
			return true;
		else
			return false;
	}
}
