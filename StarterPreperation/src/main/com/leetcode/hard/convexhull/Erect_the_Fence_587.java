package com.leetcode.hard.convexhull;

import java.util.ArrayList;
import java.util.List;

class Point{
	int x;
	int y;
	Point(int x_Coordinate, int y_Coordinate){
		x = x_Coordinate;
		y = y_Coordinate;
	}
}

public class Erect_the_Fence_587 {
	public static int orientation(Point p, Point q, Point r) { 
        int val = ( ((q.y - p.y) * (r.x - q.x)) - ((q.x - p.x) * (r.y - q.y)) ); 
       
        if (val == 0) 
        	return 0;  
        return (val > 0)? 1: 2; 
    } 
	
	public int[][] outerTrees(int[][] points) {
		if(points.length<3) {
			return null;
		}
		List<Point> pointList = new ArrayList<>();
		int l = 0;
		for(int i=1; i<points.length; i++) {
			if(points[i][0] < points[l][0]) {
				l = i;
			}
		}
		
		int p = l,q;
		do {
			Point pp = new Point(points[p][0], points[p][1]);
			pointList.add(pp);			
			q = (p + 1) % points.length;
            
            for (int i = 0; i < points.length; i++) {
               if (orientation(new Point(points[p][0], points[p][1]), 
            		   		   new Point(points[i][0], points[i][1]), 
            		   		   new Point(points[q][0], points[q][1])) == 2) {
                   q = i; 
               }
            } 
            p = q;
		} while(p!=l);
		
		int len = pointList.size();
		int[][] pointArr = new int[len][2];
		int i=0;
		for(Point pt: pointList) {
			pointArr[i][0] = pt.x;
			pointArr[i][1] = pt.y;
			i++;
		}
		return pointArr;
    }
	public static void main(String[] args) {
		
	}
}
