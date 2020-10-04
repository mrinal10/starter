package leetcode.segmenttree;

public class SegmentTree {
	static int[] A;
	static int[] tree;
	
	public static void main(String[] args) {
		A = new int[]{1,2,3,4,5,6,7,8};
		tree = new int[4*(A.length)+1];
		build(0, 0, A.length);
	}

	static void build(int node, int start, int end) {
		if (start == end) {
			// Leaf node will have a single element
			tree[node] = A[start];
		} else {
			int mid = (start + end) / 2;
			// Recurse on the left child
			build(2 * node, start, mid);
			// Recurse on the right child
			build(2 * node + 1, mid + 1, end);
			// Internal node will have the sum of both of its children
			tree[node] = tree[2 * node] + tree[2 * node + 1];
		}
	}

}
