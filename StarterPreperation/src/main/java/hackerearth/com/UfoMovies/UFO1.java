package com.UfoMovies;

import java.util.Scanner;

class TestClass {
	private int array[];
    private int length;
 
    public void sorting(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
            	swapper(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void swapper(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    public static void main(String a[]){
        Scanner sc = new Scanner(System.in); 
    	TestClass sorter = new TestClass();
    	int tCase = sc.nextInt();
    	for(int i=0; i<tCase; i++){
    		int numOfEle = sc.nextInt();
    		int[] input = new int[numOfEle];
    		for(int j=0; j<numOfEle; j++){
    			input[j] = sc.nextInt();
    		}
    		int peoplesToPlease = sc.nextInt();
//    		int[] input = {24,2,45,20,56,75,2,56,99,53,12};
    		
            sorter.sorting(input);
            for(int ink:input){
                System.out.print(ink);
                System.out.print(" ");
            }
    	}
               
        sc.close();
    }
}
