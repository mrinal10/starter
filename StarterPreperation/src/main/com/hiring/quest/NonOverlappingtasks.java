package com.hiring.quest;

import java.util.*;

class Interval {
	public int startTime;
	public int endTime;

	Interval(int sTime, int eTime) {
		startTime = sTime;
		endTime = eTime;
	}

	public static boolean isOverlapping(Interval a, Interval b) {
		if (b.startTime < a.startTime && b.endTime > a.endTime) {
			return true;
		}
		if (a.startTime < b.startTime && a.endTime > b.endTime) {
			return true;
		}
		if (a.startTime == b.startTime) {
			return true;
		}
		if (a.endTime == b.endTime) {
			return true;
		}
		if (b.startTime < a.startTime && (b.endTime < a.endTime) && (b.endTime > a.startTime)) {
			return true;
		}
		if (a.startTime < b.startTime && (a.endTime < b.endTime) && (a.endTime > b.startTime)) {
			return true;
		}
		return false;
	}

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

public class NonOverlappingtasks {

	public static void main(String[] args) {

		Comparator<Interval> employeeNameComparator = new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.endTime - o2.endTime;
			}
		};

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int numberOfintervals = sc.nextInt();
			List<ArrayList<Interval>> allIntervals = new ArrayList<>();
			ArrayList<Interval> allIn = new ArrayList<>();
			int jk = 0;
			while (numberOfintervals-- > 0) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				Interval interval = new Interval(start, end);
				allIn.add(interval);
				jk++;
			}
			Collections.sort(allIn, employeeNameComparator);

			for (int i = 0; i < allIn.size(); i++) {
				Interval interval = allIn.get(i);
				if (allIntervals.isEmpty()) {
					ArrayList<Interval> intervalList = new ArrayList<>();
					intervalList.add(interval);
					allIntervals.add(intervalList);
				} else {
					boolean flag = true;
					for (int j = 0; j < allIntervals.size(); j++) {
						flag = true;
						ArrayList<Interval> ll = allIntervals.get(j);
						for (int j2 = 0; j2 < ll.size(); j2++) {
							Interval temp = ll.get(j2);
							if (Interval.isOverlapping(temp, interval)) {
								
								flag = false;
								break;
							}
						}
						if(flag){
							ll.add(interval);
							break;
						}
						
					}
					if (!flag) {
						ArrayList<Interval> intervalList = new ArrayList<>();
						intervalList.add(interval);
						allIntervals.add(intervalList);
					}
				}
			}

			int arSize = allIntervals.size();
			Integer[] arr = new Integer[arSize];
			int i = 0;
			for (int kk = 0; kk<arSize; kk++) {
				arr[i] = allIntervals.get(kk).size();
				i++;
			}
			Arrays.sort(arr, Collections.reverseOrder());

			int alice = arr[0];
			int bob = arr[1];

			for (int j = 2; j < arr.length; j++) {
				if ((j & 1) == 1) {
					bob = bob ^ arr[j];
				} else {
					alice = alice ^ arr[j];
				}
			}
			if (alice > bob) {
				System.out.println("Alice");
			} else
				System.out.println("Bob");
		}
		sc.close();
	}

}
