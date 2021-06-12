package com.esko.hiring21072018;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Relation2 {
	String greaterUnit;
	String lesserUnit;
	int conversionRate;
	public Relation2(String gUnit, String lUnit, int cRate) {
		greaterUnit = gUnit;
		lesserUnit = lUnit;
		conversionRate = cRate;
	}
}

class RelationComparator2 implements Comparator<Relation2>{
	@Override
	public int compare(Relation2 o1, Relation2 o2) {
		if (o1.conversionRate>o2.conversionRate && o1.greaterUnit.equals(o2.greaterUnit)) {
			return 1;
		}else if (o1.conversionRate == o2.conversionRate && o1.greaterUnit.equals(o2.greaterUnit)) {
			return 0;
		}
		return -1;
	}
}

public class UnitBalancer2 {
	public static void main(String[] args) {
//		Long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] units = s.split(",");
		String eq = " = ";
		ArrayList<Relation2> relationList = new ArrayList<>();
		for (int i = 0; i < units.length-1; i++) {
			String leftSide = sc.next();
			eq = sc.next();
			String unit = sc.next();
			String rightSide = sc.next();
			
			Relation2 rs = new Relation2(leftSide, rightSide, Integer.parseInt(unit));
			relationList.add(rs);
		}
//		Long afterInput = System.currentTimeMillis();
//		System.out.println("checkPoint 1 >>"+(afterInput - startTime));
		HashMap<String, Relation2> map = new HashMap<>();
		String largestUnit = relationList.get(0).greaterUnit;
		for (int i = 0; i < relationList.size(); i++) {
			String unit = relationList.get(i).greaterUnit;
			map.put(unit, relationList.get(i));
			if (relationList.get(i).lesserUnit.equals(largestUnit)) {
				largestUnit = relationList.get(i).greaterUnit;
			}
		}
		
//		afterInput = System.currentTimeMillis();
//		System.out.println("checkPoint 2 >>"+(afterInput - startTime));
		
		String startingUnit = largestUnit;
		
		int curUnit = 1;
		System.out.print(curUnit+startingUnit);
		
        while (!map.isEmpty()) {
        	Relation2 relTemp = map.get(startingUnit);
        	map.remove(startingUnit);
        	try {
        		 curUnit = curUnit*relTemp.conversionRate;
        		 System.out.print(" "+eq+" " +curUnit+relTemp.lesserUnit);
                 startingUnit = relTemp.lesserUnit;
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
//        afterInput = System.currentTimeMillis();
//        System.out.println("checkPoint 3 >>"+(afterInput - startTime));
		sc.close();
	}
}
