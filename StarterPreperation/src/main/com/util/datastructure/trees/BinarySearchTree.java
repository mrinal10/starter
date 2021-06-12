package com.util.datastructure.trees;

import java.util.Scanner;

public class BinarySearchTree {

	class Node{
		int data;
		Node leftNode, rightNode;
		
		Node(int value){
			this.data = value;
			leftNode = rightNode = null;
		}
	}
	
	private Node rootNode;
	
	public BinarySearchTree() {
		rootNode = null;
	}

	public void insert(int key) {
		rootNode = insertData(rootNode, key);
	}
	
	public Node insertData(Node root, int data) {
		if (root == null) {
			root = new Node(data);
		}
		else {
			if (root.data<data) {
				root.rightNode = insertData(root.rightNode, data);
			} else {
				root.leftNode = insertData(root.leftNode, data);
			}
		}
		return root;
	}
	
	public void inorderTraversal(Node rootNode) {
		if (rootNode!=null) {
			inorderTraversal(rootNode.leftNode);
			System.out.println(" :: "+rootNode.data);
			inorderTraversal(rootNode.rightNode);
		}
	}
	
	public void preorderTraversal(Node rootNode) {
		if (rootNode!=null) {
			System.out.println(" :: "+rootNode.data);
			preorderTraversal(rootNode.leftNode);
			preorderTraversal(rootNode.rightNode);
		}
	}
	
	public void postorderTraversal(Node rootNode) {
		if (rootNode!=null) {
			postorderTraversal(rootNode.leftNode);
			postorderTraversal(rootNode.rightNode);
			System.out.println(" :: "+rootNode.data);
		}
	}
	
	public void deleteElement(Node root,int value) {
		if (root.data < value) {
			deleteElement(root.leftNode, value);
		} else if(root.data > value) {
			deleteElement(root.rightNode, value);
		} else {
			Node nodeTobeDeleted = root;
			if (root.rightNode != null) {
				root = root.rightNode;
				while(root.leftNode!=null) {
					root = root.leftNode;
				}
				nodeTobeDeleted.data = root.data;
				root = null;
			} else if (root.leftNode != null) {
				root = root.leftNode;
				while(root.rightNode!=null) {
					root = root.rightNode;
				}
				nodeTobeDeleted.data = root.data;
				root = null;
			} else {
				nodeTobeDeleted = null;
			}
		}
	}

	
	public int getMaxdepth(Node root) {
		if (root == null) {
			return 0;
		} else {
			int lMax = getMaxdepth(root.leftNode);
			int rMax = getMaxdepth(root.rightNode);
			
			if(lMax<rMax) {
				return rMax+1;
			} else {
				return lMax+1;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BinarySearchTree bst = new BinarySearchTree();
		for(int i =0; i<n; i++) {
			int val = sc.nextInt();
			bst.insert(val);
		}
		bst.inorderTraversal(bst.rootNode);
		System.out.println(bst.getMaxdepth(bst.rootNode));
//		bst.preorderTraversal(bst.rootNode);
//		bst.postorderTraversal(bst.rootNode);
		
		sc.close();
	}
	
}

