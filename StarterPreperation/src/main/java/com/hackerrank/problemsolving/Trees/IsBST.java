package com.hackerrank.problemsolving.Trees;

class ISBst{
    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        if (root == null) 
            return true; 
        if ((root.left!=null && root.left.data > root.data) 
                || (root.right!=null && root.right.data < root.data)) 
            return false; 
        return (checkBST(root.left) && checkBST(root.right)); 
    } 
}