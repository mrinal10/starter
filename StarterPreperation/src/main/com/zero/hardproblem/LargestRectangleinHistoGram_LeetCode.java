package com.zero.hardproblem;

import java.util.*;

class RectangleStat {
	int height;
	int width;
	int area;

	public RectangleStat(int h, int w) {
		height = h;
		width = w;
		area = height * width;
	}
}

public class LargestRectangleinHistoGram_LeetCode {
	static List<ArrayList<RectangleStat>> stats;

	private static int getMaxRectangleArea(int[] heights) {
		stats = new ArrayList<ArrayList<RectangleStat>>();
		int maxV = 0;
		ArrayList<RectangleStat> list = new ArrayList<RectangleStat>();
		RectangleStat baseCase = new RectangleStat(heights[0], 1);
		if (maxV<baseCase.area) {
			maxV = baseCase.area;
		}
		list.add(baseCase);
		stats.add(list);
		
		for (int i = 1; i < heights.length; i++) {
			
			RectangleStat rectangleStat = new RectangleStat(heights[i], 1);
			ArrayList<RectangleStat> listForEach = new ArrayList<>();
			if (maxV<rectangleStat.area) {
				maxV = rectangleStat.area;
			}
			listForEach.add(rectangleStat);
			ArrayList<RectangleStat> prevRectangleStatsList = stats.get(i - 1);
			for (Iterator<RectangleStat> iterator = prevRectangleStatsList.iterator(); iterator.hasNext();) {
				RectangleStat curRectangleStat = iterator.next();
				RectangleStat newStat = new RectangleStat(Math.min(heights[i], curRectangleStat.height), curRectangleStat.width+1);
				listForEach.add(newStat);
				if (maxV<newStat.area) {
					maxV = newStat.area;
				}
			}
			stats.add(listForEach);
		}
		return maxV;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(getMaxRectangleArea(arr));
		sc.close();
	}

}
