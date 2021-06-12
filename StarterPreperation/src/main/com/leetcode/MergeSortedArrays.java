package com.leetcode;

public class MergeSortedArrays {
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};//{1,0};//
		int[] nums2 = {2,5,6};//{2};//
//		merge(nums1, 1, nums2, 1);
		merge(nums1, 3, nums2, 3);
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]+" ");
		}
	}
	
	private static void replace(int[] arr, int indx){
		int prev = 0;
		int temp = arr[indx];
		for(int i=indx; i<arr.length-1; i++){
			prev = arr[i+1];
			arr[i+1] = temp;
			temp = prev;
		}
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=0;
        int l=0;
        while(k<m+1 && l<n){
            if(nums1[k]>nums2[l]){
            	replace(nums1, k);
            	nums1[k]=nums2[l];
                l++;
            }
            k++;
        }
        if(k>=m+n){
            return;
        }
        if(k>0 && nums1[k-1]==0){
        	k--;
        }
        for(int i=l; i<n; i++){
        	nums1[k] = nums2[i];
        	k++;
        }
    }
}
