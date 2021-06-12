package com.zero.tree;

public class PracticeTreeMirrorImage {
	BTNode root = null;
	
	private void inOrder(){
		inOrder(root);
	}
	
	private void inOrder(BTNode rut){
		if(rut==null){
			return;
		}
		inOrder(rut.left);
		System.out.println(rut.data);
		inOrder(rut.right);
	}
	
	private void mirror(){
		mirror(root);
	}
	
	private BTNode mirror(BTNode rut){
		if(rut == null){
			return null;
		}
		
		BTNode tempLeft = mirror(rut.left);
		BTNode tempRight = mirror(rut.right);
		
		rut.left = tempRight;
		rut.right = tempLeft;
		
		return rut;
	}
	
	public static void main(String[] args) {
	
		PracticeTreeMirrorImage tree = new PracticeTreeMirrorImage(); 
        tree.root = new BTNode(1); 
        tree.root.left = new BTNode(2); 
        tree.root.right = new BTNode(3); 
        tree.root.left.left = new BTNode(4); 
        tree.root.left.right = new BTNode(5); 
  
        
        System.out.println("Inorder traversal of input tree is :"); 
        tree.inOrder(); 
        System.out.println(""); 
  
        /* convert tree to its mirror */
        tree.mirror(); 
  
        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : "); 
        tree.inOrder(); 
	}
}
