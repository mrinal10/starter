package com.leetcode.bfs;

import java.util.List;

public class Node1 {
	public int val;
    public List<Node1> children;

    public Node1() {}

    public Node1(int _val,List<Node1> _children) {
        val = _val;
        children = _children;
    }
}
