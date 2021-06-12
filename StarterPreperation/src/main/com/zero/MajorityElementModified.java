package com.zero;

public class MajorityElementModified {

	void printMajority(int a[]){
		int k = a[a.length/2];
		int sIndex = findFirstIndex(a, 0, a.length - 1, k);
		int lIndex = sIndex+((a.length)/2);
		if(a[lIndex]!=k){
			System.out.print("NONE");
			return;
		}
		System.out.print(k);
	}

	int findFirstIndex(int a[], int l, int h, int k) {
		int mid = (l + h) / 2;
		if (l <= h) {
			if ((a[mid] == k && mid == 0) || (a[mid] == k && a[mid - 1] < k) ){
				return mid;
			}else if (a[mid] < k) {
				return findFirstIndex(a, mid + 1, h, k);
			} else {
				return findFirstIndex(a, l, mid - 1, k);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,2,4,4,4,6,6};//{1,2,3,3,3,7,10}; 
			//{1,2,3,3,3,3,10};
		MajorityElementModified czrs = new MajorityElementModified();
		czrs.printMajority(arr);
	}
}