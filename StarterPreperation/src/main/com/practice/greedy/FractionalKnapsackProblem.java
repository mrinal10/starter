package com.practice.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Elements{
	public float weight;
	public float value;
	public float fractionalValue;
	Elements(float wt, float val){
		weight = wt;
		value = val;
		fractionalValue = value/weight;
	}
}

class fracValueSorter implements Comparator<Elements>{

	@Override
	public int compare(Elements o1, Elements o2) {
		if (o1.fractionalValue>o2.fractionalValue) {
			return -1;
		} else if (o1.fractionalValue == o2.fractionalValue) {
			return 0;
		} else {
			return 1;
		}
	}
	
}

public class FractionalKnapsackProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			Elements[] ar = new Elements[n];
			
			for (int j = 0; j < ar.length; j++) {
				float w = sc.nextFloat();
				float v = sc.nextFloat();
				Elements el = new Elements(w, v);

				ar[j] = el;
			}
			Arrays.sort(ar,new fracValueSorter());
			
			float wtLimit = sc.nextFloat();
			int indx = 0;
			float price = 0;
			while (wtLimit > 0 && indx<n) {
				System.out.println("price :: "+price);
				if(ar[indx].weight<=wtLimit){
					wtLimit = wtLimit-ar[indx].weight;
					price += ar[indx].value;
				} else if(wtLimit<ar[indx].weight){
					price += wtLimit*ar[indx].fractionalValue;
					wtLimit = 0;
				}
				indx++;
			}
			System.out.println(price);
		}
		
		sc.close();
	}
}
