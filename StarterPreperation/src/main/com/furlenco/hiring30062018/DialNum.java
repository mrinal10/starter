package com.furlenco.hiring30062018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class ToFrom {
	int to;
	int from;
	int cost;
	public ToFrom(int t, int f, int c) {
		to = t;
		from = f;
		cost = c;
	}
}

class toFromSorter implements Comparator<ToFrom> {
	@Override
	public int compare(ToFrom o1, ToFrom o2) {
		return o1.cost - o2.cost;
	}
}

public class DialNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalValue = 0;
		int priceinHand = sc.nextInt();
		List<ArrayList<ToFrom>> uList = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			ArrayList<ToFrom> tFList = new ArrayList<>();
			uList.add(tFList);
		}
		for (int i = 0; i < 12; i++) {
			int f = sc.nextInt();
			int t = sc.nextInt();
			int c = sc.nextInt();

			ToFrom tF = new ToFrom(f, t, c);
			uList.get(t - 1).add(tF);
			ToFrom fT = new ToFrom(t, f, c);
			uList.get(f - 1).add(fT);
		}
		int sindex = 0;
		for (int i = 0; i < 9; i++) {
			ArrayList<ToFrom> tList = uList.get(i);
			uList.remove(i);
			Collections.sort(tList, new toFromSorter());

			uList.add(i, tList);
			if (uList.get(sindex).get(0).cost < uList.get(i).get(0).cost) {

			} else {
				sindex = i;
			}
		}

//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < uList.get(i).size(); j++) {
//				System.out.println(
//						uList.get(i).get(j).from + ">>>" + uList.get(i).get(j).to + ">>>" + uList.get(i).get(j).cost);
//			}
//		}
		sc.close();
		while (priceinHand >= 0) {
			priceinHand -= uList.get(sindex).get(0).cost;
			sindex = uList.get(sindex).get(0).to;
			totalValue += sindex + 1;
			sindex -= 1;

		}

		System.out.println(totalValue);
	}
}
