package com.zero;

public class FindingAkelaInArrayBitwise {

	static int findAkela(int ar[]) {
		int retVal = ar[0];
        for (int i = 1; i < ar.length; i++)
        	retVal = retVal ^ ar[i];
     
        return retVal;
    }
	
	public static void main(String[] args) {
		FindingAkelaInArrayBitwise fkl = new FindingAkelaInArrayBitwise();
		int[] arr = {2, 3, 5, 4, 5, 3, 4};//{1, 33, 33, 44, 55, 6, 77, 6 , 1};
		System.out.println(findAkela(arr));
	}

}
