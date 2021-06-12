package com.zero;

public class Findingnumberinsortedrowcolmtrix {

	void findNumberInSortedGrid(int arr[][], int key) {
	   int rowCnt = arr.length;
	   int colCnt = arr[0].length;
	   int roc = rowCnt-1;
	   int colc = 0;
	   while(colc <colCnt && colc>=0 && roc>=0 && roc<rowCnt) {
		   int curVal = arr[roc][colc];
		   if(key==curVal){
			   System.out.println(roc+" "+colc);
			   return;
		   }else if(key<curVal){
			   roc--;
		   }else{
			   colc++;
		   }
	   }
	   System.out.println(-1);
	}
	
	void printSpirally(int arr[][]) {
		int rowCnt = arr.length;
		int colCnt = arr[0].length;
		
		
		for (int i = 0; i < colCnt; i++) {
			System.out.print(arr[0][i]+", ");
		}
		   
	}
	
	
	void printSpirallyRecursive(int arr[][], int rl, int cl, int r, int c) {
		
		
	}
	
	public static void main(String[] args) {
		int[][] ar = {{1,2,3,4},{6,8,9,10},{7,11,12,13}};
		Findingnumberinsortedrowcolmtrix fgc = new Findingnumberinsortedrowcolmtrix();
		fgc.printSpirally(ar);//, 0);
	}

}
