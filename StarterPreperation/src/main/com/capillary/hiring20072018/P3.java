package com.capillary.hiring20072018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class P3 {

	public static void main(String[] args) {
		Map<Integer, ArrayList<Integer>> roadMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int numOfCities = sc.nextInt();
			int[] happiness = new int[numOfCities];
			int maxValue = Integer.MIN_VALUE;

			Set<Integer> positiveIndexSet = new HashSet();
			for (int j = 0; j < happiness.length; j++) {
				happiness[j] = sc.nextInt();
				if (happiness[j]>maxValue) {
					maxValue = happiness[j];
				}
				if (happiness[j]>0) {
					positiveIndexSet.add(j+1);
				}
			}
			if (maxValue<=0) {
				System.out.println(maxValue);
				return;
			}
			int numOfRoads = sc.nextInt();
			int fromArray[] = new int[numOfRoads];
			int toArray[] = new int[numOfRoads];
			for (int j = 0; j < numOfRoads; j++) {
				
				fromArray[j] = sc.nextInt();
			}
			
			for (int j = 0; j < numOfRoads; j++) {
				toArray[j] = sc.nextInt();
			}
			
			for (int j = 0; j < numOfRoads; j++) {
				int too = toArray[j];
				int froom = fromArray[j];
				ArrayList<Integer> toCities;
				
				if (roadMap.containsKey(froom)) {
					toCities = roadMap.get(froom);
				}else{
					toCities = new ArrayList<>();
				}
				if (too>froom) {
					toCities.add(too);
					roadMap.put(froom, toCities);
				}
				if (roadMap.containsKey(too)) {
					toCities = roadMap.get(too);
				}else{
					toCities = new ArrayList<>();
				}
				if (too<froom) {
					toCities.add(froom);
					roadMap.put(too, toCities);
				}
			}
			
			int maxHappiness = Integer.MIN_VALUE;
			int currentHappiness = 0;
			Iterator<Integer> iterator = positiveIndexSet.iterator();
			while (iterator.hasNext()) {
				int j = iterator.next();	
				currentHappiness = 0;
				currentHappiness += happiness[j-1];
				while ( j <= numOfCities) {
					ArrayList<Integer> toCitiess = roadMap.get(j);
					if (toCitiess!=null) {
						Collections.sort(toCitiess);
						int toCurrentCity = toCitiess.get(0);
						int citiesHappiness = happiness[toCurrentCity-1];
						int maxHappinessCitiIndx = toCurrentCity-1;
						for (int k = 1; k < toCitiess.size(); k++) {
							toCurrentCity = toCitiess.get(k);
							if (citiesHappiness < happiness[toCurrentCity-1]) {
								citiesHappiness = happiness[toCurrentCity-1];
								maxHappinessCitiIndx = toCurrentCity-1;
							}
						}
						if (currentHappiness+happiness[maxHappinessCitiIndx]>=currentHappiness) {
							currentHappiness = currentHappiness+happiness[maxHappinessCitiIndx];
						}
						j = maxHappinessCitiIndx+1;
					}else{
						j = numOfCities+1;
					}
					if (currentHappiness>maxHappiness) {
						maxHappiness = currentHappiness;
					}
				}
				
			}
			
			
			System.out.println(maxHappiness);
		}
		sc.close();
	}

}
