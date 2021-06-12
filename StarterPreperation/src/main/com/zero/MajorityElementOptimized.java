package com.zero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MajorityElementOptimized {

	int[] processArr(int[] ar){
		ArrayList<Integer> aList = new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]!=0){
				aList.add(ar[i]);
			}
		}
		int[] newAr = new int[aList.size()];
		for (int i = 0; i < newAr.length; i++) {
			newAr[i] = aList.get(i);
		}
		return newAr;
	}
	
	void printMajority(int b[]){
		
		int a[] = processArr(b);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+" ");
		}
		System.out.println();
		int trgt = a.length/2;
		HashMap<Integer, Integer> majELeMap = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!majELeMap.containsKey(a[i])) {
				majELeMap.put(a[i], 1);
			}else{
				int curCnt = majELeMap.get(a[i]);
				majELeMap.put(majELeMap.get(a[i]), curCnt++);
			}
		}
		
		for (Entry<Integer, Integer> entry: majELeMap.entrySet()) {
			if(entry.getValue()>trgt){
				System.out.print(entry.getKey());
				return;
			}
		}
		System.out.print("NONE");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
