package com.prep.tree;

//https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
public class HuffMan_hackerrank {
	int curIndx = 0;
	void decode(String s, Node root) {
        char[] characters = s.toCharArray();
        int startIndx = 0;
        String s1 = "";
        while (startIndx < characters.length) {
            s1 += getCharacter(root, characters, curIndx, 1);
            startIndx = curIndx;
        }
        System.out.println(s1);
    }

    private char getCharacter(Node root, char[] path, 
            int startIndex, int endIndex) {
        Node temp = root;
        while (true) {
            if (temp.left == null && temp.right == null) {
                curIndx = startIndex;
                return temp.data; //correct
            }
            char c = path[startIndex];
            if (c == '0') {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
            startIndex++;
        }
    }
}
