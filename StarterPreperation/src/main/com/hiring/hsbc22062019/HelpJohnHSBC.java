package com.hiring.hsbc22062019;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HelpJohnHSBC {
	static List<Integer> longPriorityQueue;
	
	
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i_arr=0; i_arr<N; i_arr++)
        {
            arr[i_arr] = sc.nextInt();
        }

        longPriorityQueue = new ArrayList<Integer>();
        solve(arr, N);
        sc.close();
    }
    static void solve(int[] arr, int N){
    	
        for (int i = 0; i < arr.length; i++) {
        	int grtr = getGreater(arr[i]);
        	int smlr = getSmaller(arr[i]);
        	
        	longPriorityQueue.add(arr[i]);
        	Collections.sort(longPriorityQueue);
        	System.out.println(smlr+"  "+grtr);
		}
    
    }
    
    static int getGreater(int value) {
    	Iterator<Integer> pQitrtr = longPriorityQueue.iterator();
    	int defValue = -1;
    	for (Iterator<Integer> iterator = pQitrtr; iterator.hasNext();) {
			Integer arrValue = iterator.next();
			if (arrValue>value) {
				defValue = arrValue;
				break;
			}
		}
    	return defValue;
    }
    
    static int getSmaller(int value) {
    	Iterator<Integer> pQitrtr = longPriorityQueue.iterator();
    	int defValue = -1;
    	for (Iterator<Integer> iterator = pQitrtr; iterator.hasNext();) {
			Integer arrValue = iterator.next();
			if (arrValue>=value) {
				break;
			}else {
				defValue = arrValue;
			}
		}
    	return defValue;
    }
}
