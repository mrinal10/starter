package com.lenskart.Hiring03022018;

import java.util.Scanner;

class value{
	int totVal = 0;
	int index = 0;
	
	public int getTotVal() {
		return totVal;
	}
	public void setTotVal(int totVal) {
		this.totVal = totVal;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}


public class Problem1 {
	static int maxSack = 0;
	
	private static void getMinAdd(int[] ar, int sIndex, int eIndex){
		try {
			
			value minVIndex = getminValIndex(ar, sIndex, eIndex);
			if (maxSack<minVIndex.totVal) {
				maxSack = minVIndex.totVal;
			}
			if (sIndex<eIndex) {
				int intermediateIndexEnd = minVIndex.getIndex()-1;
				int intermediateIndexStart = minVIndex.getIndex()+1;
				
				getMinAdd(ar, sIndex, intermediateIndexEnd);
				getMinAdd(ar, intermediateIndexStart, eIndex);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static value getminValIndex(int[] ar, int sIndex, int eIndex){
		int min = Integer.MAX_VALUE;
		int index = 0;
		value m = new value();
		try {
			
			for (int i = sIndex; i <= eIndex; i++) {
				if (min>ar[i]) {
					index = i;
					min = ar[i];
				}
			}
	//		System.out.println("min :: "+min*(eIndex-sIndex+1));
			
			m.setIndex(index);
			m.setTotVal(min*(eIndex-sIndex+1));
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return m;
	}
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t>0) {
			t--;
			int n = sc.nextInt();
			int[] ar = new int[n];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = sc.nextInt();
			}
			getMinAdd(ar, 0, n-1);
			System.out.println(maxSack);
		}
		sc.close();
	}
}
