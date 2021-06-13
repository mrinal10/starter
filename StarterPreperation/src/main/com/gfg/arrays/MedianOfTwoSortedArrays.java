package com.gfg.arrays;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 7, 19 };
		int[] nums2 = { 3, 4, 7, 9 };

		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;

		int totalLength = l1 + l2;
		int indx = totalLength / 2;
		if (totalLength % 2 != 0) {
			return (double) getIndexedValues(indx, nums1, nums2);
		}
		return getIndexedValues(indx - 1, indx, nums1, nums2);
	}

	public static int getIndexedValues(int indx, int[] n1, int[] n2) {
		int i = 0;
		int i1 = 0;
		int i2 = 0;
		while (i1 < n1.length && i2 < n2.length) {
			if (n1[i1] < n2[i2]) {
				if (i == indx) {
					return n1[i1];
				}
				i1++;
			} else {
				if (i == indx) {
					return n2[i2];
				}
				i2++;
			}
			i++;
		}

		while (i1 < n1.length) {
			if (i == indx) {
				return n1[i1];
			}
			i1++;
			i++;
		}
		while (i2 < n2.length) {
			if (i == indx) {
				return n2[i2];
			}
			i2++;
			i++;
		}
		return -1;
	}

	public static double getIndexedValues(int indx1, int indx2, int[] n1, int[] n2) {
		return (double) (getIndexedValues(indx1, n1, n2) + getIndexedValues(indx2, n1, n2)) / 2;
	}
}
