package com.problems.matrix;
class GFG {
	public static int computeLongestSubarray(int arr[], 
												int k)
	{
		int maxLength = 1;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			int minOfSub = arr[i];
			int maxOfSub = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > maxOfSub)
					maxOfSub = arr[j];

				if (arr[j] < minOfSub)
					minOfSub = arr[j];

				if ((maxOfSub - minOfSub) <= k) {
					int currLength = j - i + 1;
					System.out.println("currLength :: "+currLength);
					if (maxLength < currLength)
						maxLength = currLength;
				}
			}
			System.out.println("maxOfSub :: "+maxOfSub);
            System.out.println("minOfSub :: "+minOfSub);
		}
		return maxLength;
	}

	// Driver Code
	public static void main(String[] args)
	{
		int arr[] = { 2, 3, 4 , 13 };

		int k = 2;

		int maxLength = computeLongestSubarray(arr, k);
		System.out.println(maxLength);
	}
}
