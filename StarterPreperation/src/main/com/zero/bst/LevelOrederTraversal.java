package com.zero.bst;

class BeingZeroBST {
	void levelorder(BSTNode root) {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++){
            printGivenLevel(root, i);
        }
    }

	int height(BSTNode root) {
		if (root == null)
			return 0;
		else {
			int lheight = height(root.left);
			int rheight = height(root.right);

			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	void printGivenLevel(BSTNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
}

public class LevelOrederTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
