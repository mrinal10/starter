package com.zero.bst;


public class CreateaBst {
	private static BSTNode root;
	
	private static BSTNode insert(int v){
		return insertaNode(root, v);
	}
	private static BSTNode insertaNode(BSTNode root, int value){
		if (root==null) {
			root = new BSTNode(value);
			return root;
		}
		if (value<=root.data)
			root.left = insertaNode(root.left, value);
		else
			root.right = insertaNode(root.right, value);
		return root;
	}
	private static void inorder(BSTNode root){
		if (root==null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int numOfNodes = sc.nextInt();
//		while (numOfNodes-->0) {
//			int value = sc.nextInt();
			root = insert(50); 
	        insert(30); 
	        insert(20); 
	        insert(40); 
	        insert(70); 
	        insert(20); 
	        insert(60); 
	        insert(80); 
	  
	        inorder(root); 
//		}
//		sc.close();
	}
}
