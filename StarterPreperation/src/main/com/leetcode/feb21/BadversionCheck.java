package com.leetcode.feb21;

class Solution {
	public int firstBadVersion(int n) {
		int beg = 1;
		int last = n;
		int mid = 0;
		int pos = 1;
		while (beg <= last) {
			mid = beg + (last - beg) / 2;
			if (isBadVersion(mid)) {
				pos = mid;
				last = mid - 1;
			} else
				beg = mid + 1;
		}
		return pos;
	}

	private boolean isBadVersion(int n) {
		return true;
	}
}