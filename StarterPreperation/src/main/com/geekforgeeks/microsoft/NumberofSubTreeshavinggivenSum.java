package com.geekforgeeks.microsoft;

public class NumberofSubTreeshavinggivenSum {

	public static void main(String[] args) {

	}
	static int cnt = 0;
	static int trgt = 0;
	private static int countSubtreesWithSumX(Node root, int x){
		cnt = 0;
		trgt = x;
		countSubtrees(root);
		return cnt;
    }
	
	private static int countSubtrees(Node root){
		if (root == null) {
			return 0;
		}
		int leftV = countSubtrees(root.left);
		int rightV = countSubtrees(root.right);
		if (root.data+leftV+rightV == trgt) {
			cnt++;
		}
		return root.data+leftV+rightV;
	}

}
