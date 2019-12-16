package com.prep.array;

public class TwoDHrGlass {
	static int hourglassSum(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<row-2; i++) {
			for(int j = 0; j<col-2; j++) {
				if (max<getValue(arr, i, j)) {
					max = getValue(arr, i, j);
				}
			}
		}
		return max;
    }
	
	static int getValue(int[][] arr, int i, int j) {
		int cnt = 0;
		for (int k = j; k < j+3; k++) {
			cnt += arr[i][k];
		}
		for (int k = j; k < j+3; k++) {
			cnt += arr[i+2][k];
		}
		cnt+=arr[i+1][j+1];
		return cnt;
	}
}
