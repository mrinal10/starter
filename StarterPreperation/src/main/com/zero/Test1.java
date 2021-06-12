package com.zero;

import java.util.*;

public class Test1
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int t = sc.nextInt();
      	int i = 0;
		while(t-->0){
          	i++;
			int lLength = Integer.MIN_VALUE;
			int indx = 0;
          
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				s.trim();
				String[] arr = s.split(" ");
				for (int j = 0; j < arr.length; j++) {

					if (lLength<arr[j].length()) {
						lLength = arr[j].length();
						indx = j;
					}
				}
				
				System.out.println("Case "+i+": "+arr[indx]);
			}
		}
	}
}