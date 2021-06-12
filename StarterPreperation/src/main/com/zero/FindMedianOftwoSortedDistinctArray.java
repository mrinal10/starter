package com.zero;

public class FindMedianOftwoSortedDistinctArray {
	float median(int a[],int b[]){
		if (a.length > b.length) {
            return median(b, a);
        }
        int x = a.length;
        int y = b.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : a[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : b[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((float)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (float)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { 
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
		return 0;
	}
	
	
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7}; 
		int[] arr1 = {2, 4, 6, 8};
		FindMedianOftwoSortedDistinctArray czrs = new FindMedianOftwoSortedDistinctArray();
		System.out.println(czrs.median(arr, arr1));
	}

}
