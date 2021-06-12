package com.article.practice.medium.article;

public class MinimumNumberOfJumps {

//	private static int getMinimumJumpCount(int[] arr, int startingPt, int endingPt){
//		if (startingPt == endingPt) {
//			return 0;
//		} 
//		if(arr[startingPt] == 0) {
//			return Integer.MAX_VALUE;
//		}
//
//			 int min = Integer.MAX_VALUE;
//			 for (int i = 1+1; i <= arr[startingPt] && i<startingPt+arr[startingPt]; i++) {
//				int jumps = getMinimumJumpCount(arr, i, endingPt);
//	            if(jumps != Integer.MAX_VALUE && jumps + 1 < min) {
//	            	min = jumps + 1;
//	            }
//			}
//		return 0;
//	}

	
	 static int getMinimumJumpCount(int arr[], int l, int h)
	   {
	        // Base case: when source 
	        // and destination are same
	        if (h == l)
	        return 0;
	 
	        // When nothing is reachable 
	        // from the given source
	        if (arr[l] == 0)
	        return Integer.MAX_VALUE;
	 
	        // Traverse through all the points 
	        // reachable from arr[l]. Recursively
	        // get the minimum number of jumps 
	        // needed to reach arr[h] from these
	        // reachable points.
	        int min = Integer.MAX_VALUE;
	        for (int i = l+1; i <= h && i <= l + arr[l]; i++)
	        {
	            int jumps = getMinimumJumpCount(arr, i, h);
	            if(jumps != Integer.MAX_VALUE && jumps + 1 < min){
	              min = jumps + 1;
	            }
	             
	        }
	        return min;
	        
	   }
	 
	   // Driver code
	   public static void main(String args[])
	   {
	        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5}; 
	        int n = arr.length;
	        System.out.print("Minimum number of jumps to reach end is "
	                          + getMinimumJumpCount(arr, 0, n-1));
	   }

}
