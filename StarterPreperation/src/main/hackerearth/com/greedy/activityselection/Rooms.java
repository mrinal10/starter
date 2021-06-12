package com.greedy.activityselection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Rooms {
	static class timer{
		private int startTime;
		private int endTime;
		public int getStartTime() {
			return startTime;
		}
		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}
		public int getEndTime() {
			return endTime;
		}
		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
	}

	
	static class RatingCompare implements Comparator<timer>
	{
		public int compare(timer t1, timer t2)
		{
			if (t1.getEndTime() < t2.getEndTime()) return -1;
			if (t1.getEndTime() > t2.getEndTime()) return 1;
			else return 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i = 0;
		while (i<t) {
			int n = sc.nextInt();
			List<timer> listOfTimer = new ArrayList<timer>();
			for(int j=0; j<n; j++) {
				timer newTimer = new timer();
				newTimer.setStartTime(sc.nextInt());
				listOfTimer.add(newTimer);
			}
			for(int j=0; j<n; j++) {
				timer temp = listOfTimer.get(j);
				temp.setEndTime(temp.getStartTime()+sc.nextInt());
				listOfTimer.set(j, temp);
			}
			RatingCompare tCompare = new RatingCompare();
			Collections.sort(listOfTimer, tCompare);
			HashMap<Integer, timer> timerMap = new HashMap<Integer, timer>();

			timerMap.put(0, listOfTimer.get(0));
			for(int j=1; j<n; j++) {
				int size = timerMap.entrySet().size();
				timer tempTimer = listOfTimer.get(j);
				boolean flag = true;
				for (int k = 0; k < size; k++) {
					timer fromMap = timerMap.get(k);
					if(fromMap.getEndTime() <= tempTimer.getStartTime()) {
						timerMap.put(k, tempTimer);
						flag = false;
					}
				}
				if(flag) {
					timerMap.put(size, tempTimer);
				}
			}
			System.out.println(timerMap.entrySet().size());
			i++;
		}
		sc.close();
	}

}
