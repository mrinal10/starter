package com.wissen.hiring27072018;

import java.util.ArrayList;
import java.util.Scanner;

class Rectangles{
	int length;
	int width;
	Rectangles(int l, int wi){
		length = l;
		width = wi;
	}
}

public class OrderRectangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totNumOfRectangles = sc.nextInt();
		try {
			ArrayList<Rectangles> listOfRectangles = new ArrayList<>();
			for (int i = 0; i < totNumOfRectangles; i++) {
				int length = sc.nextInt();
				int width = sc.nextInt();
				Rectangles rec = new Rectangles(length, width);
				if (i != 0) {
					boolean flag = true;
					for (int j = 0; j < listOfRectangles.size(); j++) {
						Rectangles currRect = listOfRectangles.get(j);
						if ((currRect.length>rec.length) || 
								((currRect.length == rec.length) 
										&& 
										(currRect.length*currRect.width)>(rec.length*rec.width)) ) {
							listOfRectangles.add(j, rec);
							flag = false;
							break;
						}
					}
					if (flag) {
						listOfRectangles.add(rec);
					}
				}else{
					listOfRectangles.add(rec);
				}
			}
			
			for (int j = 0; j < listOfRectangles.size(); j++) {
				System.out.println(listOfRectangles.get(j).length+" "+listOfRectangles.get(j).width);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
