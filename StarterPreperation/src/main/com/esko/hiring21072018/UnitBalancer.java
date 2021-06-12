package com.esko.hiring21072018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Mrinal
 *
 */
class Relation {
	String greaterUnit;
	String lesserUnit;
	int conversionRate;
	public Relation(String gUnit, String lUnit, int cRate) {
		greaterUnit = gUnit;
		lesserUnit = lUnit;
		conversionRate = cRate;
	}
}

class RelationComparator implements Comparator<Relation>{
	@Override
	public int compare(Relation o1, Relation o2) {
		if (o1.conversionRate>o2.conversionRate && o1.greaterUnit.equals(o2.greaterUnit)) {
			return 1;
		}else if (o1.conversionRate == o2.conversionRate && o1.greaterUnit.equals(o2.greaterUnit)) {
			return 0;
		}
		return -1;
	}
}

public class UnitBalancer {
	public static void main(String[] args) {
//		Long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] units = s.split(",");
		String eq = " = ";
		ArrayList<Relation> relationList = new ArrayList<>();
		for (int i = 0; i < units.length-1; i++) {
			String leftSide = sc.next();
			eq = sc.next();
			String unit = sc.next();
			String rightSide = sc.next();
			
			Relation rs = new Relation(leftSide, rightSide, Integer.parseInt(unit));
			relationList.add(rs);
		}
//		Long afterInput = System.currentTimeMillis();
//		System.out.println(afterInput - startTime);
		
		HashMap<String, ArrayList<Relation>> map = new HashMap<>();
		String largestUnit = relationList.get(0).greaterUnit;
		for (int i = 0; i < relationList.size(); i++) {
			String unit = relationList.get(i).greaterUnit;
			if (map.containsKey(unit)) {
				ArrayList<Relation> rel = map.get(unit);
				rel.add(relationList.get(i));
				map.put(unit, rel);
			}else{
				ArrayList<Relation> rel = new ArrayList<>();
				rel.add(relationList.get(i));
				map.put(unit, rel);
			}
			
			if (relationList.get(i).lesserUnit.equals(largestUnit)) {
				largestUnit = relationList.get(i).greaterUnit;
			}
		}
		
//		afterInput = System.currentTimeMillis();
//		System.out.println(afterInput - startTime);
//		
		String startingUnit = largestUnit;
		
		HashMap<String, Relation> masterMap = new HashMap<>();
		HashMap<String, Relation> slaveMap = new HashMap<>();
		int i = 0;
		while (i<=units.length) {
			creatededucedRelations(largestUnit, map, masterMap, slaveMap);
			if (i<units.length) {
				largestUnit = units[i];
			}
			i++;
		}
		int curUnit = 1;
		
//		afterInput = System.currentTimeMillis();
//		System.out.println(afterInput - startTime);
//		
		System.out.print(curUnit+startingUnit);
		int indx = 0;
        while (!masterMap.isEmpty() && indx<units.length) {
        	Relation relTemp = masterMap.get(startingUnit);
        	masterMap.remove(startingUnit);
//        	try {
        		 curUnit = curUnit*relTemp.conversionRate;
        		 System.out.print(" "+eq+" " +curUnit+relTemp.lesserUnit);
                 startingUnit = relTemp.lesserUnit;
//			} catch (Exception e) {
//			}finally {
				indx++;
//			}
        }
        
//        afterInput = System.currentTimeMillis();
//		System.out.println("Final >>> "+(afterInput - startTime));
		
		sc.close();
	}
	
	private static void creatededucedRelations(String largestUnit, HashMap<String, ArrayList<Relation>> map,
			HashMap<String, Relation> masterMap, HashMap<String, Relation> slaveMap){
		ArrayList<Relation> relationLists = map.get(largestUnit);
		if (relationLists==null) {
			return;
		}
		Collections.sort(relationLists, new RelationComparator());
		masterMap.put(relationLists.get(0).greaterUnit, relationLists.get(0));
		slaveMap.put(relationLists.get(0).lesserUnit, relationLists.get(0));
		int unitRate = relationLists.get(0).conversionRate;
		String smallerUnit = relationLists.get(0).lesserUnit;
		for (int i = 1; i < relationLists.size(); i++) {
			int unitRateBetween = relationLists.get(i).conversionRate;
			String smallerUnitBetween = "";
			String lrgerUnit = "";
			if (unitRateBetween>unitRate) {
				smallerUnitBetween = relationLists.get(i).lesserUnit;
				unitRateBetween = unitRateBetween/unitRate;
				lrgerUnit = smallerUnit;
			}else{
				lrgerUnit = relationLists.get(i).lesserUnit;
				unitRateBetween = unitRate/unitRateBetween;
				smallerUnitBetween = smallerUnit;
			}
			unitRate = unitRateBetween;
			Relation deducedRelation = new Relation(lrgerUnit, smallerUnitBetween, unitRate);
			
			if (slaveMap.containsKey(smallerUnitBetween)) {
				
			}
			
			masterMap.put(lrgerUnit, deducedRelation);
			slaveMap.put(smallerUnitBetween, deducedRelation);
		}
	}
}