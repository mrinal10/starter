package com.zero.backtracking;

public class PrintBinaryNBitKsetBits {

	void printNBitNumbersWithKBitsSet(int n, int k) {
		int[] s = new int[n];
		printKsetBitHelper(s, n, k, 0, 0);
	}
	
	void printKsetBitHelper(int[] s, int n, int k, int currentSetBits, int indx){
		if(indx>=n){
			return;
		}
		if(currentSetBits>k){
			return;
		}
		if(k==currentSetBits){
			for (int i = 0; i < s.length; i++) {
				System.out.print(s[i]);
			}
			System.out.println();
		}
		
		for (int i = 0; i < s.length; i++) {
			printKsetBitHelper(s,n,k,currentSetBits,indx+1);
			s[indx]=1;
			printKsetBitHelper(s,n,k,currentSetBits+1,indx+1);	
		}
	}
	
	
	
	public static void main(String[] args) {
		PrintBinaryNBitKsetBits pBinkBits = new PrintBinaryNBitKsetBits();
		pBinkBits.printNBitNumbersWithKBitsSet(6,2);

	}

}
