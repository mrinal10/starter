package com.Spoj;


import java.util.Scanner;

public class NextPalindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int n = sc.nextInt();
			nextPalindrome(n);
		}
	}
	
	private static int[] arrayasList(int n){
		int length = String.valueOf(n).length();
		int a[] = new int[length];
		int i = length-1;
		while (n>0) {
			a[i] = n%10;
			n = n/10;
			i--;
		}
		return a;
	}
	
	private static boolean isPalindrome(int[] n){
		boolean flag = false;
		for (int i = 0; i < n.length/2; i++) {
			if (n[i] == n[n.length-1-i]) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	private static void nextPalindrome(int n){
		int[] arr = arrayasList(n);
		
		
		int length = arr.length;
		
		int mid = length/2;
		
		int i = mid-1;
		int j = (n%2 == 0) ? mid: mid+1;
		printarray(arr);
		boolean leftSmaller = false;
		
		while (i>0 && arr[i] == arr[j]) {
			i--; j++;
		}
		
		if (arr[i] < arr[j]) {
			leftSmaller = true;
		}
		
		while (i >= 0) {
			arr[j] = arr[i];
			j++;
			i--;
		}

		if (leftSmaller) {
			int carry = 1;
	         
            // If there are odd digits, then increment
            // the middle digit and store the carry
            if (n % 2 == 1) {
                arr[mid] += 1;
                carry = arr[mid] / 10;
                arr[mid] %= 10;
            }
            i = mid - 1;
            j = (n % 2 == 0 ? mid : mid + 1);
             
            while (i >= 0) 
            {
            	arr[i] = arr[i] + carry;
                carry = arr[i] / 10;
                arr[i] %= 10;
                arr[j] = arr[i];// copy mirror to right
                i--;
                j++;
            }
		}
		
		printarray(arr);
	}
	
	private static void printarray(int num[]) {
        for (int i = 0; i < num.length; i++)
            System.out.print(num[i]);
        System.out.println();
    }
}
