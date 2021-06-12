package com.zero.contest3;

import java.util.*;

class BTNode {
	int val;
	BTNode left, right;

	public BTNode(int val) {
		this.val = val;
	}
}

class BT {

	BTNode root;

	int preStart;
	int preEnd;

	BT(int n, int[] in, int[] pre) {
		preStart = 0;
		preEnd = n - 1;
		root = makeTree(in, 0, n - 1, pre);
	}

	void printLevelsReverseOrder() {

		if (root == null) {
			return;
		}
		Queue<BTNode> q = new LinkedList<>();
		Stack<BTNode> s = new Stack<>();

		q.offer(root);
		while (!q.isEmpty()) {
			root = q.poll();
			if (root.right != null) {
				q.offer(root.right);
			}
			if (root.left != null) {
				q.offer(root.left);
			}
			System.out.print(root.val + " ");

//			s.push(root);
		}
//		while (!s.isEmpty()) {
////			System.out.print(s.pop().val + " ");
//		}

	}

	int getIdxOfRootInInorder(int[] in, int st, int end, int val) {
		for (int i = st; i <= end; i++) {
			if (in[i] == val) {
				return i;
			}
		}
		return -1;
	}

	BTNode makeTree(int[] in, int inStart, int inEnd, int[] pre) {

		if (inStart > inEnd) {
			return null;
		}

		if (preStart > preEnd) {
			return null;
		}

		BTNode root = new BTNode(pre[preStart]);
		int rIdx = getIdxOfRootInInorder(in, inStart, inEnd, pre[preStart]);
		preStart++;
		root.left = makeTree(in, inStart, rIdx - 1, pre);
		root.right = makeTree(in, rIdx + 1, inEnd, pre);

		return root;
	}

}

public class LevelOrderTRaversalInReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int i;
		int[] pre = new int[n];
		int[] in = new int[n];
		for (i = 0; i < n; i++) {
			pre[i] = sc.nextInt();
		}
		for (i = 0; i < n; i++) {
			in[i] = sc.nextInt();
		}
		sc.close();
		BT bt = new BT(n, in, pre);

		bt.printLevelsReverseOrder();
	}
}