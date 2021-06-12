package com.wissen.hiring27072018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class pair{
	int x,y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}

public class FindingSubarrays {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		
		double avg = 0;
		for(int i=0; i<n; i++) {
			ar[i] = sc.nextInt();
			avg += ar[i];
		}
		
		List<pair> pairList = new ArrayList<pair>();
		avg = avg/n;
		double value = 0;
		for (int startingIndx = 0; startingIndx < ar.length; startingIndx++) {
			for (int endingIndx = startingIndx; endingIndx < ar.length; endingIndx++) {
				for(int i = startingIndx; i <= endingIndx; i++) {
					value = value + ar[i];
				}
				value = value/((endingIndx-startingIndx)+1);
				if(value>avg) {
					pair p = new pair();
					
					p.setX(startingIndx+1);
					p.setY(endingIndx+1);
					
					pairList.add(p);
				}
			}
		}
		
		System.out.println(pairList.size());
		for (int i = 0; i < pairList.size(); i++) {
			System.out.println(pairList.get(i).getX()+" "+pairList.get(i).getY());
		}
		sc.close(); 
	}
}
