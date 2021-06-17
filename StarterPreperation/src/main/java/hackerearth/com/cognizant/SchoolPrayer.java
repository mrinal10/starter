package com.cognizant;

import java.util.Scanner;

class Node {
	 
    int data;
    Node left, right, parent;
 
    Node(int d) {
        data = d;
        left = right = parent = null;
    }
}


 
class BinarySearchTree {
	static int rootData = -1;
   
    Node insert(Node root, int data) {
        if (root == null) {        	
            return new Node(data);
        } else {
            Node temp = null;
            if (data>root.data && data<rootData) {
        		rootData = root.data;
			} else if(data>root.data){
				rootData = root.data;
			} else if(data<root.data) {
				if (data<rootData) {
					rootData = -1;
				}				
			}
            if (data <= root.data) {            	
                temp = insert(root.left, data);
                root.left = temp;
                temp.parent = root;
            } else {
                temp = insert(root.right, data);
                root.right = temp;
                temp.parent = root;
            }
            return root;
        }
    }
    
    Node getMaxNode(Node node){
    	Node current = node;
    	while(node.right!=null) {
    		node = node.right;
		}
    	return current;
    }
          
    void inorderRec(Node root, int key) {
        if (root != null ) {
            inorderRec(root.left,key);
            System.out.println(root.data);
            inorderRec(root.right,key);
        }
    }
}

public class SchoolPrayer {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < noOfTestCases; i++) {
			int n = sc.nextInt();
			BinarySearchTree tree = new BinarySearchTree();
			tree.rootData = -1;
			Node root = null;
			sum = 0;
			for (int j = 0; j < n; j++) {
				int tNum = sc.nextInt();
		        root = tree.insert(root, tNum);
		        sum = sum+tree.rootData;
				
			}
			System.out.println(sum);
		} 
        
    }
}
