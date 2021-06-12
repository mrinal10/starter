package com.practice.interviewbit;

import java.util.ArrayList;

public class SortedMatrixSearch {

	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    return searchMatrix(a, 0, a.size()-1, b);
	}
	
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int start, int end, int b) {
		if(start>end) {
			return 0;
		}
        int mid = (start+end)/2;
        ArrayList<Integer> find = a.get(mid);
        int strt = find.get(0);
        int ed = find.get(find.size()-1);
        if (b==strt) {
			return 1;
		}else if(b==ed) {
			return 1;
		}else if(b>strt && b<ed) {
			return binarySearch(a.get(mid),0,a.get(mid).size()-1,b);
		}else if(b>ed) {
			return searchMatrix(a, mid+1, end, b);
		}else if(b<strt) {
			return searchMatrix(a, start, mid-1, b);
		}
		return 0;
    }
	
	public int binarySearch(ArrayList<Integer> a, int start, int end, int b) {
		if(start>end) {
			return 0;
		}
        int mid = (start+end)/2;
        if(a.get(mid)==b)
        	return 1;
        if(a.get(mid)<b) {
        	return binarySearch(a, mid+1, end, b);
        }
        return binarySearch(a, start, mid-1, b);
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(3);
		a1.add(5);
		a1.add(7);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(10);
		a2.add(11);
		a2.add(16);
		a2.add(20);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(23);
		a3.add(30);
		a3.add(34);
		a3.add(50);
		
		a.add(a1);
		a.add(a2);
		a.add(a3);
		SortedMatrixSearch serach = new SortedMatrixSearch();
		System.out.println(serach.searchMatrix(a, 3));
	}

}
