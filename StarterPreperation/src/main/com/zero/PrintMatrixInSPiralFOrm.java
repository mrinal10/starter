package com.zero;

public class PrintMatrixInSPiralFOrm {
	void printSpirallyHelper(int arr[][], int rowCnt, int colCNt, int rowLim, int colLim, String s) {
		if(rowCnt>=rowLim || colCNt>=colLim){
			System.out.println(s.substring(0, s.length()-2));
			return;
		}
		for(int i=colCNt; i<colLim; i++){
			s += arr[rowCnt][i]+", ";
		}
		for(int i=rowCnt+1; i<rowLim; i++){
			s += arr[i][colLim-1]+", ";
		}
		if((rowLim-rowCnt)>1){
			for(int i=colLim-2; i>=colCNt; i--){
				s += arr[rowLim-1][i]+", ";
			}
		}
		if((colLim-colCNt)>1){
			for(int i=rowLim-2; i>rowCnt; i--){
				s += arr[i][colCNt]+", ";
			}
		}
		printSpirallyHelper(arr, rowCnt+1, colCNt+1, rowLim-1, colLim-1, s);
	}
	
	void printSpirally(int arr[][]) {
		printSpirallyHelper(arr, 0, 0, arr.length, arr[0].length, "");
	}

	public static void main(String[] args) {
		int[][] arr =  {{1, 6, 7, 9}, {3, 5, 8, 2}};
		//{{ 1, 2, 3 },	{ 4, 5, 6 }, { 7, 8, 9 }, {10, 11, 12}};
		//{{1, 2, 3 ,	4},{ 5, 6, 7, 8}, {9, 10, 11, 12}};
		//{{ 1, 2, 3 },	{ 4, 5, 6 }, { 7, 8, 9 }};
		PrintMatrixInSPiralFOrm spiralForm = new PrintMatrixInSPiralFOrm();
		spiralForm.printSpirally(arr);
	}

}
