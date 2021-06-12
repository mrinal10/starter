package com.practice.hackerearth;

import java.util.Scanner;

class value{
	long totVal = 0;
	long index = 0;
	
	public long getTotVal() {
		return totVal;
	}
	public void setTotVal(long totVal) {
		this.totVal = totVal;
	}
	public long getIndex() {
		return index;
	}
	public void setIndex(long index) {
		this.index = index;
	}
}


public class ThiefandWarehouses {
	static long maxSack = 0;
	
	private static void getMinAdd(long[] ar, long sIndex, long eIndex){
		try {
			
			value minVIndex = getminValIndex(ar, sIndex, eIndex);
			if (maxSack<minVIndex.totVal) {
				maxSack = minVIndex.totVal;
			}
			if (sIndex<eIndex) {
				long intermediateIndexEnd = minVIndex.getIndex()-1;
				long intermediateIndexStart = minVIndex.getIndex()+1;
				
				getMinAdd(ar, sIndex, intermediateIndexEnd);
				getMinAdd(ar, intermediateIndexStart, eIndex);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static value getminValIndex(long[] ar, long sIndex, long eIndex){
		long min = Integer.MAX_VALUE;
		long index = 0;
		value m = new value();
		try {
			
			for (long i = sIndex; i <= eIndex; i++) {
				if (min>ar[(int) i]) {
					index = i;
					min = ar[(int) i];
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
			long n = sc.nextLong();
			long[] ar = new long[(int) n];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = sc.nextLong();
			}
			getMinAdd(ar, 0, n-1);
			System.out.println(maxSack);
		}
		sc.close();
	}
}
