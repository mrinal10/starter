package com.interviewbit;
//package com.interviewstreet;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//
//class Interval {
//	int start;
//	int end;
//
//	Interval() {
//		start = 0;
//		end = 0;
//	}
//
//	Interval(int s, int e) {
//		start = s;
//		end = e;
//	}
//}
//
//public class InsertIntervals {
//
//	public static void main(String[] args) {
//		Interval i1 = new Interval(1, 3);
//		Interval i2 = new Interval(6, 9);
//		Interval i3 = new Interval(2, 5);
//
//		ArrayList<Interval> intList = new ArrayList<>();
//		intList.add(i1);
//		intList.add(i2);
//
//		ArrayList<Interval> modList = insert(intList, i3);
//		for (int i = 0; i < modList.size(); i++) {
//			System.out.println(modList.get(i).start + " :: " + modList.get(i).end);
//		}
//	}
//
//	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
//		ArrayList<Interval> newList = new ArrayList<>();
//		int[] maxArr = new int[intervals.size() * 2 + 2];
//
//		for (int i = 0; i < intervals.size(); i += 2) {
//			maxArr[i] = intervals.get(i).start;
//			maxArr[i + 1] = intervals.get(i).end;
//		}
//		Arrays.sort(maxArr);
//		int[] maxArr = new int[intervals.size() * 2 + 2];
//
//		for (int i = 0; i < intervals.size(); i++) {
//			maxArr[intervals.get(i).end] = maxArr[intervals.get(i).end] + 1;
//			maxArr[intervals.get(i).start] = maxArr[intervals.get(i).start] - 1;
//		}
//
//		maxArr[newInterval.end] = maxArr[newInterval.end] + 1;
//		maxArr[newInterval.start] = maxArr[newInterval.start] - 1;
//
//		int indicator = 0;
//		int endIndx = 0;
//		int startIndx = 0;
//
//		for (int i = 1; i < maxArr.length; i++) {
//			if (startIndx != 0 && endIndx != 0 && indicator == 0) {
//				Interval ii = new Interval(startIndx, endIndx);
//				newList.add(ii);
//				startIndx = 0;
//				endIndx = 0;
//			}
//			if (maxArr[i] == -1) {
//				if (startIndx == 0) {
//					startIndx = i;
//				}
//				indicator = indicator - 1;
//			}
//			if (maxArr[i] == 1) {
//				endIndx = i;
//				indicator = indicator + 1;
//			}
//		}
//
//		return newList;
//	}
//
//}
